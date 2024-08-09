package com.ama.services;

import java.util.List;

import com.ama.dto.BookingDTO;
import com.ama.entities.Booking;

public interface BookingService {

	//for Admin
	List<BookingDTO> viewAllBooking();
	
	//for customer
	Booking viewBooking(Long bookingId);
	
	
}
