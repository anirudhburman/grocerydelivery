package com.capgemini.go.repositories;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.WishlistModel;

public interface WishlistDao extends CrudRepository<WishlistModel, Integer>{

}