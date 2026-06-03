package com.marimo.inventario_limpeza.controller;

import com.marimo.inventario_limpeza.dto.DashboardResponseDTO;
import com.marimo.inventario_limpeza.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardResponseDTO> getDashboard() {

        return ResponseEntity.ok(
                dashboardService.getDashboard()
        );
    }
}
