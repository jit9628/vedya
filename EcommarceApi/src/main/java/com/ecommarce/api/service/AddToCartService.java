package com.ecommarce.api.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ecommarce.api.dto.AddToCartDto;
import com.ecommarce.api.entity.AddToCart;

public interface AddToCartService {
	public int addProductToCart(AddToCartDto addToCartDto);
	public List<AddToCart> getpProductFromCart();
	public List<AddToCart> findCartDetailBasedOnUserId(long id);
	public boolean removecartproduct(int id,long userid);
	public boolean removeProductFromCart(int id);
	public int countAddToCartProductBasedOnUser(long id); 
	
	public List<AddToCart> getCategoryDetildFromUser(long id);
	

}
