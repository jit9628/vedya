package com.ecommarce.api.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommarce.api.dto.CategoryDto;
import com.ecommarce.api.entity.Category;
import com.ecommarce.api.repo.CategoryRepository;
import com.ecommarce.api.repo.UploadRepo;
import com.ecommarce.api.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UploadRepo repoupoad;
	@Autowired
	private ModelMapper mapper;

	@Override
	public boolean addCategory(CategoryDto categoryDto) {
		boolean status = false;
		try {
			Category map = this.mapper.map(categoryDto, Category.class);

			Category findBycategoryname = this.categoryRepository.findBycategoryname(categoryDto.getCategoryname());
			log.info("{}", findBycategoryname);

			if (findBycategoryname != null)

				return status;

			Category save = this.categoryRepository.save(map);

			if (save != null) {
				status = true;
				return status;
			} else {
				return false;
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return true;
	}

	@Override
	public List<Category> getAllCategory() {
		return this.categoryRepository.findAll();
	}

	@Override
	public void saveFile(CategoryDto category) {
		Category map = mapper.map(category, Category.class);
		this.categoryRepository.save(map);
	}

	// @SuppressWarnings("static-access")
	@Override
	public Optional<Category> searchCategoryById(Long id) {
		Optional<Category> findById = this.categoryRepository.findById(id);

		log.info("category is ::" + findById.get().getCategoryname());
//		if (Optional.empty() != null) {
//			return Optional.empty();
//		}
		return findById;
	}

	@Override
	public String categoryRemove(long id) {
		Optional<Category> findById = this.categoryRepository.findById(id);

		if (!findById.isPresent())
			return "Our Database Category is Not Exists this id " + id;
		this.categoryRepository.deleteById(id);

		return "Category Deleted !!";
	}

	@Override
	public boolean updateCategory(CategoryDto categoryDto, long id) {
		Optional<Category> findById = this.categoryRepository.findById(id);
		try {
		if (findById.isPresent()) {
			Category category = findById.get();
			category.setCategoryname(categoryDto.getCategoryname());
			category.setFilecategory(categoryDto.getFilecategory());
			Category map = this.mapper.map(categoryDto, Category.class);

			map.setCategoryname(category.getCategoryname());
			map.setFilecategory(category.getFilecategory());
			Category save = this.categoryRepository.save(map);
			if (save != null) {
				return true;
			}
			return true;
		}
		}catch (Exception e) {
			log.debug("Exceptions ", e.getMessage());
			return false;
		}
		return false;
		
	}

}
