package com.example.demo.repository;

import com.example.demo.model.VendorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VendorProfileRepository extends JpaRepository<VendorProfile, Long> {
    Optional<VendorProfile> findByStoreName(String storeName);
}