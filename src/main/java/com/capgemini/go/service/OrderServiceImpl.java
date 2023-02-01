package com.capgemini.go.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.exception.OrderNotFoundException;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.model.OrderModel;
import com.capgemini.go.model.ProductModel;
import com.capgemini.go.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderDao;
	
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
	public String cancelAProduct(Integer orderId, Integer productId) throws OrderNotFoundException, ProductNotFoundException {
		if(orderDao.existsById(orderId)) {
			OrderModel ord = orderDao.findById(orderId).get();
			List<ProductModel> prods = ord.getProducts();
			int size = prods.size();
			for (Iterator<ProductModel> iterator = prods.iterator(); iterator.hasNext();) {
				ProductModel productModel = iterator.next();
				if(productModel.getProductId() == productId) {
					iterator.remove();
				}
			}
			if(prods.size() != size - 1) {
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
