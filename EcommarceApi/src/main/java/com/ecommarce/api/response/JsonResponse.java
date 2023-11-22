package com.ecommarce.api.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class JsonResponse {
	public ResponseEntity<?> getResponse(String status,String message,Object data){	
		final Map<String, Object> body = new HashMap<>();
		body.put("message", message);
		body.put("data", data);
		body.put("status", status);
		return new ResponseEntity<>(body, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	

}
