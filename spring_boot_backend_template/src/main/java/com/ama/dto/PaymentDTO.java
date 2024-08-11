package com.ama.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentDTO extends BaseDTO{

	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private Long bookingId;
	private String mode; 
	private double amount;
	private LocalDate paymentDate;
	private String payStatus;
}
