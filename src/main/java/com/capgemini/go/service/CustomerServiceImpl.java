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
		return custDao.findById(custId).get();
	}

	@Override
	public List<CustomerModel> getAllCustomers() {
		return (List<CustomerModel>) custDao.findAll();
	}

	@Override
	public CustomerModel updateCustomer(CustomerModel cust) {
		if(custDao.existsById(cust.getCustomerId())) {
			custDao.save(cust);
			return cust;
		}
		return null;
	}

	@Override
	public String deleteCustomer(CustomerModel cust) {
		custDao.delete(cust);
		return "Customer Deleted";
	}

	@Override
	public String deleteCustomerById(Integer custId) {
		custDao.deleteById(custId);
		return "Deleted Customer by ID";
	}

}
