package com.user.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.exception.AuthenticationFailedException;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	
	

	@Override
	public User saveUser(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not existing with Id:" + userId);

		}
		User user = optionalUser.get();

		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	@Override
	public void deleteUSer(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not existing with Id:" + userId);

		}
		
		userRepository.deleteById(userId);

	}

	@Override
	public User updateUser(User user) {
		Optional<User> optionalUser = userRepository.findById(user.getUserId());
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not existing with Id:" + user.getUserId());

		}

		User updatedUser = userRepository.save(user);

		return updatedUser;
	}

	

	@Override
	public User doLogin(String userName, String password,String userRole) {
		User user = userRepository.login(userName, password, userRole);
		if (user == null) {
			throw new AuthenticationFailedException("Username or password Invalid!!");
		}
		return user;
	}

	

}
