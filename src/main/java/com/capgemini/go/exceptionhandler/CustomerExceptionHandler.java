package com.capgemini.go.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.go.exception.customer.CustomerAlreadyExistsException;
import com.capgemini.go.exception.customer.CustomerNotFoundException;
import com.capgemini.go.exception.customer.EmptyCartException;
import com.capgemini.go.exception.customer.EmptyWishListException;

@RestControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public String handleUserNotFoundException() {
		return "Customer not found";
	}
	
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public String handleUserAlreadyExistException() {
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
