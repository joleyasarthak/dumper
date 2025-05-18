package com.example.demo.model;

import com.example.demo.model.enums.ApprovalStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "vendorProductId", referencedColumnName = "vendorProductId")
    private VendorProduct vendorProduct;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "userId")
    private User customer; // Assuming CustomerID refers to the User entity

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;

    private Integer rating; // 1-5
    private String comment;
    private LocalDateTime reviewDate;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    @PrePersist
    protected void onCreate() {
        reviewDate = LocalDateTime.now();
    }
}