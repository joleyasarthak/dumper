package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/me")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getCurrentUser() {
        // TODO: Implement get current user endpoint
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @PutMapping
    public ResponseEntity<User> updateCurrentUser(@RequestBody User userDetails) {
        // TODO: Implement update current user endpoint
        return ResponseEntity.ok(userService.updateCurrentUser(userDetails));
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getUserAddresses() {
        // TODO: Implement get user addresses endpoint (need to get userId from authenticated user)
        // For now, using a placeholder userId
        Long userId = 1L; // Placeholder
        return ResponseEntity.ok(userService.getUserAddresses(userId));
    }

    @PostMapping("/addresses")
    public ResponseEntity<Address> addUserAddress(@RequestBody Address address) {
        // TODO: Implement add user address endpoint (need to get userId from authenticated user)
        // For now, using a placeholder userId
        Long userId = 1L; // Placeholder
        return ResponseEntity.ok(userService.addUserAddress(userId, address));
    }

    @PutMapping("/addresses/{addressId}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long addressId, @RequestBody Address addressDetails) {
        // TODO: Implement update address endpoint
        return ResponseEntity.ok(userService.updateAddress(addressId, addressDetails));
    }

    @DeleteMapping("/addresses/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long addressId) {
        // TODO: Implement delete address endpoint
        userService.deleteAddress(addressId);
        return ResponseEntity.ok().build();
    }
}