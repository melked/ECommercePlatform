package com.melikedemirtas.services;

import com.melikedemirtas.entities.Product;

import java.util.List;

public interface IProductService {
    Product createProduct(Product product);
    Product updateProduct(Integer productId, Product product);
    List<Product> findAll();
    void deleteProduct(Integer productId);
}
