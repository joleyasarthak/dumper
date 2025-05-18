package com.example.demo.service.impl;

import com.example.demo.model.OrderItem;
import com.example.demo.model.VendorProduct;
import com.example.demo.model.VendorProfile;
import com.example.demo.model.enums.ItemStatus;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Override
    public VendorProfile getVendorProfile(Long vendorId) {
        // TODO: Implement get vendor profile logic
        return null;
    }

    @Override
    public VendorProfile updateVendorProfile(Long vendorId, VendorProfile vendorProfileDetails) {
        // TODO: Implement update vendor profile logic
        return null;
    }

    @Override
    public VendorProduct addVendorProduct(Long vendorId, VendorProduct vendorProduct) {
        // TODO: Implement add vendor product logic
        return null;
    }

    @Override
    public List<VendorProduct> getVendorProducts(Long vendorId) {
        // TODO: Implement get vendor products logic
        return null;
    }

    @Override
    public VendorProduct getVendorProductById(Long vendorProductId) {
        // TODO: Implement get vendor product by id logic
        return null;
    }

    @Override
    public VendorProduct updateVendorProduct(Long vendorProductId, VendorProduct vendorProductDetails) {
        // TODO: Implement update vendor product logic
        return null;
    }

    @Override
    public void deleteVendorProduct(Long vendorProductId) {
        // TODO: Implement delete vendor product logic
    }

    @Override
    public List<OrderItem> getVendorOrderItems(Long vendorId) {
        // TODO: Implement get vendor order items logic
        return null;
    }

    @Override
    public OrderItem getVendorOrderItemDetails(Long orderItemId) {
        // TODO: Implement get vendor order item details logic
        return null;
    }

    @Override
    public OrderItem updateOrderItemStatus(Long orderItemId, ItemStatus status) {
        // TODO: Implement update order item status logic
        return null;
    }
}