package com.ecommarce.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity

public class AddToCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartid;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true,optional = true)
	@JoinColumn(name = "productid",insertable = true,updatable = true,referencedColumnName = "pid")
	@JsonBackReference
	private Product products;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true,optional = true)
	@JoinColumn(name = "users",insertable = true,updatable = true,referencedColumnName = "id")
	@JsonBackReference
	private User users;
	private String size;
	private String color;
	private String orderimage;
}
