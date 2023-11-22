package com.ecommarce.api.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import com.ecommarce.api.entity.OptionForGroups;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionsGroupDto {

	@Column(name = "groupid")
	private int id;

	private String groupname;
	   private Set<OptionForGroups> optionForGroup = new HashSet<>();


}
