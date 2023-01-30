package com.capgemini.go.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.model.CartModel;
import com.capgemini.go.repositories.CartDao;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDao cartDao;

	@Override
	public CartModel addAProductToCart(CartModel cart) {
		return null;
	}

}
