package com.marimo.inventario_limpeza.dto;


import lombok.*;

@Data
@Builder
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String unit;
    private Integer quantity;
    private Integer minimumQuantity;
}
