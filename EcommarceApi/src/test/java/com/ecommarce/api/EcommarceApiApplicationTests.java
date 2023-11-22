package com.ecommarce.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommarce.api.dao.BookingProductDao;
import com.ecommarce.api.dao.ProductDetailsDaoImpl;
import com.ecommarce.api.utility.GenericHandleData;
import com.ecommarce.api.utility.RandomStringValue;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class EcommarceApiApplicationTests {
	

	@Test
	void testDataSource() {
		log.warn("jitendra shukla mirzapur ::)");
		ProductDetailsDaoImpl imp = new ProductDetailsDaoImpl();
		imp.getProducts();
	}
	
	@Test
	void testRandomString() {
	
		System.out.println("Random String Value Is ::"+RandomStringValue
				.getAlphaNumericString());
	}
	@Test
	void testTotalCusomers() {
		Integer countDataValue = new GenericHandleData().countDataValue("users");
		System.out.println("Total Customers are :: "+countDataValue);
	}

}
