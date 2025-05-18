package com.example.demo.repository;

import com.example.demo.model.VendorProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VendorProductRepository extends JpaRepository<VendorProduct, Long> {
    Optional<VendorProduct> findBySKU(String sku);
}