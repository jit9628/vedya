package com.ecommarce.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommarce.api.entity.SizeMasterTable;

@Repository
public interface SizeMasterTableRepository extends JpaRepository<SizeMasterTable, Integer> {



}
