package com.smart.user.order_service.OrderRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.user.order_service.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
	List<Order> findByUserId(String userId);
}
