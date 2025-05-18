package com.example.demo.service.impl;

import com.example.demo.model.Order;
import com.example.demo.model.Review;
import com.example.demo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order checkout(Long customerId) {
        // TODO: Implement checkout logic
        return null;
    }

    @Override
    public List<Order> getOrderHistory(Long customerId) {
        // TODO: Implement get order history logic
        return null;
    }

    @Override
    public Order getOrderDetails(Long orderId) {
        // TODO: Implement get order details logic
        return null;
    }

    @Override
    public Review submitProductReview(Long orderId, Long orderItemId, Long customerId, Review review) {
        // TODO: Implement submit product review logic
        return null;
    }
}