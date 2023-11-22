package com.ecommarce.api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OptionsGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String groupname;
	@OneToMany( fetch = FetchType.LAZY,cascade = CascadeType.DETACH, orphanRemoval = true,mappedBy = "grouped")
	//@JoinColumn(name = "groupid",insertable = true,updatable = true)
	@JsonManagedReference
	private Set<OptionForGroups> optionForGroup = new HashSet<>();
}
