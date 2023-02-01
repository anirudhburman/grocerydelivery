package com.capgemini.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.exception.product.ProductAlreadyExistsException;
import com.capgemini.go.exception.product.ProductNotFoundException;
import com.capgemini.go.model.ProductModel;
import com.capgemini.go.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository prodDao;

	@Override
	public ProductModel addProduct(ProductModel product) throws ProductAlreadyExistsException {
		if(prodDao.findByProductName(product.getProductName()) != null) {
			throw new ProductAlreadyExistsException();
		}
		return prodDao.save(product);
	}

	@Override
	public ProductModel updateProduct(ProductModel product) throws ProductNotFoundException {
		if(prodDao.existsById(product.getProductId())) {
			return prodDao.save(product);
		}
		throw new ProductNotFoundException();
	}

	@Override
	public String deleteProductById(Integer productId) throws ProductNotFoundException {
		if(prodDao.existsById(productId)) {
			prodDao.deleteById(productId);
			return "product deleted successfully";
		}
		throw new ProductNotFoundException();
	}

	@Override
	public ProductModel searchByProductName(String productName) throws ProductNotFoundException {
		ProductModel prod = prodDao.findByProductName(productName);
		if(prod != null) {
			return prod;
		}
		throw new ProductNotFoundException();
	}

	@Override
	public List<ProductModel> searchByColour(String colour) {
		return prodDao.findAllByColour(colour);
	}

	@Override
	public List<ProductModel> searchByDimension(String dimension) {
		return prodDao.findAllByDimension(dimension);
	}

	@Override
	public List<ProductModel> filterByBrand(String brand) {
		return prodDao.findAllByBrand(brand);
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
