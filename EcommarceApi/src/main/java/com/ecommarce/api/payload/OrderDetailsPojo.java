package com.ecommarce.api.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailsPojo {
	private long orderid;
	private String opname;
	private long price;
	private String orderimage;
	private String customername;
	private String orderaddress;
	private String orderstatus;
	private  long totalprice;
	private double subtotal;
	private int orderquantity;
}
