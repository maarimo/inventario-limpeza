package com.marimo.inventario_limpeza.service;

import com.marimo.inventario_limpeza.dto.DashboardResponseDTO;
import com.marimo.inventario_limpeza.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ProductRepository productRepository;

    public DashboardResponseDTO getDashboard() {

        long totalProducts = productRepository.count();

        int totalItemsInStock =
                productRepository.getTotalItemsInStock();

        long lowStockProducts =
                productRepository.findLowStockProducts().size();

        return DashboardResponseDTO.builder()
                .totalProducts(totalProducts)
                .totalItemsInStock(totalItemsInStock)
                .lowStockProducts(lowStockProducts)
                .build();
    }
}
