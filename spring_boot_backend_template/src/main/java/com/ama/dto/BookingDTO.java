package com.ama.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookingDTO extends BaseDTO{

	private String serviceName;
	private Long serviceId;
	private Long providerId;
	private String providerName;
	private LocalDate bookingDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String status;
}
