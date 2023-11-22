package com.ecommarce.api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProductOption {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long poid; // product option id
	private String imagefile;
	@Transient
	private int size;
	@Transient
	private int colors;
	  @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "productoptionid")
//	  @JoinTable(  name = "user_roles",
//	        joinColumns = @JoinColumn(name = "user_id",insertable = true,updatable = true),
//	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<OptionForGroups> optionids = new HashSet<>();



//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//	private Set<OptionForGroups> optionids = new HashSet<>();
}
