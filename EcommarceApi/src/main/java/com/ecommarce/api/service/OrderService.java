package com.ecommarce.api.service;

import java.util.List;

import com.ecommarce.api.dto.OrderDto;
import com.ecommarce.api.entity.Order;

public interface OrderService {

	public boolean createOrder(OrderDto orderDto);
	public List<Order> getAllOrder();

}
