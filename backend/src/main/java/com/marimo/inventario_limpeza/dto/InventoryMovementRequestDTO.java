package com.marimo.inventario_limpeza.dto;

import com.marimo.inventario_limpeza.entity.MovementType;
import lombok.Data;

@Data
public class InventoryMovementRequestDTO {

    private Long productId;

    private Integer quantity;

    private MovementType movementType;
}
