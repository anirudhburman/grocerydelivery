package com.capgemini.go.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.exception.CustomerNotFoundException;
import com.capgemini.go.model.CustomerModel;
import com.capgemini.go.model.ProductModel;
import com.capgemini.go.model.WishlistModel;
import com.capgemini.go.repositories.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {
	
	@Autowired
	WishlistRepository wishRepo;
	
	@Autowired
	CustomerService custSer;

	@Override
	public WishlistModel viewWishlist(Integer id) {
		return wishRepo.findById(id).get();
	}

	@Override
	public WishlistModel addProductToWishlist(ProductModel prod) throws CustomerNotFoundException {
		
		CustomerModel cust = custSer.getCustomerById(10);
		WishlistModel wishList = custSer.getWishListByCustId(10);
		if(wishList == null) {
			wishList = new WishlistModel();
			List<ProductModel> list = new ArrayList<>();
			wishList.setCustomer(cust);
			wishList.setProducts(list);
		}
		List<ProductModel> prods = wishList.getProducts();
		prods.add(prod);
		wishList.setProducts(prods);
		cust.setWishlist(wishList);
		wishRepo.save(wishList);
		return wishList;
	}

}
