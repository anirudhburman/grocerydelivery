package com.capgemini.go.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.go.exception.AddressNotFoundException;

@RestControllerAdvice
public class AddressExceptionHandler {
	
	@ExceptionHandler(AddressNotFoundException.class)
	public String handleUserNotFoundException() {
		return "Address not found";
	}
}
