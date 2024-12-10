package com.melikedemirtas.controller;

import com.melikedemirtas.entities.Cart;

public interface ICartController {
    Cart saveCart(Cart cart);
    Cart getCartByCustomerId(Integer customerId);
    Cart emptyCart(Integer customerId);
    Cart updateCart(Integer cartId, Cart updatedCart);
    Cart addProductToCart(Integer customerId, Integer productId, Integer quantity);
    Cart removeProductFromCart(Integer customerId, Integer productId, Integer quantity);
}
