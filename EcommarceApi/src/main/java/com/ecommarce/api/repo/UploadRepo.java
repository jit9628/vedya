package com.ecommarce.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommarce.api.entity.UploadFile;

@Repository
public interface UploadRepo extends JpaRepository<UploadFile, Integer> {

}
