package com.ecommarce.api.dto;

import java.util.Date;

import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class BookingProductDto {
	
	private long bid;
	private int productid;
	@Transient
	private String productname;
	@Transient
	private String productimage;
	@Transient
	private long price;
	private long userid;
	private String remark;
	private int addressid;
	private Date currentdate;
	private Date expecteddate;
	private String orderimages;
	public String order_booking_id;
	private int totalqty;

	/*
	 * private long actualprice; private long discountprice; private long
	 * payableprice;
	 */
	
	
	
	
}

