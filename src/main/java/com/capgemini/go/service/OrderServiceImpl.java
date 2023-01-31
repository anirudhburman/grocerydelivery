package com.capgemini.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.exception.order.OrderNotFoundException;
import com.capgemini.go.exception.product.ProductNotFoundException;
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
	public String cancelOrder(OrderModel order) throws OrderNotFoundException {
		if(orderDao.existsById(order.getOrderId())) {
			orderDao.delete(order);
			return "Order deleted";
		}
		throw new OrderNotFoundException();
	}

	@Override
	public String cancelAProduct(Integer orderId, ProductModel product) throws OrderNotFoundException, ProductNotFoundException {
		if(orderDao.existsById(orderId)) {
			OrderModel ord = orderDao.findById(orderId).get();
			List<ProductModel> prods = ord.getProducts();
			if(prods.contains(product)) {
				prods.remove(product);
			} else {
				throw new ProductNotFoundException();
			}
			ord.setProducts(prods);
			orderDao.save(ord);
			return "Product deleted";
		}
		throw new OrderNotFoundException();
	}

	@Override
	public OrderModel updateOrder(OrderModel order) throws OrderNotFoundException {
		if(orderDao.existsById(order.getOrderId())) {
			orderDao.save(order);
			return order;
		}
		throw new OrderNotFoundException();
	}

	@Override
	public OrderModel getOrderById(Integer orderId) throws OrderNotFoundException {
		if(orderDao.existsById(orderId)) {
			return orderDao.findById(orderId).get();
		}
		throw new OrderNotFoundException();
	}

//	@Override
//	public List<OrderModel> getAllOrders() {
//		return (List<OrderModel>) orderDao.findAll();
//	}

	@Override
	public String cancelOrderById(Integer id) throws OrderNotFoundException {
		if(orderDao.existsById(id)) {
			orderDao.deleteById(id);
			return "Order deleted by ID";
		}
		throw new OrderNotFoundException();
	}

}
