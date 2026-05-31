package com.smart.user.order_service.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {

	private Long Id;
	private String userId;
	private Long productId;
	private int quantity;
	private double totalPrice;
	private String status;
	
}
