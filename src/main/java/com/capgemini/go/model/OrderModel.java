package com.capgemini.go.model;

import java.time.LocalDate;

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
@Table(name = "order_go_details")
public class OrderModel {
	
	@Id
	private Integer orderId;
	private Integer userId;
	private Integer addressId;
	private Byte orderDispatchStatus;
	private LocalDate orderInitiateTime;
	private LocalDate orderDispatchTime;

}
