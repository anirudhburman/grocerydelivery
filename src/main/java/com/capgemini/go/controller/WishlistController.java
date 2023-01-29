package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.model.WishlistModel;
import com.capgemini.go.service.WishlistService;

@RestController
public class WishlistController {
	
	@Autowired
	WishlistService wishSer;
	
	//http://localhost:8080/addwishlist
	@PostMapping("/addwishlist")
	public WishlistModel addwishlist(@RequestBody WishlistModel wishlist) {
		return wishSer.addWishlist(wishlist);
	}
}
