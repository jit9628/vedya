package com.ecommarce.api.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ecommarce.api.entity.AddToCart;
import com.ecommarce.api.repo.AddToCartRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class AddToCartDao {
	private AddToCartRepository addToCartRepository;
	
	
	public List<AddToCart>  findByUsers(long id){
		try {
			List<AddToCart> findByUsers = this.addToCartRepository.findByUsers(id);
			
			if(!findByUsers.isEmpty()) {
				log.info("All Categoris is ::"+findByUsers);
				return findByUsers;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*================ remove specific product from cart=======================*/
	 @Transactional
	public void removeByProductId(int id,long userid){
		 

		 this.addToCartRepository.deleteByProductsAndUsers(id, userid);
	//	this.addToCartRepository.deleteByProductsAndUsers(id, userid);
		
	}
	 
	 /*============ remove add to cart from product id ===================*/
	 @Transactional
	public void removeAddToCartFromProductId(int id) {
		this.addToCartRepository.deleteByProducts(id);
	}
	

}
