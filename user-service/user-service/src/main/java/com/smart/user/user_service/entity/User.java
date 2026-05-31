package com.smart.user.user_service.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	 

	@Id
	private String id;
	
	private String name;
	private String email;
	private String phone;
	private String status;
	
	private String password;
	private String role;
}
