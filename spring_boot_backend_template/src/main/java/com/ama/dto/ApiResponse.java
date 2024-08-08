package com.ama.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ApiResponse {

	private String message;
	private LocalDateTime timeStamp;

	//default constructor
	public ApiResponse() {}

	//parameterized constructor
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}
}
