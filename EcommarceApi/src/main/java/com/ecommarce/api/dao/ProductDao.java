package com.ecommarce.api.dao;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ecommarce.api.dto.ProductDto;
import com.ecommarce.api.entity.Product;
import com.ecommarce.api.repo.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductDao {

	/* ===== inside dao write custom jpa hibernate queres */

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager entityManager;

	@Autowired
	public ProductDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	ProductRepository productRepository;

	public Product findByProductName(String productname) {
		log.debug(productname);
		try {
			return this.productRepository.ExistsByName(productname);
		} catch (Exception e) {
			new Throwable(e);
		}
		return null;

	}

	/* ================ get product by category ======== */
	public List<Product> findByCategory(long catid) {
		try {
			List<Product> findByCategory = this.productRepository.findByCategory(catid);
			return findByCategory;
		} catch (Exception e) {
			return null;
		}

	}

	/* ============== filter the product by price =============== */

	public List<Product> filterdProduct(long priceone,long pricetwo) {
		try {

			List<Product> findByPrice = this.productRepository.findByPrice(priceone,pricetwo);

			return findByPrice;
		} catch (Exception ex) {
			return null;
		}

	}

	public ArrayList<String> getProductImage(int pid) {
		try {
		ArrayList<String> imageList=new ArrayList<>();
		String sql="select files from product where pid='"+pid+"'";
		 Query createNativeQuery = entityManager.createNativeQuery(sql);
		
		 List resultList = createNativeQuery.getResultList();
		 
	
		 log.info("resultList Of Image Files"+resultList);
		 
		 String string = resultList.toString();
		 String substring = string.substring(2, string.length() -2);
		 String[] split = substring.split(",");
		for( String d:split) {
		log.info("Spli String  Image Files is :-"+d);
		imageList.add(d);
	
	
		}
		
		log.info("Array Image   Files is :-"+imageList);
		
		//List<String[]> result = jdbcTemplate.queryForList(sql).stream().map(row -> row.values().toArray(new String[row.size()])).collect(Collectors.toList());

		//List<Object[]> result1 = jdbcTemplate.queryForList(sql).stream().map(row -> row.values().toArray()).collect(Collectors.toList());

		
		//log.info("List Of Image Files"+result);
		//log.info("List Of Image Files"+result1);
//String string = result.toString();
//String substring = string.substring(1, string.length() - 1);

//log.info("SubString Image Files"+substring);
//String[] split = substring.split(",");



//String k="";

//for( String d:split) {
//	log.info("Spli String  Image Files is :-"+d.toString());
//	log.info("Spli String Value Of Method Image Files is :-"+k.valueOf(d));
//	
//}

//		
//		this.jdbcTemplate.query(, new   RowMapper<String>() {
//
//			@Override
//			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//				
//					return "";
//			}
//			
//		});
		return imageList;
	}catch (Exception e) {
		log.info("Exception Generated Here :: "+e);
		return null;
	}
	
	}
	
	
	
	
	
	
	
	
	
	//============= SEARCH PRODUCT==============
	@Transactional
	public List<ProductDto> searchProductData(String keyword){
		String sql="select * from product where productname LIKE '"+keyword+"%'";
		 Query createNativeQuery = entityManager.createNativeQuery(sql);
		
	List resultList = createNativeQuery.getResultList();
	

 List<ProductDto> query = this.jdbcTemplate.query(sql, new RowMapper<ProductDto>() {

	@Override
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto productDto = new ProductDto();
		ArrayList imageList=new ArrayList();
		productDto.setPid(rs.getInt("pid"));
		productDto.setProductname(rs.getString("productName"));
		productDto.setPrice(rs.getLong("price"));
		String string = rs.getString("files");
		System.out.println("Array Data :: "+string);
		 String substring = string.substring(1, string.length() -1);
		 System.out.println("SubString Value"+substring);
		String[] split = substring.split(",");
		
		 System.out.println("split Value"+split);
		 for( String d:split) {
				log.info("Spli String  Image Files is :-"+d);
				imageList.add(d);
			
			
				}
		
		 productDto.setFiles(imageList);
	
		// TODO Auto-generated method stub
		return productDto;
	}
	
});
return query;
	
		 
	}
	
	
	
	
	
	
	
	
	

}