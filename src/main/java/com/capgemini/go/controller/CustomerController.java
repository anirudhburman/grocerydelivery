package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.model.CustomerModel;
import com.capgemini.go.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService custSer;
	
	//http://localhost:8080/addcust
	@PostMapping("/addcust")
	public CustomerModel addCust(@RequestBody CustomerModel cust) {
		CustomerModel custer = custSer.addCustomer(cust);
		return custer;
	}
}
