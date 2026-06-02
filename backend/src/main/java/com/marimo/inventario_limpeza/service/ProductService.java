package com.marimo.inventario_limpeza.service;

import com.marimo.inventario_limpeza.dto.ProductRequestDTO;
import com.marimo.inventario_limpeza.dto.ProductResponseDTO;
import com.marimo.inventario_limpeza.entity.Product;
import com.marimo.inventario_limpeza.exception.ResourceNotFoundException;
import com.marimo.inventario_limpeza.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public ProductResponseDTO save(ProductRequestDTO dto) {

        Product product = Product.builder()
                .name(dto.getName())
                .unit(dto.getUnit())
                .quantity(dto.getQuantity())
                .minimumQuantity(dto.getMinimumQuantity())
                .build();

        Product saved = repository.save(product);

        return toResponse(saved);
    }

    public List<ProductResponseDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ProductResponseDTO findById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        return toResponse(product);
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        product.setName(dto.getName());
        product.setUnit(dto.getUnit());
        product.setQuantity(dto.getQuantity());
        product.setMinimumQuantity(dto.getMinimumQuantity());

        Product updated = repository.save(product);

        return toResponse(updated);
    }

    public void delete(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        repository.delete(product);
    }

    private ProductResponseDTO toResponse(Product product) {

        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .unit(product.getUnit())
                .quantity(product.getQuantity())
                .minimumQuantity(product.getMinimumQuantity())
                .build();
    }
}
