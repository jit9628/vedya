package com.ecommarce.api.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommarce.api.repo.UserRepository;

@Component
public class UserDao {
	@Autowired
	private UserRepository repository;
	@Transactional
	public String getRole(long user_id) {
		//return this.repository.findByRoles(user_id);
	return null;
	}
	
	@Transactional
	public long totalUserCount() {
		long countByRolesId = this.repository.countByRolesId();
		return countByRolesId;
	}
}
