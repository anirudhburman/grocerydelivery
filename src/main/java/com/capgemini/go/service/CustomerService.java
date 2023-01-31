package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.exception.customer.CustomerNotFoundException;
import com.capgemini.go.exception.customer.EmptyCartException;
import com.capgemini.go.exception.customer.EmptyWishListException;
import com.capgemini.go.model.CartModel;
import com.capgemini.go.model.CustomerModel;
import com.capgemini.go.model.OrderModel;
import com.capgemini.go.model.WishlistModel;

public interface CustomerService {
	
	public CustomerModel addCustomer(CustomerModel customer) /* throws CustomerAlreadyExistsException */;
	
	public CustomerModel getCustomerById(Integer custId) throws CustomerNotFoundException;
	
	public List<CustomerModel> getAllCustomers();
	
	public CustomerModel updateCustomer(CustomerModel cust) throws CustomerNotFoundException;
	
	public String deleteCustomer(CustomerModel cust) throws CustomerNotFoundException;
	
	public String deleteCustomerById(Integer custId) throws CustomerNotFoundException;
	
	public List<OrderModel> getOrdersByCustomerId(Integer custId) throws CustomerNotFoundException;
	
	public CartModel getCartByCustId(Integer custId) throws EmptyCartException, CustomerNotFoundException;
	
	public WishlistModel getWishListByCustId(Integer id) throws EmptyWishListException, CustomerNotFoundException;
	
}
