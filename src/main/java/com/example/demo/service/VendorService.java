package com.example.demo.service;

import com.example.demo.model.OrderItem;
import com.example.demo.model.VendorProduct;
import com.example.demo.model.VendorProfile;
import com.example.demo.model.enums.ItemStatus;

import java.util.List;

public interface VendorService {
    VendorProfile getVendorProfile(Long vendorId);
    VendorProfile updateVendorProfile(Long vendorId, VendorProfile vendorProfileDetails);

    VendorProduct addVendorProduct(Long vendorId, VendorProduct vendorProduct);
    List<VendorProduct> getVendorProducts(Long vendorId);
    VendorProduct getVendorProductById(Long vendorProductId);
    VendorProduct updateVendorProduct(Long vendorProductId, VendorProduct vendorProductDetails);
    void deleteVendorProduct(Long vendorProductId);

    List<OrderItem> getVendorOrderItems(Long vendorId);
    OrderItem getVendorOrderItemDetails(Long orderItemId);
    OrderItem updateOrderItemStatus(Long orderItemId, ItemStatus status);
}