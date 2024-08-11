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
public class ReviewDTO extends BaseDTO{

	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private Long bookingId;
	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private Long customerId;
	private int rating;
	private String comment;
	private LocalDate reviewDate;
}
