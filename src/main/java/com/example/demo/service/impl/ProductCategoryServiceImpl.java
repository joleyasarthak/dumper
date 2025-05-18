package com.example.demo.service.impl;

import com.example.demo.model.ProductCategory;
import com.example.demo.service.ProductCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Override
    public List<ProductCategory> getAllCategories() {
        // TODO: Implement logic to get all categories
        return null;
    }

    @Override
    public ProductCategory createCategory(ProductCategory category) {
        // TODO: Implement logic to create category
        return null;
    }

    @Override
    public ProductCategory updateCategory(Long categoryId, ProductCategory categoryDetails) {
        // TODO: Implement logic to update category
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        // TODO: Implement logic to delete category
    }
}