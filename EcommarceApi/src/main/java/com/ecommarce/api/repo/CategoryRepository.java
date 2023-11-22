package com.ecommarce.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommarce.api.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Category findBycategoryname(String categoryname);

//	boolean exexistsBycategoryname();
	public Category findBycatid(long catid);
	
	@Modifying
	@Query(value="SELECT TOP 4 *from category",nativeQuery = true)
	public List<Category> findByTop();
}
