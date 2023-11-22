package com.ecommarce.api.dao;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ecommarce.api.repo.AdderessRepository;
import com.ecommarce.api.repo.BookingProductRepository;

@Component
public class AdderessDao {
	@Autowired
	AdderessRepository repos;
	
	@Autowired
	private BookingProductRepository bookingProductRepository;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AdderessDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	public void deleteAdderess(int id) {
		
		this.repos.deleteById(id);
	}
	
	
	public int deleteAdderess(long id) throws SQLException {

		try {
			String queries = "delete from adderess where id='" + id + "'";
			int update = this.jdbcTemplate.update(queries);
			return update;
		} catch (Exception e) {
			return 0;
		}

	}
	
	
	
	
	

}
