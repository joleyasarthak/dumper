package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/customer")
    public ResponseEntity<User> registerCustomer(@RequestBody User user) {
        // TODO: Implement customer registration endpoint
        return ResponseEntity.ok(authService.registerCustomer(user));
    }

    @PostMapping("/register/vendor/apply")
    public ResponseEntity<User> applyAsVendor(@RequestBody User user) {
        // TODO: Implement vendor application endpoint
        return ResponseEntity.ok(authService.applyAsVendor(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
        // TODO: Implement login endpoint
        return ResponseEntity.ok(authService.login(email, password));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestParam String token) {
        // TODO: Implement logout endpoint
        authService.logout(token);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/password/forgot")
    public ResponseEntity<Void> forgotPassword(@RequestParam String email) {
        // TODO: Implement forgot password endpoint
        authService.forgotPassword(email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/password/reset")
    public ResponseEntity<Void> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        // TODO: Implement reset password endpoint
        authService.resetPassword(token, newPassword);
        return ResponseEntity.ok().build();
    }
}