package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for simplicity in this example, enable in production
            .authorizeHttpRequests(authorize -> authorize
                // Public endpoints
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/catalog-products/**").permitAll()
                .requestMatchers("/categories/**").permitAll()

                // Customer endpoints
                .requestMatchers("/customer/**").hasRole("CUSTOMER")

                // Vendor endpoints
                .requestMatchers("/vendor/**").hasRole("VENDOR")

                // Admin endpoints
                .requestMatchers("/admin/**").hasRole("ADMIN")

                // User profile endpoints (accessible by logged-in users)
                .requestMatchers("/users/me/**").authenticated()


                // All other requests require authentication
                .anyRequest().authenticated()
            )
            .httpBasic(); // Enable HTTP Basic Authentication

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // This is an in-memory user store for demonstration purposes.
        // Replace with a database-backed implementation later.
        UserDetails customer = User.builder()
            .username("customer")
            .password(passwordEncoder.encode("password"))
            .roles("CUSTOMER")
            .build();

        UserDetails vendor = User.builder()
            .username("vendor")
            .password(passwordEncoder.encode("password"))
            .roles("VENDOR")
            .build();

        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder.encode("password"))
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(customer, vendor, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}