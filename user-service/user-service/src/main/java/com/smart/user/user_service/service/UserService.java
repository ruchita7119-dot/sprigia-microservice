package com.smart.user.user_service.service;

import java.util.List;

import com.smart.user.user_service.dto.UserDTO;
import com.smart.user.user_service.entity.User;

public interface UserService {

//	UserDTO createUser(User user);
	UserDTO getUserById(String id);
	List<UserDTO> getAllUsers();
	UserDTO updateUsers(String id,UserDTO userDTO);
	void deleteUser(String id);
	UserDTO getUserByEmail(String email);
	UserDTO createUser(UserDTO userDTO);
}
 