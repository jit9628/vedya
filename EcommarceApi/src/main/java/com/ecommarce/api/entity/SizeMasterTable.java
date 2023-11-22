package com.ecommarce.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SizeMasterTable {
@Id
@GeneratedValue
	private int id;
	private String size;
}
