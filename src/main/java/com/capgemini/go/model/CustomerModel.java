package com.capgemini.go.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name = "customer_go_details")
public class CustomerModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cust_seq")
	@SequenceGenerator(name="cust_seq",sequenceName="cust_seq", allocationSize=1)
	private Integer customerId;
	private String customerName;
	private String mobileNo;
	private String email;
	
	// HAS - A relationship
	// One customer can have only one Address.
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="address_id")
	private AddressModel address;
	
	//IS - A relationship
	// Customer is a sub-class of User.
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_Id")
	private UserModel user;
	
	// HAS - A relationship
	// Customer has one Cart
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private CartModel cart;
	
	// HAS - A relationship
	// Customer has one wishlist
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="wishlist_id")
	private WishlistModel wishlist;
}
