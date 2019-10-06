package com.curso.RentaCar.Exception;

public class CarNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String message="Coche no encontrado";

	public CarNotFoundException() {
		super(message);
		
	}

	public CarNotFoundException(String message) {
	
	}


	
}
