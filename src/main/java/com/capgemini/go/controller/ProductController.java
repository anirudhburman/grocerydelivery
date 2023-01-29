package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.model.ProductModel;
import com.capgemini.go.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService prodSer;
	
	//http://localhost:8080/addproduct
	@PostMapping("/addproduct")
	public ProductModel addProduct(@RequestBody ProductModel prod) {
		return prodSer.addProduct(prod);
	}
}
