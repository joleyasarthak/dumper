package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.Review;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout() {
        // TODO: Implement checkout endpoint (need to get customerId from authenticated user)
        // For now, using a placeholder customerId
        Long customerId = 1L; // Placeholder
        return ResponseEntity.ok(orderService.checkout(customerId));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrderHistory() {
        // TODO: Implement get order history endpoint (need to get customerId from authenticated user)
        // For now, using a placeholder customerId
        Long customerId = 1L; // Placeholder
        return ResponseEntity.ok(orderService.getOrderHistory(customerId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable Long orderId) {
        // TODO: Implement get order details endpoint
        return ResponseEntity.ok(orderService.getOrderDetails(orderId));
    }

    @PostMapping("/{orderId}/items/{orderItemId}/review")
    public ResponseEntity<Review> submitProductReview(@PathVariable Long orderId, @PathVariable Long orderItemId, @RequestBody Review review) {
        // TODO: Implement submit product review endpoint (need to get customerId from authenticated user)
        // For now, using a placeholder customerId
        Long customerId = 1L; // Placeholder
        return ResponseEntity.ok(orderService.submitProductReview(orderId, orderItemId, customerId, review));
    }
}