package com.curso.RentaCar.Controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import com.curso.RentaCar.Exception.Error;
import com.curso.RentaCar.Exception.UserNotFoundException;
import com.curso.RentaCar.Exception.CarNotFoundException;
import com.curso.RentaCar.Exception.RentNotFoundException;
import com.curso.RentaCar.Exception.UpdateErrorException;


@ControllerAdvice
public class ControllerExceptionAdvice {
	
	 private Error errorDetail;
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class) 
	public ResponseEntity<Error> userNotFoundException(UserNotFoundException ex, WebRequest request) {
	errorDetail = new Error(new Date(), ex.getMessage(), request.getDescription(false));
	return new ResponseEntity<Error>(errorDetail, HttpStatus.NOT_FOUND); 
	}
	
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CarNotFoundException.class)
	public ResponseEntity<Error> carNotFoundException(CarNotFoundException ex, WebRequest request) {
	errorDetail = new Error(new Date(), ex.getMessage(), request.getDescription(false));
	return new ResponseEntity<Error>(errorDetail, HttpStatus.NOT_FOUND); 
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UpdateErrorException.class)
	public ResponseEntity<Error> updateErrorException(UpdateErrorException ex, WebRequest request) {
		errorDetail = new Error(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Error>(errorDetail, HttpStatus.NOT_FOUND); 
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RentNotFoundException.class)
	public ResponseEntity<Error> rentNotFoundException(RentNotFoundException ex, WebRequest request) {
		errorDetail = new Error(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Error>(errorDetail, HttpStatus.NOT_FOUND);
	}
	
}
