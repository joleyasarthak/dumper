package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.Review;

import java.util.List;

public interface OrderService {
    Order checkout(Long customerId);
    List<Order> getOrderHistory(Long customerId);
    Order getOrderDetails(Long orderId);
    Review submitProductReview(Long orderId, Long orderItemId, Long customerId, Review review);
}