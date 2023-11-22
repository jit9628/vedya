package com.ecommarce.api.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommarce.api.entity.AddToCart;
import com.ecommarce.api.entity.User;
import com.ecommarce.api.entity.Product;

@Repository
public interface AddToCartRepository extends JpaRepository<AddToCart, Integer> {
	@Modifying
	@Query(value = "select *from add_to_cart  where users=:users", nativeQuery = true)
	public List<AddToCart> findByUsers(long users);

//	@Modifying
//	@Query(value = "delete from add_to_cart  atc where atc.productid=:id and atc.users=:userid", nativeQuery = true)
//	public int deleteproductfromcart(int id, long userid);

//	@Modifying
//	@Query(value = "delete from add_to_cart  atc where atc.productid=:id and atc.users=:userid", nativeQuery = true)
//	void deleteByProductsAndUsers(int id, long userid);

	@Modifying
	@Query(value = "delete from add_to_cart  atc where atc.productid=:products", nativeQuery = true)
	void deleteByProducts(int products);

	/*
	 * ==== override existsby method ============ Rule @Modifying can not be use
	 * boolean return type
	 */
	@Query(value = "select count(*) from add_to_cart  where productid=:id", nativeQuery = true)
	int existsByProducts(int id);

	@Query(value = "select count(*) from add_to_cart  where users=:users", nativeQuery = true)
	int existsByUsers(long users);

	@Query(value = "select count(*) from add_to_cart  where users=:users and productid=:id", nativeQuery = true)
	int existsByUsersAndProducts(long users, int id);

	// delete add to cart

	@Modifying
	@Query(value = "delete from add_to_cart where productid=:id and users=:userid", nativeQuery = true)
	public void deleteByProductsAndUsers(int id, long userid);

}
