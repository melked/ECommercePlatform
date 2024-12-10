package com.melikedemirtas.services.impl;

import com.melikedemirtas.entities.Cart;
import com.melikedemirtas.entities.Product;
import com.melikedemirtas.repository.CartRepository;
import com.melikedemirtas.repository.ProductRepository;
import com.melikedemirtas.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartByCustomerId(Integer customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    @Override
    public Cart emptyCart(Integer customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart == null) {
            throw new RuntimeException("Cannot empty cart: No cart found for customer ID: " + customerId);
        }
        cart.setTotalPrice(0.0);
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Integer id, Cart updatedCart) {
        Cart existingCart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with ID: " + id));

  
        existingCart.setTotalPrice(updatedCart.getTotalPrice());
        return cartRepository.save(existingCart);
    }



    @Override
    public Cart addProductToCart(Integer customerId, Integer productId, Integer quantity) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart == null) {
            throw new RuntimeException("Cart not found for customer ID: " + customerId);
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        
        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice() * quantity);
        return cartRepository.save(cart);
    }

    @Override
    public Cart removeProductFromCart(Integer customerId, Integer productId, Integer quantity) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart == null) {
            throw new RuntimeException("Cart not found for customer ID: " + customerId);
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

        double updatedTotalPrice = cart.getTotalPrice() - product.getPrice() * quantity;
        cart.setTotalPrice(Math.max(updatedTotalPrice, 0)); 
        return cartRepository.save(cart);
    }
}
