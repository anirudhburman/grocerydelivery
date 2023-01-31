package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.model.OrderModel;
import com.capgemini.go.model.ProductModel;

public interface OrderService {
	
	public OrderModel addOrder(OrderModel order);
	
	public String cancelOrder(OrderModel order);
	
	public String cancelOrderById(Integer id);
	
	public String cancelAProduct(Integer orderId, ProductModel product);
	
	public OrderModel updateOrder(OrderModel order);
	
	public OrderModel getOrderById(Integer orderId);
	
	public List<OrderModel> getAllOrders();
}
