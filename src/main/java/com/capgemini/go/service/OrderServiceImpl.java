package com.capgemini.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.model.OrderModel;
import com.capgemini.go.model.ProductModel;
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
	public String cancelOrder(OrderModel order) {
		orderDao.delete(order);
		return "Order deleted";
	}

	@Override
	public String cancelAProduct(Integer orderId, ProductModel product) {
		
		OrderModel ord = orderDao.findById(orderId).get();
		List<ProductModel> prods = ord.getProducts();
		prods.remove(product);
		ord.setProducts(prods);
		orderDao.save(ord);
		return "Product deleted";
	}

	@Override
	public OrderModel updateOrder(OrderModel order) {
		if(orderDao.existsById(order.getOrderId())) {
			orderDao.save(order);
			return order;
		}
		return null;
	}

	@Override
	public OrderModel getOrderById(Integer orderId) {
		return orderDao.findById(orderId).get();
	}

	@Override
	public List<OrderModel> getAllOrders() {
		return (List<OrderModel>) orderDao.findAll();
	}

	@Override
	public String cancelOrderById(Integer id) {
		orderDao.deleteById(id);
		return "Order deleted by ID";
	}

}
