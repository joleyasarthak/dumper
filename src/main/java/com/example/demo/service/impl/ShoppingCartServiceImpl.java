package com.example.demo.service.impl;

import com.example.demo.model.CartItem;
import com.example.demo.model.ShoppingCart;
import com.example.demo.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Override
    public ShoppingCart getCartByCustomerId(Long customerId) {
        // TODO: Implement get cart by customer id logic
        return null;
    }

    @Override
    public CartItem addCartItem(Long customerId, Long vendorProductId, Integer quantity) {
        // TODO: Implement add cart item logic
        return null;
    }

    @Override
    public CartItem updateCartItemQuantity(Long cartItemId, Integer quantity) {
        // TODO: Implement update cart item quantity logic
        return null;
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        // TODO: Implement remove cart item logic
    }

    @Override
    public void clearCart(Long customerId) {
        // TODO: Implement clear cart logic
    }
}