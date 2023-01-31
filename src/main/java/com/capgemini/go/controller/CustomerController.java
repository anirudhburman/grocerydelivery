package com.capgemini.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.exception.customer.CustomerAlreadyExistsException;
import com.capgemini.go.exception.customer.CustomerNotFoundException;
import com.capgemini.go.exception.customer.EmptyCartException;
import com.capgemini.go.exception.customer.EmptyWishListException;
import com.capgemini.go.model.CartModel;
import com.capgemini.go.model.CustomerModel;
import com.capgemini.go.model.OrderModel;
import com.capgemini.go.model.WishlistModel;
import com.capgemini.go.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService custSer;

	// http://localhost:8080/addcust
	@PostMapping("/addcust")
	public CustomerModel addCust(@RequestBody CustomerModel cust) throws CustomerAlreadyExistsException {
		return custSer.addCustomer(cust);
	}

	// http://localhost:8080/getcustomerbyid/{id}
	@GetMapping("/getcustomerbyid/{id}")
	public CustomerModel getCustomerById(@PathVariable("id") Integer custId) throws CustomerNotFoundException {
		return custSer.getCustomerById(custId);
	}

	// http://localhost:8080/getallcustomers
	@GetMapping("/getallcustomers")
	public List<CustomerModel> getAllCustomers() {
		return custSer.getAllCustomers();
	}

	// http://localhost:8080/updatecustomer
	@PostMapping("/updatecustomer")
	public CustomerModel updateCustomer(@RequestBody CustomerModel cust) throws CustomerNotFoundException {
		return custSer.updateCustomer(cust);
	}

	// http://localhost:8080/deletecustomer
	@PostMapping("/deletecustomer")
	public String deleteCustomer(@RequestBody CustomerModel cust) throws CustomerNotFoundException {
		return custSer.deleteCustomer(cust);
	}

	// http://localhost:8080/deletecust/{id}
	@GetMapping("/deletecust/{id}")
	public String deleteCustomerById(@PathVariable("id") Integer custId) throws CustomerNotFoundException {
		return custSer.deleteCustomerById(custId);
	}
	
	@GetMapping("/getordersbycustid/{id}")
	public List<OrderModel> getOrdersByCustomerId(@PathVariable("id") Integer custId) throws CustomerNotFoundException {
		return custSer.getOrdersByCustomerId(custId);
	}

	@GetMapping("/getcartbycustid/{id}")
	public CartModel getCartByCustId(@PathVariable("id") Integer custId) throws EmptyCartException, CustomerNotFoundException {
		return custSer.getCartByCustId(custId);
	}

	@GetMapping("/getwishlistbycustid/{id}")
	public WishlistModel getWishListByCustId(@PathVariable("id") Integer id) throws EmptyWishListException, CustomerNotFoundException {
		return custSer.getWishListByCustId(id);
	}
}
