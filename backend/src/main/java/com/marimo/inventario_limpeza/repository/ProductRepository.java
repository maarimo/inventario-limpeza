package com.marimo.inventario_limpeza.repository;

import com.marimo.inventario_limpeza.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByQuantityLessThanEqual(Integer quantity);

    @Query("""
       SELECT p
       FROM Product p
       WHERE p.quantity <= p.minimumQuantity
       """)
    List<Product> findLowStockProducts();

    @Query("""
       SELECT COALESCE(SUM(p.quantity), 0)
       FROM Product p
       """)
    Integer getTotalItemsInStock();
}
