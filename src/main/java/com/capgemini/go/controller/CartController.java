package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.model.CartModel;
import com.capgemini.go.service.CartService;

@RestController
@CrossOrigin
public class CartController {

	@Autowired
	CartService cartSer;
	
	/**
	 * http://localhost:8080/viewcart/{id}
	 * @param id
	 * @return
	 */
	@GetMapping("/viewcart/{id}")
	public CartModel viewCart(@PathVariable("id") Integer id) {
		return cartSer.viewCartById(id);
	}
	
}
