package com.example.demo.service;

import com.example.demo.model.User;

public interface AuthService {
    User registerCustomer(User user);
    User applyAsVendor(User user);
    User login(String email, String password);
    void logout(String token); // Assuming token-based logout for now
    void forgotPassword(String email);
    void resetPassword(String String, String newPassword);
}