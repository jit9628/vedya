package com.ecommarce.api.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ecommarce.api.entity.OptionForGroups;
import com.ecommarce.api.repo.OptionForGroupsRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class OptionForGroupsDao {

	private OptionForGroupsRepository forGroupsRepository;

	public List<OptionForGroups> findByGroupId(int id) {

		try {

			 List<OptionForGroups> findByGrouped = this.forGroupsRepository.findByGrouped(id);
			return findByGrouped;


		}catch (Exception e) {
		 e.getMessage();
		 System.out.println(e.getMessage());
		}
		return null;

	}

}
