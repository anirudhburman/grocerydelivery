package com.capgemini.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.model.CustomerModel;
import com.capgemini.go.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService custSer;

	// http://localhost:8080/addcust
	@PostMapping("/addcust")
	public CustomerModel addCust(@RequestBody CustomerModel cust) {
		return custSer.addCustomer(cust);
	}
	
	// http://localhost:8080/getcustomerbyid/{id}
	@GetMapping("/getcustomerbyid/{id}")
	public CustomerModel getCustomerById(@PathVariable("id") Integer custId) {
		return custSer.getCustomerById(custId);
	}
	
	// http://localhost:8080/getallcustomers
	@GetMapping("/getallcustomers")
	public List<CustomerModel> getAllCustomers() {
		return custSer.getAllCustomers();
	}
	
	// http://localhost:8080/updatecustomer
	@PostMapping("/updatecustomer")
	public CustomerModel updateCustomer(@RequestBody CustomerModel cust) {
		return custSer.updateCustomer(cust);
	}
	
	// http://localhost:8080/deletecustomer
	@PostMapping("/deletecustomer")
	public String deleteCustomer(@RequestBody CustomerModel cust) {
		return custSer.deleteCustomer(cust);
	}
	
	// http://localhost:8080/deletecust/{id}
	@GetMapping("/deletecust/{id}")
	public String deleteCustomerById(@PathVariable("id") Integer custId) {
		return custSer.deleteCustomerById(custId);
	}
}
