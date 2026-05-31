package com.smart.user.user_service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.user.user_service.dto.UserDTO;
import com.smart.user.user_service.entity.User;
import com.smart.user.user_service.repository.UserRepository;
import com.smart.user.user_service.service.UserService;

@Service
public class UserServiceImpl implements UserService{
 
	@Autowired
	private UserRepository userRepository;
	
	private User toEntity(UserDTO dto) {
		return new User(dto.getId(),dto.getName(),dto.getEmail(),dto.getPhone(),dto.getStatus(),dto.getPassword(),dto.getRole());
	}
	private UserDTO toDTO(User user) {
		return new UserDTO(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.getStatus(),user.getPassword(),user.getRole());
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User saved=userRepository.save(toEntity(userDTO));
		return toDTO(saved);
	}

	@Override
	public UserDTO getUserById(String id) {
		// TODO Auto-generated method stub
		
		return userRepository.findById(id).map(this::toDTO).orElse(null);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUsers(String id, UserDTO userDTO) {
		// TODO Auto-generated method stub
		User existing=userRepository.findById(id).orElse(null);
		
		if(existing==null) return null;
		
		existing.setName(userDTO.getName());
		existing.setEmail(userDTO.getEmail());
		existing.setPhone(userDTO.getPhone());
		existing.setStatus(userDTO.getStatus());
		
		
		return null;
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user =userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Invalid email or password"));
				
		return user!=null?toDTO(user):null;
	}
}
