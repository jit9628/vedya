package com.ecommarce.api.dao;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.ecommarce.api.dto.BookingProductDto;
import com.ecommarce.api.dto.ProductDto;
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




	
@Transactional
	@Override
	public List<ProductDto> getProductIsOpen(boolean value) {
		
		return this.jdbcTemplate.query(
				"select p.productname,p.files, p.price, p.pid, from product as p "
				, new RowMapper<ProductDto>() {

			@Override
			public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductDto dto=new ProductDto();
				dto.setPid(rs.getInt("pid"));
				dto.setProductname(rs.getString("productname"));
				dto.setPrice(rs.getLong("price"));
				String string = rs.getString("files");

				System.out.println("String File Is :" + string);
				String substring = string.substring(1, string.length() - 1);
				dto.setFilesretrieve(string.substring(1, string.length() - 1).split(","));

				
				return dto;
			}
			
			
			
			
		});
	
		
		
//		return this.jdbcTemplate.query(
//				"select p.productname,p.files, p.price, p.pid, p.productsize ,b.bid ,b.addressid,b.currentdate,b.productsid ,b.remark ,b.orderimages,b.order_booking_id from product as p inner join booking_product  as b on b.productsid= p.pid where b.usersid='"
//						+ value + "'",
//				new RowMapper<ProductDao>() {
//
//					@Override
//					public ProductDao mapRow(ResultSet rs, int rowNum) throws SQLException {
//						ProductDao bookingProductDto = new ProductDao();
//						bookingProductDto.setProductname(rs.getString("productname"));
////						bookingProductDto.setBid(rs.getLong("bid"));
////						String string = rs.getString("files");
////
////						System.out.println("String File Is :" + string);
////						String substring = string.substring(1, string.length() - 1);
////						bookingProductDto.setProductimage(string.substring(1, string.length() - 1).split(",")[0]);
////						bookingProductDto.setRemark(rs.getString("remark"));
////						bookingProductDto.setPrice(rs.getLong("price"));
////						bookingProductDto.setOrderimages(rs.getString("orderimages"));
////						bookingProductDto.setOrder_booking_id(rs.getString("order_booking_id"));
////						System.out.println(rs.getString("productname") + "booking id is ::" + rs.getLong("bid"));
//						return bookingProductDto;
//					}
//				});
	}





	@Override
	public int updateIsOpen(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
