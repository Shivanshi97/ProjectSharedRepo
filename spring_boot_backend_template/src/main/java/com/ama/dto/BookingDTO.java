package com.ama.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookingDTO extends BaseDTO{

	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private String serviceName;
	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private Long serviceId;
	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private Long providerId;
	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private String providerName;
	private LocalDate bookingDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String status;
}
