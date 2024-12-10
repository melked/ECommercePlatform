package com.melikedemirtas.controller.impl;

import com.melikedemirtas.controller.ICartController;
import com.melikedemirtas.entities.Cart;
import com.melikedemirtas.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/cart")
public class CartControllerImpl implements ICartController {

    @Autowired
    private ICartService cartService;

    @PostMapping("/save")
    @Override
    public Cart saveCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }

    @GetMapping("/customer/{customerId}")
    @Override
    public Cart getCartByCustomerId(@PathVariable Integer customerId) {
        return cartService.getCartByCustomerId(customerId);
    }

    @PutMapping("/empty/{customerId}")
    @Override
    public Cart emptyCart(@PathVariable Integer customerId) {
        return cartService.emptyCart(customerId);
    }

    
    @PutMapping("/update/{id}")
    @Override
    public Cart updateCart(@PathVariable Integer id, @RequestBody Cart updatedCart) {
        return cartService.updateCart(id, updatedCart);
    }

    
    @PostMapping("/add-product")
    @Override
    public Cart addProductToCart(@RequestParam Integer customerId,
                                 @RequestParam Integer productId,
                                 @RequestParam Integer quantity) {
        return cartService.addProductToCart(customerId, productId, quantity);
    }

    @PostMapping("/remove-product")
    @Override
    public Cart removeProductFromCart(@RequestParam Integer customerId,
                                      @RequestParam Integer productId,
                                      @RequestParam Integer quantity) {
        return cartService.removeProductFromCart(customerId, productId, quantity);
    }
}
