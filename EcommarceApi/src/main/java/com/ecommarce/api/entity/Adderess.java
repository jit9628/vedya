package com.ecommarce.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Adderess {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String localadderess;
	private String country;
	private String city;
	private long postalcode;
	private String mobilenumber;
	private String accounttype;
	private String additionalinfo;
	// private boolean accountstatus;
	// relationship user and adderess one to one relationship

	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, orphanRemoval = true, optional = true)
	@JoinColumn(name = "userid", insertable = true, referencedColumnName = "id", updatable = true)
	@JsonBackReference
	@JsonIgnore
	private User useradr;

}
