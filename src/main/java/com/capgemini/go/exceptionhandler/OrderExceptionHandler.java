package com.capgemini.go.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.go.exception.OrderNotFoundException;

@RestControllerAdvice
public class OrderExceptionHandler {
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> handleOrderNotFoundException() {
		return new ResponseEntity<String>("Order not found", HttpStatus.NOT_FOUND);
	}
}
