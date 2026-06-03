package com.marimo.inventario_limpeza.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DashboardResponseDTO {

    private Long totalProducts;
    private Integer totalItemsInStock;
    private Long lowStockProducts;
}
