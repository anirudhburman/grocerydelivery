package com.capgemini.go.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.model.CartModel;
import com.capgemini.go.repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;

	@Override
	public CartModel viewCartById(Integer id) {
		return cartRepo.findById(id).get();
	}

	// Add product to Cart

	// Update Cart

	// Delete product from Cart
}
