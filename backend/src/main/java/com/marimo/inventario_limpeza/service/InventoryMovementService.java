package com.marimo.inventario_limpeza.service;

import com.marimo.inventario_limpeza.dto.InventoryMovementRequestDTO;
import com.marimo.inventario_limpeza.dto.InventoryMovementResponseDTO;
import com.marimo.inventario_limpeza.entity.InventoryMovement;
import com.marimo.inventario_limpeza.entity.MovementType;
import com.marimo.inventario_limpeza.entity.Product;
import com.marimo.inventario_limpeza.exception.BusinessException;
import com.marimo.inventario_limpeza.exception.ResourceNotFoundException;
import com.marimo.inventario_limpeza.repository.InventoryMovementRepository;
import com.marimo.inventario_limpeza.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryMovementService {

    private final InventoryMovementRepository movementRepository;
    private final ProductRepository productRepository;

    public InventoryMovementResponseDTO create(
            InventoryMovementRequestDTO dto) {

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Produto não encontrado"));

        if (dto.getMovementType() == MovementType.ENTRY) {

            product.setQuantity(
                    product.getQuantity() + dto.getQuantity());

        } else {

            if (product.getQuantity() < dto.getQuantity()) {
                throw new BusinessException(
                        "Quantidade insuficiente em estoque");
            }

            product.setQuantity(
                    product.getQuantity() - dto.getQuantity());
        }

        productRepository.save(product);

        InventoryMovement movement =
                InventoryMovement.builder()
                        .product(product)
                        .quantity(dto.getQuantity())
                        .movementType(dto.getMovementType())
                        .createdAt(LocalDateTime.now())
                        .build();

        InventoryMovement saved =
                movementRepository.save(movement);

        return toResponse(saved);
    }

    public List<InventoryMovementResponseDTO> findAll() {

        return movementRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private InventoryMovementResponseDTO toResponse(
            InventoryMovement movement) {

        return InventoryMovementResponseDTO.builder()
                .id(movement.getId())
                .productId(movement.getProduct().getId())
                .productName(movement.getProduct().getName())
                .quantity(movement.getQuantity())
                .movementType(movement.getMovementType())
                .createdAt(movement.getCreatedAt())
                .build();
    }

    public InventoryMovementResponseDTO findById(Long id) {

        InventoryMovement movement =
                movementRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Movimentação não encontrada"));

        return toResponse(movement);
    }
}