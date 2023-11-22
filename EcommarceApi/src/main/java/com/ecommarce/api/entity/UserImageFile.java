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

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserImageFile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int imageid;
	private String imagepicture;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true,optional = true)
	@JoinColumn(name = "uid",insertable = true,updatable = true,referencedColumnName = "id")
	@JsonBackReference
	private User uid;
}
