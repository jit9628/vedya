package com.ecommarce.api.dao;

import java.util.List;

import com.ecommarce.api.dto.ProductDto;
import com.ecommarce.api.entity.Product;

public interface ProductDetailsDao {

	public  List<Product> getProducts();
	public List<ProductDto> getProductIsOpen(boolean value);
public int updateIsOpen(int id);
	


}
