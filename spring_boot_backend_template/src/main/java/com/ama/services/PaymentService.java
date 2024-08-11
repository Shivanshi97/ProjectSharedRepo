package com.ama.services;

import java.util.List;

import com.ama.dto.ApiResponse;
import com.ama.entities.Payment;

public interface PaymentService {

	//for admin
	List<Payment> listAllPayments();
	
	//for customer
	ApiResponse makePayment(Payment payment);
	
	Payment viewPayment(Long paymentId);
}
