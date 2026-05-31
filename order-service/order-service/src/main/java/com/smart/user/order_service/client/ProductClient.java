package com.smart.user.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.smart.user.order_service.DTO.ProductDTO;

@FeignClient(name="PRODUCT-SERVICE",url="http://localhost:8082")
public interface ProductClient {

	@GetMapping("/product/{id}")
	ProductDTO getProductById(@PathVariable ("id") Long id);
}
