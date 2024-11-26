package com.ecommarce.api.helper;

import java.util.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
@NoArgsConstructor
public class Helper {
	@Autowired
	public Helper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private JdbcTemplate jdbcTemplate;
	
	int quantityvalue=50;
	// 50 number generate 
	
	public ArrayList<Integer> getQuantityValue(){
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int k=1 ; k<=50;k++) {
			arrayList.add(k);
		}
		return arrayList;
	}
	
	public Date expectedDate() {
		// String sql ="SELECT DATE_ADD(CURDATE() , INTERVAL 5 DAY);";
		 String sql ="SELECT CURRENT_DATE + INTERVAL '5 day'";

		    @SuppressWarnings("deprecation")
			Date expecteddeliverydate = (Date) jdbcTemplate.queryForObject(
		            sql,  Date.class);

		    System.out.println(" EXPECTED DATE:"+expecteddeliverydate);
		    //return isBookingRemark;
			return expecteddeliverydate;
		
	}
	
}
