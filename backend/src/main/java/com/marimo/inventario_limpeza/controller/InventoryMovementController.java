package com.marimo.inventario_limpeza.controller;

import com.marimo.inventario_limpeza.dto.InventoryMovementRequestDTO;
import com.marimo.inventario_limpeza.dto.InventoryMovementResponseDTO;
import com.marimo.inventario_limpeza.service.InventoryMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
@RequiredArgsConstructor
public class InventoryMovementController {

    private final InventoryMovementService service;

    @PostMapping
    public InventoryMovementResponseDTO create(
            @RequestBody InventoryMovementRequestDTO dto) {

        return service.create(dto);
    }

    @GetMapping
    public List<InventoryMovementResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public InventoryMovementResponseDTO findById(
            @PathVariable Long id) {

        return service.findById(id);
    }
}