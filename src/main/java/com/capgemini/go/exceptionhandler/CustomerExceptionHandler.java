package com.capgemini.go.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.go.exception.CustomerAlreadyExistsException;
import com.capgemini.go.exception.CustomerNotFoundException;
import com.capgemini.go.exception.EmptyCartException;
import com.capgemini.go.exception.EmptyWishListException;

@RestControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException() {
		return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<String> handleCustomerAlreadyExistException() {
		return new ResponseEntity<>("Customer Already Exist", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyCartException.class)
	public ResponseEntity<String> handleEmptyCartException() {
		return new ResponseEntity<>("Cart is Empty. Nothing to display!", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyWishListException.class)
	public ResponseEntity<String> handleEmptyWishListException() {
		return new ResponseEntity<>("Wishlist is Empty. Nothing to display!", HttpStatus.NOT_FOUND);
	}
}
