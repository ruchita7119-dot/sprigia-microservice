package com.smart.user.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.user.product_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
}
