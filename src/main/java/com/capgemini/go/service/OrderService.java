package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.model.OrderModel;

public interface OrderService {
	
	public OrderModel addOrder(OrderModel order);
	
	public void cancelOrder();
	
	public void cancelAProduct();
	
	public OrderModel updateOrder(OrderModel order);
	
	public OrderModel getOrderById();
	
	public List<OrderModel> getAllOrders();
}
