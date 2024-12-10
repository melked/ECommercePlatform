package com.melikedemirtas.services;

import com.melikedemirtas.entities.OrderDetails;

import java.util.List;

public interface IOrderDetailsService {
    List<OrderDetails> getDetailsByOrderId(Integer orderId);
}
