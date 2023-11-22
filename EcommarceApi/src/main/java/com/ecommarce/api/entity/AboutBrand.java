package com.ecommarce.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AboutBrand {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
private long brandid;
	@Column(columnDefinition = "TEXT",length = 2000,name = "discription")
private String discription;
private String filebrand;
}
