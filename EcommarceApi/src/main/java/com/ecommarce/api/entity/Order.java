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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Order_Tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
//	@GeneratedValue(generator = "uuid2")
//	@GenericGenerator(name = "uuid2", strategy = "uuid2")
//	@Column(name = "uuid", columnDefinition = "BINARY(16)")
//	private UUID uuid;
/* One Customer can have many orders */
	@OneToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "orderss",orphanRemoval = true)
	@JsonManagedReference
	   private Set<Product> product = new HashSet<>();
	@OneToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "orders")
	@JsonManagedReference
	   private Set<User> customer = new HashSet<>();
}
