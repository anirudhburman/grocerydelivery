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
import lombok.ToString.Exclude;

@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user_go_details")
public class UserModel {
    
	private String userName;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq",sequenceName="user_seq", allocationSize=1)
	private Integer userId;
	private String userType;
	private String userPassword;
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	@Exclude
	private CustomerModel customer;
	
	public UserModel(String userName, Integer userId, String userType, String userPassword) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userType = userType;
		this.userPassword = userPassword;
	}

	public UserModel() {
		super();
	}
	
}