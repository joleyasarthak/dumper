package com.example.demo.service;

import com.example.demo.model.CartItem;
import com.example.demo.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart getCartByCustomerId(Long customerId);
    CartItem addCartItem(Long customerId, Long vendorProductId, Integer quantity);
    CartItem updateCartItemQuantity(Long cartItemId, Integer quantity);
    void removeCartItem(Long cartItemId);
    void clearCart(Long customerId);
}