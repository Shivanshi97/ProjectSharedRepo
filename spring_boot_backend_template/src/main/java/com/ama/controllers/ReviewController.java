package com.ama.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ama.services.ReviewService;

public class ReviewController {

	//DI reviewService & ModelMapper
	@Autowired
	private ReviewService revierwService;
	@Autowired
	private ModelMapper modelMapper;
}
