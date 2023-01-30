package com.capgemini.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.model.ProductModel;
import com.capgemini.go.model.WishlistModel;
import com.capgemini.go.repositories.WishlistDao;

@Service
public class WishlistServiceImpl implements WishlistService {
	
	@Autowired
	WishlistDao wishDao;

	@Override
	public WishlistModel addProducts(List<ProductModel> product) {
		return null;
	}

	@Override
	public WishlistModel viewWishlist() {
		return null;
	}

}
