package com.curso.RentaCar.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UpdateErrorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UpdateErrorException() {

		}

	public UpdateErrorException(String message) {
		super(message);	
	}



	
}
