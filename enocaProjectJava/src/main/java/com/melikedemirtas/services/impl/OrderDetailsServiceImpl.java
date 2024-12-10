package com.melikedemirtas.services.impl;

import com.melikedemirtas.entities.Order;
import com.melikedemirtas.entities.OrderDetails;
import com.melikedemirtas.repository.OrderDetailsRepository;
import com.melikedemirtas.repository.OrderRepository;
import com.melikedemirtas.services.IOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDetails> getDetailsByOrderId(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        return orderDetailsRepository.findAllByOrder(order);
    }
}
