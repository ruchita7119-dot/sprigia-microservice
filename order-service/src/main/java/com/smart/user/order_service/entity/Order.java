package com.smart.user.order_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="product_id")
	private Long productId;
	
	@Column(name="quantity",nullable=false)
	private int quantity;
	
	@Column(name="total_price")
	private double totalPrice;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@Column(name="created_time")
	private LocalDateTime createdAt;
	
	
}
