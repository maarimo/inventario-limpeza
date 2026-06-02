package com.marimo.inventario_limpeza.repository;

import com.marimo.inventario_limpeza.entity.InventoryMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryMovementRepository
        extends JpaRepository<InventoryMovement, Long> {
}