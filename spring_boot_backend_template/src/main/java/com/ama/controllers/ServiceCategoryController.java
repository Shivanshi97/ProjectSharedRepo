package com.ama.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ama.services.AMACategoryService;

public class ServiceCategoryController {

	//DI AMACategoryService & ModelMapper
	@Autowired
	private AMACategoryService categoryService;
	@Autowired
	private ModelMapper modelMapper;
}
