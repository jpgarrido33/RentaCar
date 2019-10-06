package com.curso.RentaCar.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.curso.RentaCar.Exception.UserNotFoundException;
import com.curso.RentaCar.Exception.CarNotFoundException;
import com.curso.RentaCar.Exception.RentNotFoundException;
import com.curso.RentaCar.Exception.UpdateErrorException;


@ControllerAdvice
public class ControllerExceptionAdvice {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CarNotFoundException.class)
	public Exception CarNotFoundException(CarNotFoundException notFoundException) throws CarNotFoundException {
		return notFoundException;
	}
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UpdateErrorException.class)
	public Exception UpdateErrorException(UpdateErrorException notFoundException) throws UpdateErrorException {
		return notFoundException;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RentNotFoundException.class)
	public Exception RentNotFoundException(RentNotFoundException notFoundException) throws RentNotFoundException {
		return notFoundException;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public Exception UserNotFoundException(UserNotFoundException notFoundException) throws UserNotFoundException {
		return notFoundException;
	}
	
	
	
}
