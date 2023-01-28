package com.capgemini.go.dao;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.WishlistModel;

public interface WishlistDao extends CrudRepository<WishlistModel, Integer>{

}
