package com.ama.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ama.services.PaymentService;

public class PayementController {

	//DI PaymentService Model mapper
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private ModelMapper modelMapper;
}
