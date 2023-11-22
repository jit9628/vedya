package com.ecommarce.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AdderessDto {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String localadderess;
	private String country;
	private String city;
	private long postalcode;
	private String mobilenumber;
	private String additionalinfo;
	private String accounttype;
	private long useradr;

}
