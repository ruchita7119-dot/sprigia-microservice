package com.smart.user.order_service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.user.order_service.DTO.OrderRequest;
import com.smart.user.order_service.DTO.OrderResponse;
import com.smart.user.order_service.DTO.ProductDTO;
import com.smart.user.order_service.DTO.UserDTO;
import com.smart.user.order_service.OrderRepository.OrderRepository;
import com.smart.user.order_service.client.ProductClient;
import com.smart.user.order_service.client.UserClient;
import com.smart.user.order_service.entity.Order;
import com.smart.user.order_service.entity.OrderStatus;
import com.smart.user.order_service.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private ProductClient productClient;
	
	@Override
	public OrderResponse createOrder(OrderRequest request) {
		
		UserDTO user=userClient.getUserById(request.getUserid());
//		UserDTO user = new UserDTO();
//		user.setId(request.getUserid());
//		user.setName("Dummy User");
		
		ProductDTO product=productClient.getProductById(request.getProductid());
//		ProductDTO product=new ProductDTO();
//		user.setId(request.getProductid());
//		user.setName("lapu");
//		
		
		double totalPrice = product.getPrice()*request.getQuantity();
		
		Order order = Order.builder().userId(user.getId()).productId(product.getId()).quantity(request.getQuantity())
							.totalPrice(totalPrice).status(OrderStatus.PENDING).build();
		Order saveOrder=orderRepository.save(order);
		
		return OrderResponse.builder().Id(saveOrder.getId()).productId(saveOrder.getProductId()).quantity(saveOrder.getQuantity())
				.totalPrice(saveOrder.getTotalPrice()).status(saveOrder.getStatus().name()).build();
		
	}
	
	@Override
	public 	OrderResponse getOrder(Long id) {
		Order order = orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order not found"));
		
		return OrderResponse.builder().Id(order.getId()).userId(order.getUserId()).productId(order.getProductId())
				.quantity(order.getQuantity()).totalPrice(order.getTotalPrice()).status(order.getStatus().name()).build();
	}
	@Override
	public List<OrderResponse> getOrdersByUser(String userId){
		List<Order> orders=orderRepository.findByUserId(userId);
		
		return orders.stream().map(order->OrderResponse.builder().Id(order.getId()).userId(order.getUserId()).productId(order.getProductId())
				.quantity(order.getQuantity()).totalPrice(order.getTotalPrice()).status(order.getStatus().name()).build()).collect(Collectors.toList());
	}
}
