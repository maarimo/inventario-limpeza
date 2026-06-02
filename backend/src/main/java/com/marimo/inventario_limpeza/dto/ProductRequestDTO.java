package com.marimo.inventario_limpeza.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class ProductRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String unit;

    @Min(0)
    private Integer quantity;

    @Min(0)
    private Integer minimumQuantity;
}
