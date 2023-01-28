package com.capgemini.go.dao;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.OrderModel;

public interface OrderDao extends CrudRepository<OrderModel, Integer>{

}
