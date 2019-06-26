package com.mercadito.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadito.entity.User;
import com.mercadito.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user, BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="id") Long userId){
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}
}
