package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.model.ProductModel;
import com.capgemini.go.model.WishlistModel;

public interface WishlistService {
	
	public WishlistModel addProducts(List<ProductModel> product);
	
}
