package com.example.demo.service;

import com.example.demo.model.ProductCategory;
import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getAllCategories();
    ProductCategory createCategory(ProductCategory category);
    ProductCategory updateCategory(Long categoryId, ProductCategory categoryDetails);
    void deleteCategory(Long categoryId);
}