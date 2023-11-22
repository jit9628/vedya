package com.ecommarce.api.response;



import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse
{
   private String message;
   public ApiResponse(String message, String status, boolean success, int statuscode) {
	super();
	this.message = message;
	this.status = status;
	this.success = success;
	this.statuscode = statuscode;
}
public ApiResponse(String message, String status, boolean success, int statuscode, List<?> body) {
	super();
	this.message = message;
	this.status = status;
	this.success = success;
	this.statuscode = statuscode;
	this.body = body;
}
private String status;
   private boolean success;
   private int statuscode;
   List<?> body;
}
