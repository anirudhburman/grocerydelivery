package com.capgemini.go.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.model.WishlistModel;
import com.capgemini.go.repositories.WishlistDao;

@Service
public class WishlistServiceImpl implements WishlistService {
	
	@Autowired
	WishlistDao wishDao;
	
	@Override
	public WishlistModel addWishlist(WishlistModel wishlist) {
		return wishDao.save(wishlist);
	}

}
