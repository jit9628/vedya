package com.ecommarce.api.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ecommarce.api.entity.BookingProduct;

public interface BookingProductService {
	public boolean bookProduct(long id,int adrid);
	public List<BookingProduct> findBookingOrderByDate(Date Date);
	
	public List<BookingProduct> getProductByRemark(String remark);
	
	public List<BookingProduct> getAllBooking();
	
	public List<BookingProduct> findByUserId(long id);
	
	public boolean cancelOrder(long bid);
	
	public Map<String,Object> getFilterDateAndRemarkWiseBookngOrderDetails(String fromdate,String todate,String remark);
	public int totalProducts();
	 
}
