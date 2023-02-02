package com.capgemini.go.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.go.exception.ProductAlreadyExistsException;
import com.capgemini.go.exception.ProductNotFoundException;

@RestControllerAdvice
public class ProductExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public String handleProductNotFoundException() {
		return "Product not found";
	}
	
	@ExceptionHandler(ProductAlreadyExistsException.class)
	public String handleProductAlreadyExistException() {
		return "Product Already Exist";
	}
}
