package com.ecommarce.api.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ecommarce.api.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Service  @Slf4j
public class ProductDetailsDaoImpl implements ProductDetailsDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;





	@Override
	public List<Product> getProducts() {

		DataSource dataSource = jdbcTemplate.getDataSource();
		log.info("DataSource is ::"+dataSource);
		return null;
	}

}
