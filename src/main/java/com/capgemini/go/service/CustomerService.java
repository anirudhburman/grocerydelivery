package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.model.CustomerModel;

public interface CustomerService {
	
	public CustomerModel addCustomer(CustomerModel customer);
	
	public CustomerModel getCustomerById(Integer custId);
	
	public List<CustomerModel> getAllCustomers();
	
	public CustomerModel updateCustomer(CustomerModel cust);
	
	public String deleteCustomer(CustomerModel cust);
	
	public String deleteCustomerById(Integer custId);
	
}
