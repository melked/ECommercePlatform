package com.melikedemirtas.controller;

import com.melikedemirtas.entities.OrderDetails;

import java.util.List;

public interface IOrderDetailsController {
    List<OrderDetails> getDetailsByOrderId(Integer orderId);
}
