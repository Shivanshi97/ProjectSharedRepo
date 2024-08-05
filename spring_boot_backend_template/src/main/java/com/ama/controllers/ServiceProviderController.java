package com.ama.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ama.services.ServiceProviderService;

public class ServiceProviderController {

	//DI ServiceProviderService & ModelMapper
	@Autowired
	private ServiceProviderService serviceProviderServce;
	@Autowired
	private ModelMapper modelMapper;
}
