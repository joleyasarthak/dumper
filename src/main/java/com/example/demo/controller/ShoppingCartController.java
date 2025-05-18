package com.example.demo.controller;

import com.example.demo.model.CartItem;
import com.example.demo.model.ShoppingCart;
import com.example.demo.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping
    public ResponseEntity<ShoppingCart> viewCart() {
        // TODO: Implement view cart endpoint (need to get customerId from authenticated user)
        // For now, using a placeholder customerId
        Long customerId = 1L; // Placeholder
        return ResponseEntity.ok(shoppingCartService.getCartByCustomerId(customerId));
    }

    @PostMapping("/items")
    public ResponseEntity<CartItem> addCartItem(@RequestParam Long vendorProductId, @RequestParam Integer quantity) {
        // TODO: Implement add item to cart endpoint (need to get customerId from authenticated user)
        // For now, using a placeholder customerId
        Long customerId = 1L; // Placeholder
        return ResponseEntity.ok(shoppingCartService.addCartItem(customerId, vendorProductId, quantity));
    }

    @PutMapping("/items/{cartItemId}")
    public ResponseEntity<CartItem> updateCartItemQuantity(@PathVariable Long cartItemId, @RequestParam Integer quantity) {
        // TODO: Implement update cart item quantity endpoint
        return ResponseEntity.ok(shoppingCartService.updateCartItemQuantity(cartItemId, quantity));
    }

    @DeleteMapping("/items/{cartItemId}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long cartItemId) {
        // TODO: Implement remove cart item endpoint
        shoppingCartService.removeCartItem(cartItemId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearCart() {
        // TODO: Implement clear cart endpoint (need to get customerId from authenticated user)
        // For now, using a placeholder customerId
        Long customerId = 1L; // Placeholder
        shoppingCartService.clearCart(customerId);
        return ResponseEntity.ok().build();
    }
}