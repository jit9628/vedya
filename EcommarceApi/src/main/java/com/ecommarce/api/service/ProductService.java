package com.ecommarce.api.service;

import java.util.List;
import java.util.Optional;

import com.ecommarce.api.dto.ProductDto;
import com.ecommarce.api.entity.Product;

public interface ProductService {

	// add
	public boolean addProduct(ProductDto productDto);

	//retrieve
	public List<Product> getAllProduct();
//delete
	public boolean deleteProduct(int id);
//find product by name
	public Product findProductByName(String name);

	// find product bty category
	public List<Product> getProductByCategory();

	// find product by id
	public  Optional<Product> findProductById(int id);

	//count number of products

	public long totalProducts();

	//==============UPDATE PRODUCT ==========

	public boolean updateProduct(ProductDto dto, int pid);

	/*============Matching Product or categorywise=================*/

	public List<Product> findProductByCategorId(long catid);
	
	public List<Product> filterProductByPrice(long priceone,long pricetwo);
	
}
