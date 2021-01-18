package com.kosify.car_shop_api.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosify.car_shop_api.entity.User;
import com.kosify.car_shop_api.exception.ResourceNotFoundException;
import com.kosify.car_shop_api.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with "+ id)); 
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("user")
	public List<User> getUserlist(){
		return userRepository.findAll();
	}
	
	@PostMapping("user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("user")
	public User updateUser(@Validated @RequestBody User user) throws ResourceNotFoundException {
		// avoiding to create new user
		if(null == user.getUserId())
			throw new ResourceNotFoundException("Cannot update a user without an id!");
		return userRepository.save(user);
	}
	
	@DeleteMapping("user/{id}")
	public String deleteUser(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {
		Optional<User> user = userRepository.findById(id) ;
		if(user.isPresent()) {
			userRepository.delete(user.get());
			return "User was deleted!";
		} else {
			throw new ResourceNotFoundException("Could not find user with id: " + id);
		}
	}
}
