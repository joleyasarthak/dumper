package com.example.demo.model;

import com.example.demo.model.enums.ItemStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "vendorProductId", referencedColumnName = "vendorProductId")
    private VendorProduct vendorProduct;

    private Integer quantity;
    private BigDecimal priceAtPurchase;
    private BigDecimal subtotal;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;
}