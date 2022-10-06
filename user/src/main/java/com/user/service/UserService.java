package com.user.service;


import com.user.entity.User;

import java.util.List;



	public interface UserService {
		
		public User saveUser(User user);
		
		public User getUserById(int userId);
		
		public List<User> getAllUsers();
		
		public void deleteUSer(int userId);
		
		public User updateUser(User user);
		
		public User doLogin(String userRole, String password,String userName);	
	
		
		
		
		

	
}
