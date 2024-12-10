package com.melikedemirtas.repository;

import com.melikedemirtas.entities.Order;
import com.melikedemirtas.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
    List<OrderDetails> findAllByOrder(Order order); // Belirli bir siparişin detaylarını getir
}
