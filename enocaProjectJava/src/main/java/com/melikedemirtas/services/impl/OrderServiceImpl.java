package com.melikedemirtas.services.impl;

import com.melikedemirtas.entities.*;
import com.melikedemirtas.repository.*;
import com.melikedemirtas.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Order placeOrder(Integer customerId, List<OrderDetails> orderDetailsList) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        order.setOrderCode(UUID.randomUUID().toString());

        double totalPrice = 0.0;

        for (OrderDetails orderDetails : orderDetailsList) {
            Product product = productRepository.findById(orderDetails.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStock() < orderDetails.getQuantity()) {
                throw new RuntimeException("Not enough stock for product: " + product.getName());
            }

            product.setStock(product.getStock() - orderDetails.getQuantity());
            productRepository.save(product);

            orderDetails.setOrder(order);
            orderDetails.setPrice(product.getPrice());
            orderDetails.setSubtotal(product.getPrice() * orderDetails.getQuantity());
            totalPrice += orderDetails.getSubtotal();
        }

        order.setTotalPrice(totalPrice);
        orderRepository.save(order);
        orderDetailsRepository.saveAll(orderDetailsList);
       

        return order;
    }

    @Override
    public Order getOrderForCode(String orderCode) {
        return orderRepository.findByOrderCode(orderCode);
    }

    @Override
    public List<Order> getAllOrdersForCustomer(Integer customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}
