package com.capgemini.go.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.model.OrderModel;
import com.capgemini.go.repositories.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Override
	public OrderModel addOrder(OrderModel order) {
		return orderDao.save(order);
	}

}
