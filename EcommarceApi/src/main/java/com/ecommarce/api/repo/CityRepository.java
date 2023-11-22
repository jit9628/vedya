package com.ecommarce.api.repo;

//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.ecommarce.api.entity.City;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	
	/*============= use springframework data jpa repository query===========================*/
	@Modifying
	@Query(value="select *from city ct where ct.stateids=:id", nativeQuery = true)
	public List<City> findByStateids(int id);
}
