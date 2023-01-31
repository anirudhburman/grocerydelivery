package com.capgemini.go.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.go.exception.order.OrderNotFoundException;

@RestControllerAdvice
public class OrderExceptionHandler {
	
	@ExceptionHandler(OrderNotFoundException.class)
	public String handleUserNotFoundException() {
		return "Order not found";
	}
}
