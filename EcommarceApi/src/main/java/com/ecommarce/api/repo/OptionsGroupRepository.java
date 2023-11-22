package com.ecommarce.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommarce.api.entity.OptionsGroup;
@Repository
public interface OptionsGroupRepository extends JpaRepository<OptionsGroup, Integer> {


}
