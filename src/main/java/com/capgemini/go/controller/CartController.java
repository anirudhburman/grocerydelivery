package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.model.CartModel;
import com.capgemini.go.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartSer;
	
	//http://localhost:8080/addcart
	@PostMapping("/addcart")
	public CartModel addCart(@RequestBody CartModel cart) {
		return cartSer.addCart(cart);
	}
}
