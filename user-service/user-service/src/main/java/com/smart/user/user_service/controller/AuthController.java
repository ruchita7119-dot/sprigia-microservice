package com.smart.user.user_service.controller;

import java.time.Instant;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.user.user_service.dto.LoginRequest;
import com.smart.user.user_service.dto.RegisterRequest;
import com.smart.user.user_service.entity.User;
import com.smart.user.user_service.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final JwtEncoder jwtEncoder;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public AuthController(JwtEncoder jwtEncoder,UserRepository userRepository,PasswordEncoder passwordEncoder) {
		this.jwtEncoder=jwtEncoder;
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		User user =userRepository.findByEmail(request.email())
				.orElseThrow(()->new RuntimeException("Invalid email or password"));
		
		if(!"Active".equalsIgnoreCase(user.getStatus())) {
			throw new RuntimeException("User account is inactive");
		}
		if(!passwordEncoder.matches(request.password(), user.getPassword())) {
			throw new RuntimeException("Invalid email or password");
		}
		
//		if(!request.username().equals("admin")||!request.password().equals("admin")) {
//			throw new RuntimeException("Invalid Credentials");
//		}
		Instant now=Instant.now();
		
		JwtClaimsSet claims=JwtClaimsSet.builder()
				.issuer("user-service")
				.issuedAt(now)
				.expiresAt(now.plusSeconds(3600))
				.subject(user.getEmail())
				.claim("name", user.getName())
				.build();
		return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
		 
	}
	
	@PostMapping("/register")
	public String register(@RequestBody RegisterRequest request){
		if(userRepository.findByEmail(request.email()).isPresent()) {
			throw new RuntimeException("Email already registered");
		}
		User user = User.builder()
				.name(request.name())
				.email(request.email())
				.phone(request.phone())
			    .password(passwordEncoder.encode(request.password()
			    		))
			    .status("Active")
			    .role("Role_USER").build();
		userRepository.save(user);
		return "User registered successfully";
	}
}
