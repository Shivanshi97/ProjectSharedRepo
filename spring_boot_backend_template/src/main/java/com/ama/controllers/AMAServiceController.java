package com.ama.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ama.services.AMAService;

public class AMAServiceController {

	//DI AMAService & ModelMapper
	@Autowired
	private AMAService amaService;
	@Autowired
	private ModelMapper modelMapper;
}
