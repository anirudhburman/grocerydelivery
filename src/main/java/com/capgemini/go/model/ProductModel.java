package com.capgemini.go.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product_go_details")
public class ProductModel {
	
	@Id
	private Integer productId;
	private Double price;
	private String colour;
	private String dimension;
	private String specification;
	private String manufacturer;
	private Integer quantity;
	private Integer productCategory;
	private String productName;

}
