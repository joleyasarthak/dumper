package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne
    @JoinColumn(name = "cartId", referencedColumnName = "cartId")
    private ShoppingCart cart;

    @ManyToOne
    @JoinColumn(name = "vendorProductId", referencedColumnName = "vendorProductId")
    private VendorProduct vendorProduct;

    private Integer quantity;
    private LocalDateTime addedAt;

    @PrePersist
    protected void onCreate() {
        addedAt = LocalDateTime.now();
    }
}