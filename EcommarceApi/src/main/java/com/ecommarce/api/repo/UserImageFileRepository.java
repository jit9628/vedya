package com.ecommarce.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommarce.api.entity.UserImageFile;

@Repository
public interface UserImageFileRepository extends JpaRepository<UserImageFile, Integer> {

	@Query(value = "select *from user_image_file where uid=:id", nativeQuery = true)
	UserImageFile findByUid(long id);
}
