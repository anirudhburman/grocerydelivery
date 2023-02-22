package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.exception.CustomerNotFoundException;
import com.capgemini.go.model.ProductModel;
import com.capgemini.go.model.WishlistModel;
import com.capgemini.go.service.WishlistService;

@RestController
@CrossOrigin
public class WishlistController {
	
	@Autowired
	WishlistService wishSer;
	
	//http://localhost:8080/getwishlist/{id}
	@GetMapping("/getwishlist/{id}")
	public WishlistModel viewWishlist(@PathVariable("id") Integer id) {
		return wishSer.viewWishlist(id);
	}
	
	// Add product to Wishlist
	@PostMapping("/addtowishlist")
	public WishlistModel addProductToWishlist(@RequestBody ProductModel prod) throws CustomerNotFoundException {
		return wishSer.addProductToWishlist(prod);
	}
	
	// Update Wishlist
	
	// Delete product from wishlist
	
}
