package com.melikedemirtas.controller;

import com.melikedemirtas.entities.Product;
import java.util.List;

public interface IProductController {
    Product createProduct(Product product);
    Product updateProduct(Integer productId, Product product);
    List<Product> findAll();
    void deleteProduct(Integer productId);
}
