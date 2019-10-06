package com.curso.RentaCar.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CarNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String message="Coche no encontrado";

	public CarNotFoundException() {
		super(message);
		
	}

	public CarNotFoundException(String message) {
	
	}


	
}
