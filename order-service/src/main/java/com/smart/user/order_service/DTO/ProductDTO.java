package com.smart.user.order_service.DTO;

import lombok.Data;

@Data
public class ProductDTO {

	private Long id;
	private String name;
	private double price;
	private int stock;
	
}
