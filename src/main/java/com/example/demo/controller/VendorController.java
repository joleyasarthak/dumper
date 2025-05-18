package com.example.demo.controller;

import com.example.demo.model.OrderItem;
import com.example.demo.model.VendorProduct;
import com.example.demo.model.VendorProfile;
import com.example.demo.model.enums.ItemStatus;
import com.example.demo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    // Vendor Profile Endpoints
    @GetMapping("/profile")
    public ResponseEntity<VendorProfile> getVendorProfile() {
        // TODO: Implement get vendor profile endpoint (need to get vendorId from authenticated user)
        // For now, using a placeholder vendorId
        Long vendorId = 1L; // Placeholder
        return ResponseEntity.ok(vendorService.getVendorProfile(vendorId));
    }

    @PutMapping("/profile")
    public ResponseEntity<VendorProfile> updateVendorProfile(@RequestBody VendorProfile vendorProfileDetails) {
        // TODO: Implement update vendor profile endpoint (need to get vendorId from authenticated user)
        // For now, using a placeholder vendorId
        Long vendorId = 1L; // Placeholder
        return ResponseEntity.ok(vendorService.updateVendorProfile(vendorId, vendorProfileDetails));
    }

    // Vendor Product Listings (Offers) Endpoints
    @PostMapping("/products")
    public ResponseEntity<VendorProduct> addVendorProduct(@RequestBody VendorProduct vendorProduct) {
        // TODO: Implement add vendor product endpoint (need to get vendorId from authenticated user)
        // For now, using a placeholder vendorId
        Long vendorId = 1L; // Placeholder
        return ResponseEntity.ok(vendorService.addVendorProduct(vendorId, vendorProduct));
    }

    @GetMapping("/products")
    public ResponseEntity<List<VendorProduct>> getVendorProducts() {
        // TODO: Implement get vendor products endpoint (need to get vendorId from authenticated user)
        // For now, using a placeholder vendorId
        Long vendorId = 1L; // Placeholder
        return ResponseEntity.ok(vendorService.getVendorProducts(vendorId));
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<VendorProduct> getVendorProductById(@PathVariable("productId") Long vendorProductId) {
        // TODO: Implement get vendor product by id endpoint
        return ResponseEntity.ok(vendorService.getVendorProductById(vendorProductId));
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<VendorProduct> updateVendorProduct(@PathVariable("productId") Long vendorProductId, @RequestBody VendorProduct vendorProductDetails) {
        // TODO: Implement update vendor product endpoint
        return ResponseEntity.ok(vendorService.updateVendorProduct(vendorProductId, vendorProductDetails));
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteVendorProduct(@PathVariable("productId") Long vendorProductId) {
        // TODO: Implement delete vendor product endpoint
        vendorService.deleteVendorProduct(vendorProductId);
        return ResponseEntity.ok().build();
    }

    // Orders Endpoints
    @GetMapping("/orders")
    public ResponseEntity<List<OrderItem>> getVendorOrderItems() {
        // TODO: Implement get vendor order items endpoint (need to get vendorId from authenticated user)
        // For now, using a placeholder vendorId
        Long vendorId = 1L; // Placeholder
        return ResponseEntity.ok(vendorService.getVendorOrderItems(vendorId));
    }

    @GetMapping("/orders/items/{orderItemId}")
    public ResponseEntity<OrderItem> getVendorOrderItemDetails(@PathVariable Long orderItemId) {
        // TODO: Implement get vendor order item details endpoint
        return ResponseEntity.ok(vendorService.getVendorOrderItemDetails(orderItemId));
    }

    @PutMapping("/orders/items/{orderItemId}/status")
    public ResponseEntity<OrderItem> updateOrderItemStatus(@PathVariable Long orderItemId, @RequestParam ItemStatus status) {
        // TODO: Implement update order item status endpoint
        return ResponseEntity.ok(vendorService.updateOrderItemStatus(orderItemId, status));
    }
}