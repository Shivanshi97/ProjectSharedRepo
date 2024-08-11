package com.ama.dto;

import java.time.LocalDate;

import com.ama.entities.Booking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentDTO extends BaseDTO{

	private Long bookingId;
	private String mode; 
	private double amount;
	private LocalDate paymentDate;
	private String payStatus;
}
