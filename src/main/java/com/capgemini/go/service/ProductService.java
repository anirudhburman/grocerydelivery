package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.exception.product.ProductAlreadyExistsException;
import com.capgemini.go.exception.product.ProductNotFoundException;
import com.capgemini.go.model.ProductModel;

public interface ProductService {
	
	public ProductModel addProduct(ProductModel product) throws ProductAlreadyExistsException;
	
	public ProductModel updateProduct(ProductModel product) throws ProductNotFoundException;
	
	public String deleteProductById(Integer productId) throws ProductNotFoundException;
	
	public ProductModel searchByProductName(String productName) throws ProductNotFoundException;
	
	public List<ProductModel> searchByColour(String colour);

	public List<ProductModel> searchByDimension(String dimension);
	
	public List<ProductModel> filterByBrand(String brand);
	
	public List<ProductModel> sortByPrice();
	
	public List<ProductModel> getAllProducts();
}
