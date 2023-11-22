package com.ecommarce.api.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommarce.api.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	// @Query(value = "SELECT * FROM Product as p WHERE p.productname
	// =:productname", nativeQuery = false)

//	@Query("SELECT  P.productname FROM Product P WHERE P.productname=:productname")
	public Product findByproductname(String productname);

	@Query(value = "SELECT * FROM product p WHERE p.productname = :productname", nativeQuery = true)
	public Product ExistsByName(String productname);

//	@Query(value = "SELECT * FROM product p WHERE p.catid = :catid", nativeQuery = true)
//	public List<Product> findByCategory(long catid);

	@Query(value = "select * from product p where p.catid=:catid", nativeQuery = true)
	// @Query(value = "select top 2 * from product p where
	// p.catid=:catid",nativeQuery = true)
	public List<Product> findByCategory(long catid);
	@Query(value = "select * from product p where p.price Between :priceone and :pricetwo", nativeQuery = true)

	List<Product> findByPrice(long priceone,long pricetwo);
	
	
}
