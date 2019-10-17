package com.curso.RentaCar.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

	
	public class UserNotFoundException extends Exception{

	

		private static final long serialVersionUID = 4141349107592585110L;
		private static final String message = "Ususario no encontrado";
		
		public UserNotFoundException() {
			
			super(message);

			
		}		
		
		

}
