package com.ecommarce.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommarce.api.entity.OptionForGroups;


@Repository
public interface OptionForGroupsRepository extends JpaRepository<OptionForGroups, Integer> {

	@Query(
			  value = "SELECT * FROM option_for_groups u WHERE u.groupid = :groupid",
			  nativeQuery = true)
public List<OptionForGroups> findByGrouped(int groupid);
}
