package com.capgemini.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.exception.ProductAlreadyExistsException;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.model.ProductModel;
import com.capgemini.go.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository prodRepo;

	@Override
	public ProductModel addProduct(ProductModel product) throws ProductAlreadyExistsException {
		if(prodRepo.findByProductName(product.getProductName()) != null) {
			throw new ProductAlreadyExistsException();
		}
		return prodRepo.save(product);
	}

	@Override
	public ProductModel updateProduct(ProductModel product) throws ProductNotFoundException {
		if(prodRepo.existsById(product.getProductId())) {
			return prodRepo.save(product);
		}
		throw new ProductNotFoundException();
	}

	@Override
	public String deleteProductById(Integer productId) throws ProductNotFoundException {
		if(prodRepo.existsById(productId)) {
			prodRepo.deleteById(productId);
			return "product deleted successfully";
		}
		throw new ProductNotFoundException();
	}

	@Override
	public ProductModel searchByProductName(String productName) throws ProductNotFoundException {
		ProductModel prod = prodRepo.findByProductName(productName);
		if(prod != null) {
			return prod;
		}
		throw new ProductNotFoundException();
	}

	@Override
	public List<ProductModel> searchByColour(String colour) {
		return prodRepo.findAllByColour(colour);
	}

	@Override
	public List<ProductModel> searchByDimension(String dimension) {
		return prodRepo.findAllByDimension(dimension);
	}

	@Override
	public List<ProductModel> filterByBrand(String brand) {
		return prodRepo.findAllByBrand(brand);
	}

	@Override
	public List<ProductModel> sortByPrice() {
		return prodRepo.findAllSortedByPrice();
	}

	@Override
	public List<ProductModel> getAllProducts() {
		return (List<ProductModel>) prodRepo.findAll();
	}

}
