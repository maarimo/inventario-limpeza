package com.marimo.inventario_limpeza.dto;

import com.marimo.inventario_limpeza.entity.MovementType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class InventoryMovementResponseDTO {

    private Long id;

    private Long productId;

    private String productName;

    private Integer quantity;

    private MovementType movementType;

    private LocalDateTime createdAt;
}