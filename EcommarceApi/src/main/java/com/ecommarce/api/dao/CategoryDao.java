package com.ecommarce.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ecommarce.api.dto.CategoryDto;
import com.ecommarce.api.entity.Category;
import com.ecommarce.api.repo.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CategoryDao {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private EntityManager entityManager;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CategoryDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// @Transactional
	// @Transactional(dontRollbackOn = Exception.class, rollbackOn =
	// ProcessIncomingMessageException.class)

	public List<Category> topFourCategory() {
		try {
			List<Category> findByTop = this.categoryRepository.findByTop();
			return findByTop;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public List<CategoryDto> topListCategory() {
		try {

			return this.jdbcTemplate.query("select p.categoryname,p.filecategory, p.catid from category as p ",
					new RowMapper<CategoryDto>() {

						@Override
						public CategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
							CategoryDto dto = new CategoryDto();
							;
							// dto.setFilesretrieve(string.substring(1, string.length() - 1).split(",")[0]);
							dto.setCategoryname(rs.getString("categoryname"));
							dto.setCatid(rs.getLong("catid"));
							dto.setFilecategory(rs.getString("filecategory"));

							System.out.println("category name is --" + rs.getString("categoryname"));

							return dto;
						}

					});
		} catch (Exception e) {
			System.out.println("Latest Category Is :: " + e.getMessage());
		}
		return null;

	}

	public String getImageFileBasedOnCategory(long id) {
		try {
			String responsevalue = "";
			String sql = "select filecategory from category where catid='" + id + "'";
			Query createNativeQuery = this.entityManager.createNativeQuery(sql);
			List resultList = createNativeQuery.getResultList();
			String string = resultList.toString();
			String substring = string.substring(1, string.length() - 1);
			// String[] split = substring.split(",");
//				 for( String d:split) { responsevalue=d;
//				  log.info("Spli String  Image Files is :-"+d);
//				  log.info("Spli String  Image Files is :-"+responsevalue);
//				  
//				 
//				  
//				  }

			log.info("string value is :: " + substring);
			return substring;
		} catch (Exception e) {
			log.error("Exception is :-" + e.getMessage());
			return null;
		}
	}

}
