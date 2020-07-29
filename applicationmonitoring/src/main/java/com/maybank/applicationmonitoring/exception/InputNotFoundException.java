package com.maybank.applicationmonitoring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InputNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6346025302423996206L;

	public InputNotFoundException(String message) {
		super(message);
	}
}
