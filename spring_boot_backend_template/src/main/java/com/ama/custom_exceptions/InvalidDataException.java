package com.ama.custom_exceptions;

public class InvalidDataException extends RuntimeException {
	public InvalidDataException(String mesg) {
		super(mesg);
	}
}
