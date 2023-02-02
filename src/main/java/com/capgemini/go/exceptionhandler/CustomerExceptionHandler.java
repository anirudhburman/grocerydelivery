package com.capgemini.go.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.go.exception.CustomerAlreadyExistsException;
import com.capgemini.go.exception.CustomerNotFoundException;
import com.capgemini.go.exception.EmptyCartException;
import com.capgemini.go.exception.EmptyWishListException;

@RestControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public String handleCustomerNotFoundException() {
		return "Customer not found";
	}
	
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public String handleCustomerAlreadyExistException() {
		return "Customer Already Exist";
	}
	
	@ExceptionHandler(EmptyCartException.class)
	public String handleEmptyCartException() {
		return "Cart is Empty. Nothing to display!";
	}
	
	@ExceptionHandler(EmptyWishListException.class)
	public String handleEmptyWishListException() {
		return "Wishlist is Empty. Nothing to display!";
	}
}
