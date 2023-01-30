package com.capgemini.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.model.ProductModel;
import com.capgemini.go.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService prodSer;

	// http://localhost:8080/addproduct
	@PostMapping("/addproduct")
	public ProductModel addProduct(@RequestBody ProductModel prod) {
		return prodSer.addProduct(prod);
	}

	// http://localhost:8080/updateproduct
	@PostMapping("/updateproduct")
	public ProductModel updateproduct(@RequestBody ProductModel prod) {
		return prodSer.updateProduct(prod);
	}

	// http://localhost:8080/deleteproductbyid
	@GetMapping("/deleteproductbyid/{id}")
	public String deleteProductById(@PathVariable("id") Integer productId) {
		return prodSer.deleteProductById(productId);
	}

	// http://localhost:8080/searchproductbybrand
	@GetMapping("/searchproductbybrand")
	public ProductModel searchProductByBrand(@RequestParam("brand") String brand) {
		return prodSer.searchByBrand(brand);
	}

	// http://localhost:8080/searchbyproductname
	@GetMapping("/searchbyproductname")
	public ProductModel searchByProductName(@RequestParam("productname") String productName) {
		return prodSer.searchByProductName(productName);
	}

	// http://localhost:8080/searchbycolour
	@GetMapping("/searchbycolour")
	public ProductModel searchByColour(@RequestParam("colour") String colour) {
		return prodSer.searchByColour(colour);
	}

	// http://localhost:8080/searchbydimension
	@GetMapping("/searchbydimension")
	public ProductModel searchByDimension(@RequestParam("dimension") String dimension) {
		return prodSer.searchByDimension(dimension);
	}

	// http://localhost:8080/filterbybrand
	@GetMapping("/filterbybrand")
	public List<ProductModel> filterByBrand(@RequestParam("dimension") String brand) {
		return prodSer.filterByBrand(brand);
	}

	// http://localhost:8080/sortbyprice
	@GetMapping("/sortbyprice")
	public List<ProductModel> sortByPrice() {
		return prodSer.sortByPrice();
	}

}
