package com.ecommarce.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommarce.api.entity.Adderess;
import java.util.List;
import com.ecommarce.api.entity.User;

@Repository
public interface AdderessRepository extends JpaRepository<Adderess, Integer> {
	@Modifying
	@Query(value = "select * from adderess where userid=:useradr", nativeQuery = true)
	List<Adderess> findByUseradr(long useradr);

	Boolean existsByEmail(String email);

	@Modifying
	@Query(value = "select * from adderess where email=:email", nativeQuery = true)
	List<Adderess> findByEmail(String email);

	@Modifying
	@Query(value = "delete from adderess where id=:id", nativeQuery = true)
	void deleteById(int id);

}
