package com.marimo.inventario_limpeza.controller;

import com.marimo.inventario_limpeza.dto.ProductRequestDTO;
import com.marimo.inventario_limpeza.dto.ProductResponseDTO;
import com.marimo.inventario_limpeza.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ProductResponseDTO create(
            @Valid @RequestBody ProductRequestDTO request) {

        return service.save(request);
    }

    @GetMapping
    public List<ProductResponseDTO> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
