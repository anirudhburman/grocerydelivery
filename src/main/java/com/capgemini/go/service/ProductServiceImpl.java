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
	public String deleteProductById(Integer productId) {
		prodDao.deleteById(productId);
		return "product deleted successfully";
	}

	@Override
	public ProductModel searchByProductName(String productName) {
		return prodDao.findByProductName(productName);
	}

	@Override
	public ProductModel searchByColour(String colour) {
		return prodDao.findByColour(colour);
	}

	@Override
	public ProductModel searchByDimension(String dimension) {
		return prodDao.findByDimension(dimension);
	}

	@Override
	public List<ProductModel> filterByBrand(String brand) {
		return (List<ProductModel>) prodDao.findAllByBrand(brand);
	}

	@Override
	public List<ProductModel> sortByPrice() {
		return prodDao.findAllSortedByPrice();
	}

	@Override
	public List<ProductModel> getAllProducts() {
		return (List<ProductModel>) prodDao.findAll();
	}

}
