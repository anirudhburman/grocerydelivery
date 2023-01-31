package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.model.WishlistModel;
import com.capgemini.go.service.WishlistService;

@RestController
public class WishlistController {
	
	@Autowired
	WishlistService wishSer;
	
	//http://localhost:8080/getwishlist/{id}
	@GetMapping("/getwishlist/{id}")
	public WishlistModel viewWishlist(@PathVariable("id") Integer id) {
		return wishSer.viewWishlist(id);
	}
	
}
