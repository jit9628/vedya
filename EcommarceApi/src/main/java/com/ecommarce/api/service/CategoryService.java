package com.ecommarce.api.service;

import java.util.List;
import java.util.Optional;

import com.ecommarce.api.dto.CategoryDto;
import com.ecommarce.api.entity.Category;

public interface CategoryService {
	public boolean addCategory(CategoryDto categoryDto);
	public void saveFile(CategoryDto category);
	public List<Category> getAllCategory();
	public Optional<Category> searchCategoryById(Long id);
	public String categoryRemove(long id);
	public boolean updateCategory(CategoryDto categoryDto ,long id);



}
