package com.smart.user.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart.user.user_service.dto.UserDTO;
import com.smart.user.user_service.entity.User;
import com.smart.user.user_service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {
		return userService.createUser(userDTO);
	}
	
	@GetMapping
	public List<UserDTO> getAllUser(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public UserDTO getUsersById(@PathVariable String id ) {
		return userService.getUserById(id);
	}
	
	@PutMapping("/{id}")
	public UserDTO updateUsers(@PathVariable String id,@RequestBody UserDTO userDTO) {
		return userService.updateUsers(id, userDTO);
	}
	
	@DeleteMapping("/{id}")
	public  void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/email")
	public UserDTO getUserByEmailID(@RequestParam String email) {
		return userService.getUserByEmail(email);
	}
	
}

