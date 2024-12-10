package com.melikedemirtas.controller.impl;

import com.melikedemirtas.controller.IOrderDetailsController;
import com.melikedemirtas.entities.OrderDetails;
import com.melikedemirtas.services.IOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/order-details")
public class OrderDetailsControllerImpl implements IOrderDetailsController {

    @Autowired
    private IOrderDetailsService orderDetailsService;

    @GetMapping("/order/{orderId}")
    @Override
    public List<OrderDetails> getDetailsByOrderId(@PathVariable Integer orderId) {
        return orderDetailsService.getDetailsByOrderId(orderId);
    }
}
