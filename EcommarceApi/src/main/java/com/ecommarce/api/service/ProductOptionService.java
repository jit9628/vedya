package com.ecommarce.api.service;

import java.util.Optional;

import com.ecommarce.api.dto.ProductOptionDto;
import com.ecommarce.api.entity.ProductOption;

public interface ProductOptionService {
	public boolean addMoreProductDetails(ProductOptionDto productOptionDto);

	public Optional<ProductOption> findProductDetailsById(long id);

}
