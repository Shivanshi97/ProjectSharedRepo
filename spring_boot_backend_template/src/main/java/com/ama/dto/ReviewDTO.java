package com.ama.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewDTO extends BaseDTO{

	private Long bookingId;
	private Long customerId;
	private int rating;
	private String comment;
	private LocalDate reviewDate;
}
