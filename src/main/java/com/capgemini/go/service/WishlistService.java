package com.capgemini.go.service;

import com.capgemini.go.exception.CustomerNotFoundException;
import com.capgemini.go.model.ProductModel;
import com.capgemini.go.model.WishlistModel;

public interface WishlistService {
	
	public WishlistModel viewWishlist(Integer id);
	
	public WishlistModel addProductToWishlist(ProductModel prod) throws CustomerNotFoundException;
	
}
