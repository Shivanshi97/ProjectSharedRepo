package com.ama.services;

import java.util.List;

import com.ama.entities.User;

public interface UserService {

	List<User> getAllUsers();
	
	User registration(User newUser);		//use validateUser()
	
	String login(String email, String password);		//use authenticateUser()
	
	String edit(Long id);
	
	String delete(Long id);
	
	User viewUser();
}
