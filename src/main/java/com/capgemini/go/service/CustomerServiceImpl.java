package com.capgemini.go.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.exception.CustomerAlreadyExistsException;
import com.capgemini.go.exception.CustomerNotFoundException;
import com.capgemini.go.exception.EmptyCartException;
import com.capgemini.go.exception.EmptyWishListException;
import com.capgemini.go.model.CartModel;
import com.capgemini.go.model.CustomerModel;
import com.capgemini.go.model.OrderModel;
import com.capgemini.go.model.WishlistModel;
import com.capgemini.go.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	
	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);
	
	@Override
	public CustomerModel addCustomer(CustomerModel customer) throws CustomerAlreadyExistsException {
		if(custRepo.findByMobileNo(customer.getMobileNo()) != null) {
			throw new CustomerAlreadyExistsException();
		}
		return custRepo.save(customer);
	}

	@Override
	public CustomerModel getCustomerById(Integer custId) throws CustomerNotFoundException {
		if(custRepo.existsById(custId)) {
			logger.info("Customer added to DB");
			return custRepo.findById(custId).get();
		}
		throw new CustomerNotFoundException();
	}

	@Override
	public List<CustomerModel> getAllCustomers() {
		return (List<CustomerModel>) custRepo.findAll();
	}

	@Override
	public CustomerModel updateCustomer(CustomerModel cust) throws CustomerNotFoundException {
		if(custRepo.existsById(cust.getCustomerId())) {
			custRepo.save(cust);
			return cust;
		}
		throw new CustomerNotFoundException();
	}

	@Override
	public String deleteCustomer(CustomerModel cust) throws CustomerNotFoundException {
		if(custRepo.existsById(cust.getCustomerId())) {
			custRepo.delete(cust);
			return "Customer Deleted";
		}
		throw new CustomerNotFoundException();
	}

	@Override
	public String deleteCustomerById(Integer custId) throws CustomerNotFoundException {
		if(custRepo.existsById(custId)) {
			custRepo.deleteById(custId);
			return "Deleted Customer by ID";
		}
		throw new CustomerNotFoundException();
	}

	@Override
	public List<OrderModel> getOrdersByCustomerId(Integer custId) throws CustomerNotFoundException {
		if(!custRepo.existsById(custId)) {
			throw new CustomerNotFoundException();
		}
		if(custRepo.findById(custId).isPresent()) {
			return custRepo.findById(custId).get().getOrders();
		}
		throw new CustomerNotFoundException();
	}

	@Override
	public CartModel getCartByCustId(Integer custId) throws EmptyCartException, CustomerNotFoundException {
		if(!custRepo.existsById(custId)) {
			throw new CustomerNotFoundException();
		}
		CartModel cart = custRepo.findById(custId).get().getCart();
		if(cart.getProducts().isEmpty()) {
			throw new EmptyCartException();
		}
		return cart;
	}

	@Override
	public WishlistModel getWishListByCustId(Integer id) throws EmptyWishListException, CustomerNotFoundException {
		if(!custRepo.existsById(id)) {
			throw new CustomerNotFoundException();
		}
		WishlistModel wishlist = custRepo.findById(id).get().getWishlist();
		if(wishlist.getProducts().isEmpty()) {
			throw new EmptyWishListException();
		}
		return wishlist;
	}

}
