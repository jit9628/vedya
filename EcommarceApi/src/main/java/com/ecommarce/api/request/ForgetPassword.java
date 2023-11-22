package com.ecommarce.api.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class ForgetPassword {
	@NotBlank
	  private String emails;
		@NotBlank
		private String passwords;
		@NotBlank
		private String otpverifier;
		
}
