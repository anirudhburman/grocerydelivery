package com.capgemini.go.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.model.WishlistModel;
import com.capgemini.go.repositories.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {
	
	@Autowired
	WishlistRepository wishDao;

	@Override
	public WishlistModel viewWishlist(Integer id) {
		return wishDao.findById(id).get();
	}

}
