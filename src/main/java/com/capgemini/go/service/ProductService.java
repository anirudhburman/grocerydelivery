package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.model.ProductModel;

public interface ProductService {
	
	public ProductModel addProduct(ProductModel product);
	
	public ProductModel updateProduct(ProductModel product);
	
	public String deleteProductById(Integer productId);
	
	public ProductModel searchByProductName(String productName);
	
	public ProductModel searchByColour(String colour);

	public ProductModel searchByDimension(String dimension);
	
	public List<ProductModel> filterByBrand(String brand);
	
	public List<ProductModel> sortByPrice();
	
	public List<ProductModel> getAllProducts();
}
