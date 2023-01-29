package com.capgemini.go.service;

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

}
