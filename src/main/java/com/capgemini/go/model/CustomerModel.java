package com.capgemini.go.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	@JsonIgnore
	private AddressModel address;
	
	//IS - A relationship
	// Customer is a sub-class of User.
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_Id")
	@JsonIgnore
	private UserModel user;
	
	// HAS - A relationship
	// Customer has one Cart
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id")
	@JsonIgnore
	private CartModel cart;
	
	// HAS - A relationship
	// Customer has one wishlist
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="wishlist_id")
	@JsonIgnore
	private WishlistModel wishlist;
	
	@OneToMany(mappedBy = "customer")
	@Exclude
	@JsonIgnore
	private List<OrderModel> orders;

	public CustomerModel(Integer customerId, String customerName, String mobileNo, String email, AddressModel address,
			UserModel user, CartModel cart, WishlistModel wishlist) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.user = user;
		this.cart = cart;
		this.wishlist = wishlist;
	}
	
}
