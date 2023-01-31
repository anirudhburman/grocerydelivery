package com.capgemini.go.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="add_seq")
	@SequenceGenerator(name="add_seq",sequenceName="add_seq", allocationSize=1)
	private Integer addressId;
	private String buildingNo;
	private String areaName;
	private String city;
	private String state;
	private Integer zip;
	@OneToOne(mappedBy = "address")
	@JsonIgnore
	private CustomerModel customer;
	
	public AddressModel(Integer addressId, String buildingNo, String areaName, String city, String state, Integer zip) {
		super();
		this.addressId = addressId;
		this.buildingNo = buildingNo;
		this.areaName = areaName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	
}
