package com.ama.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ama.custom_exceptions.InvalidDataException;
import com.ama.custom_exceptions.ResourceNotFoundException;
import com.ama.dto.ApiResponse;
import com.ama.entities.Booking;
import com.ama.entities.Payment;
import com.ama.entities.User;
import com.ama.repository.BookingRepository;
import com.ama.repository.PaymentRepository;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService
{

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public List<Payment> listAllPayments() {
		return paymentRepository.findAll() //List<Category>
				.stream() //Stream<Service>
				.map(payment -> 
				modelMapper.map(payment,Payment.class)) 
				.collect(Collectors.toList());
	}
	@Override
	public ApiResponse makePayment(Payment newPayment) {
		Booking bookingId = bookingRepository
				.findById(newPayment.getBookingId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid provider id !!!!"));
		//category, provider : persistent
		//map service dto --> entity
		Payment makePayment = modelMapper.map(newPayment, Payment.class);
		//establish E-R
		//service  *--->1 category
//		category.addService(newService);
		makePayment.setBookingId(bookingId);
		//=> success
		return new ApiResponse("new blog post added ");
	}
	@Override
	public Payment viewPayment(Long paymentId) {
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(()-> new InvalidDataException("Invalid Payment Id : Data not found"));
		return payment;
	}
	
	
}
