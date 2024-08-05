package com.ama.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ama.services.UserService;

public class UserController {

	//DI service & model mapper
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;
	
	
	
}
