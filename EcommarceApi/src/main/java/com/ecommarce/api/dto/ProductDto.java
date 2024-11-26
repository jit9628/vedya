package com.ecommarce.api.dto;

import java.util.ArrayList;
import java.util.TreeSet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class ProductDto {
	private int pid;
	@NotBlank(message = "product name can not be blank")
	private String productname;

	private long price;
	@NotBlank(message = "SKU can not be blank")
	private String sku;
	@NotBlank(message = "discription can not be blank")
	private String discription;
	private ArrayList<String> files;
	public String[] filesretrieve;
	private long catname;
	private long orderss;
	private boolean isActive;
	private int createdby;
	private int updatedby;
	private int stocks;
	private TreeSet<String> productsize = new TreeSet<>();
	/*
	 * private List<String> sized = new ArrayList<>(); private String[] sizes;
	 */
	
	private boolean isOpen;
	private String sizes;

}
