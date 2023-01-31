package com.capgemini.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.model.OrderModel;
import com.capgemini.go.model.ProductModel;
import com.capgemini.go.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderSer;

	// http://localhost:8080/addorder
	@PostMapping("/addorder")
	public OrderModel addOrder(@RequestBody OrderModel order) {
		return orderSer.addOrder(order);
	}
	
	// http://localhost:8080/cancelorder
	@PostMapping("/cancelorder")
	public String cancelOrder(@RequestBody OrderModel order) {
		return orderSer.cancelOrder(order);
	}
	
	// http://localhost:8080/cancelorderbyid/{id}
	@GetMapping("/cancelorderbyid/{id}")
	public String cancelOrderById(@PathVariable("id") Integer id) {
		return orderSer.cancelOrderById(id);
	}
	
	// http://localhost:8080/cancelproduct/{id}
	@PostMapping("/cancelproduct/{id}")
	public String cancelAProduct(@PathVariable("id") Integer orderId, @RequestBody ProductModel product) {
		return orderSer.cancelAProduct(orderId, product);
	}
	
	// http://localhost:8080/updateorder
	@PostMapping("/updateorder")
	public OrderModel updateOrder(@RequestBody OrderModel order) {
		return orderSer.updateOrder(order);
	}
	
	// http://localhost:8080/getorderbyid/{id}
	@GetMapping("/getorderbyid/{id}")
	public OrderModel getOrderById(@PathVariable("id") Integer orderId) {
		return orderSer.getOrderById(orderId);
	}
	
	// http://localhost:8080/allorders
	@GetMapping("/allorders")
	public List<OrderModel> getAllOrders() {
		return orderSer.getAllOrders();
	}
}
