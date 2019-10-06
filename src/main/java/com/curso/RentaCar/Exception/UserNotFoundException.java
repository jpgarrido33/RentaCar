package com.curso.RentaCar.Exception;

	public class UserNotFoundException extends Exception{

	
		private static final long serialVersionUID = 1L;
		private static final String message = "Ususario no encontrado";
		
		public UserNotFoundException() {
			
			super(message);

			
		}
}
