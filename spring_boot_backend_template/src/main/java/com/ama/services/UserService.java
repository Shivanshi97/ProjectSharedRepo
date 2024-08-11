package com.ama.services;

import java.util.List;

import com.ama.dto.UserDTO;
import com.ama.entities.User;

public interface UserService {

	List<UserDTO> getAllUsers();
	
	User registration(User newUser);		//use validateUser()
	
	User login(String email, String password);		//use authenticateUser()
	
	String edit(Long id);
	
	String delete(Long id);
	
	User viewUser(Long userId);
}
