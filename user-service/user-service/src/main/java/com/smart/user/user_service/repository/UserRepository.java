package com.smart.user.user_service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smart.user.user_service.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{
	Optional<User> findByEmail(String email);
}
