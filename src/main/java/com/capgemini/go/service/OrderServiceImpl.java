package com.capgemini.go.service;

import java.util.List;

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

	@Override
	public void cancelOrder() {
		
	}

	@Override
	public void cancelAProduct() {
		
	}

	@Override
	public OrderModel updateOrder(OrderModel order) {
		return null;
	}

	@Override
	public OrderModel getOrderById() {
		return null;
	}

	@Override
	public List<OrderModel> getAllOrders() {
		return null;
	}

}
