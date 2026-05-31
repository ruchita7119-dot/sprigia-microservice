package com.smart.user.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.smart.user.order_service.DTO.UserDTO;

@FeignClient(name="USER-SERVICE",url="http://localhost:8081")
public interface UserClient {

	@GetMapping("/users/{id}")
	UserDTO getUserById(@PathVariable("id") String id);
	
}
