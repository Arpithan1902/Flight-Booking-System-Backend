package com.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.LoginRequest;
import com.user.entity.LoginResponse;
import com.user.entity.User;
import com.user.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:3000/")
@RequestMapping("/user")

public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> signin(@RequestBody LoginRequest loginRequest) {
		User user = userService.doLogin(loginRequest.getUserName(), loginRequest.getPassword(),loginRequest.getUserRole());

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setUserId(user.getUserId());
		loginResponse.setUserName(user.getUserName());
		loginResponse.setUserRole(user.getUserRole());
		loginResponse.setPassword(user.getPassword());
		
		

		ResponseEntity<LoginResponse> responseEntity = new ResponseEntity<>(loginResponse, HttpStatus.OK);
		return responseEntity;

	}

	
	@PostMapping("/save")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User newUser = userService.saveUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(newUser, HttpStatus.CREATED);
		return responseEntity;

	}

	

	@GetMapping("/get/{userId}")
	public ResponseEntity<User> fetchUserDetails(@PathVariable("userId") int userId) {
		User user = userService.getUserById(userId);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/all")
	public List<User> fetchAllUsers() {
		List<User> userLsit = userService.getAllUsers();
		return userLsit;
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> removeUser(@PathVariable("userId") int userId) {
		userService.deleteUSer(userId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("User deleted successfully!!", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/user/update")
	public ResponseEntity<User> modifyUser(@RequestBody User user) {
		User updateUser = userService.updateUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(updateUser, HttpStatus.OK);
		return responseEntity;
	}

}
