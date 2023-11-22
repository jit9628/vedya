package com.ecommarce.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_contact_us")
@Getter
@Setter
public class ContactUs {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "fullName")
	private String fullName;
	@Column(name = "contactNumber")
	private String contactNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "queries")
	private String queries;

}
