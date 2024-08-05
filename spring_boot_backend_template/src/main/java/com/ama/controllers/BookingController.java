package com.ama.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ama.services.BookingService;

public class BookingController {

	
	//DI BookingService & ModelMapper
	@Autowired
	private BookingService bookingService;
	@Autowired
	private ModelMapper modelMapper;
}
