package com.ecommarce.api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommarce.api.entity.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	Optional<User> findByToken(String token);
	Optional<User>  findByOtpverifier(String otpverifier);
	
	//@Query(value = "select COUNT(*) from  users as usr inner join user_roles as u_role on usr.id=u_role.role_id where u_role.role_id='2'",nativeQuery = true)
	//@Modifying
	@Query(value = "select count(*) from user_roles where role_id=2",nativeQuery = true)
	
	public Integer countByRolesId();

//  @Modifying(clearAutomatically = true)
//  @Query("update User u set u.password =:isRead where feedEntry.id =:entryId")
//  void markEntryAsRead(@Param("entryId") Long rssFeedEntryId, @Param("isRead") boolean isRead);

}
