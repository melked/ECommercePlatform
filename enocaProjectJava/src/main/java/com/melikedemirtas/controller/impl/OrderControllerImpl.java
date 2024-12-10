package com.melikedemirtas.controller.impl;

import com.melikedemirtas.controller.IOrderController;
import com.melikedemirtas.entities.Order;
import com.melikedemirtas.entities.OrderDetails;
import com.melikedemirtas.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/order")
public class OrderControllerImpl implements IOrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/place")
    @Override
    public Order placeOrder(@RequestParam Integer customerId, @RequestBody List<OrderDetails> orderDetailsList) {
        return orderService.placeOrder(customerId, orderDetailsList);
    }

    @GetMapping("/code/{orderCode}")
    @Override
    public Order getOrderForCode(@PathVariable String orderCode) {
        return orderService.getOrderForCode(orderCode);
    }

    @GetMapping("/customer/{customerId}")
    @Override
    public List<Order> getAllOrdersForCustomer(@PathVariable Integer customerId) {
        return orderService.getAllOrdersForCustomer(customerId);
    }
}
