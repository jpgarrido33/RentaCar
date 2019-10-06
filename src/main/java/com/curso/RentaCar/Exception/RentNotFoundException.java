package com.curso.RentaCar.Exception;

public class RentNotFoundException extends Exception {

	private static final String message="Alquiler no encontrado";
	private static final long serialVersionUID = 1L;
	public RentNotFoundException() {
		super(message);
		
	}
	
	

}
