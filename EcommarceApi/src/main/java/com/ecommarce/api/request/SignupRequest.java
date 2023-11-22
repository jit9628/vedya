package com.ecommarce.api.request;

import java.util.Set;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class SignupRequest {
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private Set<String> role;
	private String password;
	private String mobile;
	private int adderess;
}
