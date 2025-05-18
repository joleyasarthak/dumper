package com.example.demo.controller;

import com.example.demo.model.ProductCategory;
import com.example.demo.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<ProductCategory>> getAllCategories() {
        // TODO: Implement get all categories endpoint
        return ResponseEntity.ok(productCategoryService.getAllCategories());
    }

    @PostMapping("/admin/categories")
    public ResponseEntity<ProductCategory> createCategory(@RequestBody ProductCategory category) {
        // TODO: Implement create category endpoint (Admin only)
        return ResponseEntity.ok(productCategoryService.createCategory(category));
    }

    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<ProductCategory> updateCategory(@PathVariable Long categoryId, @RequestBody ProductCategory categoryDetails) {
        // TODO: Implement update category endpoint (Admin only)
        return ResponseEntity.ok(productCategoryService.updateCategory(categoryId, categoryDetails));
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
        // TODO: Implement delete category endpoint (Admin only)
        productCategoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }
}