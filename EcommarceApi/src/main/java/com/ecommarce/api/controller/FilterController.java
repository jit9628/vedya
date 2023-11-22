//package com.ecommarce.api.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ecommarce.api.dao.ProductDao;
//import com.ecommarce.api.entity.Product;
//import com.ecommarce.api.service.ProductService;
//
//@RestController("/api/filter")
//public class FilterController {
//
//	@Autowired
//	private ProductService productService;
//
//	// filter product by price
//	@GetMapping("filterdprice/{priceone/{pricetwo}")
//	public ResponseEntity<?> filterdPrice(@PathVariable("price") long price){
//		Map<String , Object> body=new HashMap<>();
//		
//		try {
//			List<Product> filterProductByPrice = this.productService.filterProductByPrice(priceone,pricetwo);
//			body.put("message", filterProductByPrice);
//			return new ResponseEntity<>(body,HttpStatus.OK);
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		 return new ResponseEntity<>(body,HttpStatus.OK);
//
//				
//		
//	}
//
//}
