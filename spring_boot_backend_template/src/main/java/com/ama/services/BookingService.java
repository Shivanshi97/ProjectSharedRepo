package com.ama.services;

import java.util.List;

import com.ama.entities.Booking;

public interface BookingService {

	//for Admin
	List<Booking> viewAllBooking();
	
	//for customer
	Booking viewBooking(Long bookingId);
	
	
}
