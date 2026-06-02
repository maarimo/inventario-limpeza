package com.marimo.inventario_limpeza.repository;

import com.marimo.inventario_limpeza.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
