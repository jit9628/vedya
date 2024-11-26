package com.ecommarce.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToCartDto {
	private int cartid;
	private int products;
	private long usersid;
	private String size;
	private String color;
	private String orderimage;
	private int qty;
}
