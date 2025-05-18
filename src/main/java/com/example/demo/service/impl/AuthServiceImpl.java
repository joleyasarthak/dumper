package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public User registerCustomer(User user) {
        // TODO: Implement customer registration logic
        return null;
    }

    @Override
    public User applyAsVendor(User user) {
        // TODO: Implement vendor application logic
        return null;
    }

    @Override
    public User login(String email, String password) {
        // TODO: Implement login logic
        return null;
    }

    @Override
    public void logout(String token) {
        // TODO: Implement logout logic
    }

    @Override
    public void forgotPassword(String email) {
        // TODO: Implement forgot password logic
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        // TODO: Implement reset password logic
    }
}