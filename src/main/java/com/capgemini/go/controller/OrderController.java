package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.model.OrderModel;
import com.capgemini.go.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderSer;
	
	//http://localhost:8080/addorder
	@PostMapping("/addorder")
	public OrderModel addOrder(@RequestBody OrderModel order) {
		return orderSer.addOrder(order);
	}
}
