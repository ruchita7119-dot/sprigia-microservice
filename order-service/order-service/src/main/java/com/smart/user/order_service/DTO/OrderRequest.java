package com.smart.user.order_service.DTO;

import lombok.Data;

@Data
public class OrderRequest {

	private String userid;
	private Long productid;
	private int quantity;
}
