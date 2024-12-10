package com.melikedemirtas.controller.impl;

import com.melikedemirtas.controller.IProductController;
import com.melikedemirtas.entities.Product;
import com.melikedemirtas.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/product")
public class ProductControllerImpl implements IProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/create")
    @Override
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/update/{productId}")
    @Override
    public Product updateProduct(@PathVariable Integer productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }

    @GetMapping("/all")
    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @DeleteMapping("/delete/{productId}")
    @Override
    public void deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
    }
}
