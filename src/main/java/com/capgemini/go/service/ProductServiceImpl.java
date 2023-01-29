package com.capgemini.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.model.ProductModel;
import com.capgemini.go.repositories.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao prodDao;

	@Override
	public ProductModel addProduct(ProductModel product) {
		
		return prodDao.save(product);
	}

	@Override
	public ProductModel updateProduct(ProductModel product) {
		
		return prodDao.save(product);
	}

	@Override
	public String deleteProduct(ProductModel product) {
		return null;
	}

	@Override
	public ProductModel searchByBrand(String brand) {
		return null;
	}

	@Override
	public ProductModel searchByProductName(String productName) {
		return null;
	}

	@Override
	public ProductModel searchByColour(String colour) {
		return null;
	}

	@Override
	public ProductModel searchByDimension(String dimension) {
		return null;
	}

	@Override
	public List<ProductModel> filterByBrand(String brand) {
		return null;
	}

	@Override
	public List<ProductModel> sortByPrice() {
		return null;
	}

}
