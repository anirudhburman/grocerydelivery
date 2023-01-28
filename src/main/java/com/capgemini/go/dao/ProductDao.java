package com.capgemini.go.dao;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.ProductModel;

public interface ProductDao extends CrudRepository<ProductModel, Integer>{

}
