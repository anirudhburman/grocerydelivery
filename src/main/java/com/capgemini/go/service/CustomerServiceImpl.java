package com.capgemini.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.model.CustomerModel;
import com.capgemini.go.repositories.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao custDao;
	
	@Override
	public CustomerModel addCustomer(CustomerModel customer) {
		return custDao.save(customer);
	}

	@Override
	public CustomerModel getCustomerById(Integer custId) {
		return null;
	}

	@Override
	public List<CustomerModel> getAllCustomers() {
		return null;
	}

	@Override
	public CustomerModel updateCustomer(CustomerModel cust) {
		return null;
	}

	@Override
	public void deleteCustomer(CustomerModel cust) {
		
	}

	@Override
	public void deleteCustomerById(Integer custId) {
		
	}

}
