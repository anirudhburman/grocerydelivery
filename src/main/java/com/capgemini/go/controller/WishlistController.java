package com.capgemini.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.exception.CustomerNotFoundException;
import com.capgemini.go.exception.ProductAlreadyExistsException;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.model.ProductModel;
import com.capgemini.go.model.WishlistModel;
import com.capgemini.go.service.WishlistService;

@RestController
@CrossOrigin
public class WishlistController {
	
	@Autowired
	WishlistService wishSer;
	
	// http://localhost:8080/getwishlist/{id}
	@GetMapping("/getwishlist/{id}")
	public WishlistModel viewWishlist(@PathVariable("id") Integer id) {
		return wishSer.viewWishlist(id);
	}

	/**
	 * http://localhost:8080/addtowishlist/{wishId}/{cartId}
	 * 
	 * @param wishId
	 * @param prodId
	 * @return
	 * @throws CustomerNotFoundException
	 * @throws ProductNotFoundException
	 * @throws ProductAlreadyExistsException 
	 */
	@PostMapping("/addproducttowishlist/{wishId}/{prodId}")
	public List<ProductModel> addProductToWishlist(@PathVariable("wishId") Integer wishId, @PathVariable("prodId") Integer prodId) throws ProductNotFoundException, ProductAlreadyExistsException {
		return wishSer.addProductToWishlist(wishId, prodId);
	}

	// Update Wishlist

	/**
	 * http://localhost:8080/addtowishlist/{wishId}/{cartId}
	 * 
	 * @param wishId
	 * @param prodId
	 * @return
	 * @throws CustomerNotFoundException
	 * @throws ProductNotFoundException
	 */
	@PostMapping("/deleteproductfromwishlist/{wishId}/{prodId}")
	public List<ProductModel> deleteProductFromWishlist(@PathVariable("wishId") Integer wishId, @PathVariable("prodId") Integer prodId) throws ProductNotFoundException {
		return wishSer.deleteProductFromWishlist(wishId, prodId);
	}

	// http://localhost:8080/getcartproducts/{cartid}
	@GetMapping("/getwishproducts/{wishid}")
	public List<ProductModel> getWishListProducts(@PathVariable("wishid") Integer wishId) {
		return wishSer.getAllWishProducts(wishId);
	}
}
