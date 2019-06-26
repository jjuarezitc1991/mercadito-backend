package com.mercadito.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadito.entity.User;
import com.mercadito.exception.ResourceNotFoundException;
import com.mercadito.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(final User user) {
		return this.userRepository.save(user);
	}
	
	public void delete(Long userId) {
		User user = this.userRepository.findById(userId).orElse(null);
		this.userRepository.delete(user);
	}
	
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>(); 
		this.userRepository.findAll().forEach(userList::add);
		
		return userList;
	}
	
	public User getUserById(Long userId) {
		return this.userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	}
}
