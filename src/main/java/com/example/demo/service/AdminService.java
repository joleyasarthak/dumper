package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.model.VendorProfile;
import com.example.demo.model.VendorProduct;
import com.example.demo.model.enums.OverallOrderStatus;
import com.example.demo.model.enums.Role;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers();
    User getUserDetails(Long userId);
    User updateUserRole(Long userId, Role role);

    List<VendorProfile> getAllVendorApplications();
    VendorProfile approveVendorApplication(Long applicationId);
    VendorProfile rejectVendorApplication(Long applicationId);

    List<VendorProduct> getPendingVendorProductApprovals();
    VendorProduct approveVendorProduct(Long vendorProductId);
    VendorProduct rejectVendorProduct(Long vendorProductId);

    List<Order> getAllOrders();
    Order getOrderDetails(Long orderId);
    Order updateOrderStatus(Long orderId, OverallOrderStatus status);
    void deleteReview(Long reviewId);
}