package com.ecommarce.api.utility;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class GenericHandleData {

	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EntityManager entityManager;

	@Autowired
	public GenericHandleData(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Integer countDataValue(String dbName) {
		String queries="select COUNT(*) as  from '"+dbName+"'";
		
		System.out.println("Queres statements is : "+queries);
  Integer singleResult = (Integer)this.entityManager.createQuery("select COUNT(*) from user_roles where role_id=2").getSingleResult();
 
		return singleResult;
	}

}
