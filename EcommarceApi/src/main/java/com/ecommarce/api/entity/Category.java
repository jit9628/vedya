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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@EqualsAndHashCode.Exclude
//@ToString.Exclude
public class Category {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
private long catid;
private String categoryname;
private String filecategory;

@OneToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "category",orphanRemoval = true)
@JsonManagedReference
   private Set<Product> product = new HashSet<>();
}
