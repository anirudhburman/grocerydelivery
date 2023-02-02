package com.capgemini.go.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.go.exception.UserNotFoundException;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException() {
		return new ResponseEntity<>("Address not found", HttpStatus.NOT_FOUND);
	}
}
