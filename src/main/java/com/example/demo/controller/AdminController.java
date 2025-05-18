package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.model.VendorProfile;
import com.example.demo.model.VendorProduct;
import com.example.demo.model.enums.OverallOrderStatus;
import com.example.demo.model.enums.Role;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Users Endpoints
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        // TODO: Implement get all users endpoint (Admin only)
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable Long userId) {
        // TODO: Implement get user details endpoint (Admin only)
        return ResponseEntity.ok(adminService.getUserDetails(userId));
    }

    @PutMapping("/users/{userId}/role")
    public ResponseEntity<User> updateUserRole(@PathVariable Long userId, @RequestParam Role role) {
        // TODO: Implement update user role endpoint (Admin only)
        return ResponseEntity.ok(adminService.updateUserRole(userId, role));
    }

    // Vendor Applications Endpoints
    @GetMapping("/vendor-applications")
    public ResponseEntity<List<VendorProfile>> getAllVendorApplications() {
        // TODO: Implement get all vendor applications endpoint (Admin only)
        return ResponseEntity.ok(adminService.getAllVendorApplications());
    }

    @PutMapping("/vendor-applications/{applicationId}/approve")
    public ResponseEntity<VendorProfile> approveVendorApplication(@PathVariable Long applicationId) {
        // TODO: Implement approve vendor application endpoint (Admin only)
        return ResponseEntity.ok(adminService.approveVendorApplication(applicationId));
    }

    @PutMapping("/vendor-applications/{applicationId}/reject")
    public ResponseEntity<VendorProfile> rejectVendorApplication(@PathVariable Long applicationId) {
        // TODO: Implement reject vendor application endpoint (Admin only)
        return ResponseEntity.ok(adminService.rejectVendorApplication(applicationId));
    }

    // Vendor Product Approval Endpoints
    @GetMapping("/vendor-products/pending-approval")
    public ResponseEntity<List<VendorProduct>> getPendingVendorProductApprovals() {
        // TODO: Implement get pending vendor product approvals endpoint (Admin only)
        return ResponseEntity.ok(adminService.getPendingVendorProductApprovals());
    }

    @PutMapping("/vendor-products/{vendorProductId}/approve")
    public ResponseEntity<VendorProduct> approveVendorProduct(@PathVariable Long vendorProductId) {
        // TODO: Implement approve vendor product endpoint (Admin only)
        return ResponseEntity.ok(adminService.approveVendorProduct(vendorProductId));
    }

    @PutMapping("/vendor-products/{vendorProductId}/reject")
    public ResponseEntity<VendorProduct> rejectVendorProduct(@PathVariable Long vendorProductId) {
        // TODO: Implement reject vendor product endpoint (Admin only)
        return ResponseEntity.ok(adminService.rejectVendorProduct(vendorProductId));
    }

    // Orders & Reviews Endpoints
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        // TODO: Implement get all orders endpoint (Admin only)
        return ResponseEntity.ok(adminService.getAllOrders());
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable Long orderId) {
        // TODO: Implement get order details endpoint (Admin only)
        return ResponseEntity.ok(adminService.getOrderDetails(orderId));
    }

    @PutMapping("/orders/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestParam OverallOrderStatus status) {
        // TODO: Implement update order status endpoint (Admin only)
        return ResponseEntity.ok(adminService.updateOrderStatus(orderId, status));
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        // TODO: Implement delete review endpoint (Admin only)
        adminService.deleteReview(reviewId);
        return ResponseEntity.ok().build();
    }
}