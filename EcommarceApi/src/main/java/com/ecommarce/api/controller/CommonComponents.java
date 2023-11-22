package com.ecommarce.api.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommarce.api.dto.CategoryDto;
import com.ecommarce.api.entity.Category;
import com.ecommarce.api.service.CategoryService;

@Component
public class CommonComponents {

	@Autowired
	private CategoryService categoryService;
	public List<CategoryDto> getAllCategories() {
		try {
			//================ LOAD CATEGORY===================
			List<Category> allcategories = null;
			
			allcategories = categoryService.getAllCategory();
			List<CategoryDto> CategoryDatalist = new ArrayList<>();
			if (!allcategories.isEmpty() && allcategories != null) {
				for (int i = 0; i < allcategories.size(); i++) {
					CategoryDto dto = new CategoryDto();
					dto.setCatid(allcategories.get(i).getCatid());
					dto.setCategoryname(allcategories.get(i).getCategoryname());
					dto.setFilecategory(allcategories.get(i).getFilecategory());
					CategoryDatalist.add(dto);
				}
			}
			return CategoryDatalist;

		} catch (Exception e) {
			return null;
		}
	}

}
