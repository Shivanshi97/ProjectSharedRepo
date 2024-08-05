package com.ama.services;

import java.util.List;

import com.ama.entities.Payment;

public interface PaymentService {

	//for admin
	List<Payment> listAllPayments();
	
	//for customer
	Payment makePayment(Payment payment);
	
	Payment viewPayment();
}
