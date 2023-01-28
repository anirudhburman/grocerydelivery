package com.capgemini.go.dao;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.CartModel;

public interface CartDao extends CrudRepository<CartModel, Integer>{

}
