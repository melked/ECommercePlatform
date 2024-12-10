package com.melikedemirtas.repository;

import com.melikedemirtas.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByCustomerId(Integer customerId);
}
