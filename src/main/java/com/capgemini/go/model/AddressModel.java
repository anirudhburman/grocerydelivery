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
@Table(name = "address_go_details")
public class AddressModel {
	
	@Id
	private Integer addressId;
	private Integer retailerId;
	private String buildingNo;
	private String city;
	private String state;
	private String field;
	private Integer Zip;

}
