package com.example.demo.model;

import com.example.demo.model.enums.ApprovalStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class VendorProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorProductId;

    @ManyToOne
    @JoinColumn(name = "catalogProductId", referencedColumnName = "catalogProductId")
    private ProductCatalog productCatalog;

    @ManyToOne
    @JoinColumn(name = "vendorId", referencedColumnName = "vendorId")
    private VendorProfile vendor;

    private String SKU; // Unique per vendor

    private BigDecimal price;
    private Integer stockQuantity;

    @ManyToOne
    @JoinColumn(name = "shippingAddressId", referencedColumnName = "addressId")
    private Address shippingAddress; // Assuming ShippingAddressID refers to the Address entity

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    private Boolean isActive;
    private BigDecimal averageRating; // Calculated

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}