package com.capgemini.go.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.go.exception.product.ProductAlreadyExistsException;
import com.capgemini.go.exception.product.ProductNotFoundException;

@RestControllerAdvice
public class ProductExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public String handleUserNotFoundException() {
		return "Product not found";
	}
	
	@ExceptionHandler(ProductAlreadyExistsException.class)
	public String handleUserAlreadyExistException() {
		return "Product Already Exist";
	}
}
