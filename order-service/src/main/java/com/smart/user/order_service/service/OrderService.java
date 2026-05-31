package com.smart.user.order_service.service;

import java.util.List;

import com.smart.user.order_service.DTO.OrderRequest;
import com.smart.user.order_service.DTO.OrderResponse;

public interface OrderService {

	OrderResponse createOrder(OrderRequest request);
	OrderResponse getOrder(Long id);
	List<OrderResponse> getOrdersByUser(String userId);
}
