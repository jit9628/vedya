package com.ecommarce.api.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	private long catid;
	private String categoryname;
	private String filecategory;
}
