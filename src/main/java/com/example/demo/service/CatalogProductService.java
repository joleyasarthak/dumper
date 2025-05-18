package com.example.demo.service;

import com.example.demo.model.ProductCatalog;
import java.util.List;

public interface CatalogProductService {
    List<ProductCatalog> getAllApprovedCatalogProducts();
    ProductCatalog getCatalogProductById(Long id);
    ProductCatalog createCatalogProduct(ProductCatalog productCatalog);
    ProductCatalog updateCatalogProduct(Long id, ProductCatalog productCatalogDetails);
    void deleteCatalogProduct(Long id);
}