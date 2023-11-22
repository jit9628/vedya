package com.ecommarce.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/booking/")
@CrossOrigin("*")
public class BookingController {
	@GetMapping("/getAddressForOrder")
	public ResponseEntity<?> getAddressForOrder(@RequestParam("addressid") int addressid){
		Map<String, Object> body=new HashMap<>();
		body.put("status", "false");
		return new ResponseEntity<>(body,HttpStatus.OK);
	//	return new ResponseEntity<>(Map.of("data",addressid), HttpStatus.OK);
		
	}
	
	
//	@GetMapping("/text")
//	public ResponseEntity<?> text(){
//		Map<String, Object> body=new HashMap<>();
//		body.put("status", "false");
//		return new ResponseEntity<>("",HttpStatus.OK);
//		//return new ResponseEntity<>(Map.of("data","test Success"), HttpStatus.OK);
//		
//	}
	
/*===================== category controller ==================*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
