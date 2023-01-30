package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartSer;
	
	//http://localhost:8080/
	
}
