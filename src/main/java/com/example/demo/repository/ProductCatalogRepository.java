package com.example.demo.repository;

import com.example.demo.model.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Long> {
    Optional<ProductCatalog> findByName(String name);
}