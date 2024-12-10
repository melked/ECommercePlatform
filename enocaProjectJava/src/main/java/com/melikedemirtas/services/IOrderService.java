package com.melikedemirtas.services;

import com.melikedemirtas.entities.Order;
import com.melikedemirtas.entities.OrderDetails;
import java.util.List;

public interface IOrderService {
	Order placeOrder(Integer customerId, List<OrderDetails> orderDetailsList);
    Order getOrderForCode(String orderCode);
    List<Order> getAllOrdersForCustomer(Integer customerId);
}
