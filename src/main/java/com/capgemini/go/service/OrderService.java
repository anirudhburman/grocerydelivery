package com.capgemini.go.service;

import com.capgemini.go.exception.order.OrderNotFoundException;
import com.capgemini.go.exception.product.ProductNotFoundException;
import com.capgemini.go.model.OrderModel;
import com.capgemini.go.model.ProductModel;

public interface OrderService {
	
	public OrderModel addOrder(OrderModel order);
	
	public String cancelOrder(OrderModel order) throws OrderNotFoundException;
	
	public String cancelOrderById(Integer id) throws OrderNotFoundException;
	
	public String cancelAProduct(Integer orderId, ProductModel product) throws OrderNotFoundException, ProductNotFoundException;
	
	public OrderModel updateOrder(OrderModel order) throws OrderNotFoundException;
	
	public OrderModel getOrderById(Integer orderId) throws OrderNotFoundException;
	
//	public List<OrderModel> getAllOrders();
}
