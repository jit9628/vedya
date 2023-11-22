package com.ecommarce.api.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 20)
	private String firstname;

	@Size(max = 20)
	private String lastname;
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@NotBlank
	@Size(min = 6, max = 40)
	private String mobile;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", insertable = true, updatable = true), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "orderid")
//	  @Fetch(FetchMode.JOIN)
	@JsonBackReference
//	  @JsonIgnore
	private Order orders;
//@Transient
	private String token;
//@Transient
private LocalDateTime tokancreationdate;
	private String otpverifier;
	
	
	/*
	 * // onetoone relationship
	 * 
	 * @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional =
	 * true, orphanRemoval = true) private Adderess adderess;
	 */

	/*
	 * public User() { }
	 *
	 * // for username,email,password public User(String username, String email,
	 * String password) { this.username = username; this.email = email;
	 * this.password = password; }
	 *
	 * public User(String firstname,String lastname,String username, String email,
	 * String password) { this.username = firstname; this.username = lastname;
	 * this.username = username; this.email = email; this.password = password; }
	 *
	 * public User(String fisrtname, String lastname, String username,String email,
	 * String password, String mobile) { super(); this.fisrtname = fisrtname;
	 * this.lastname = lastname; this.username = username; this.email = email;
	 * this.password = password; this.mobile = mobile;
	 *
	 * }
	 *
	 * public Long getId() { return id; }
	 *
	 * public void setId(Long id) { this.id = id; }
	 *
	 * public String getFisrtname() { return fisrtname; }
	 *
	 *
	 *
	 * public void setFisrtname(String fisrtname) { this.fisrtname = fisrtname; }
	 *
	 *
	 *
	 * public String getLastname() { return lastname; }
	 *
	 *
	 *
	 * public void setLastname(String lastname) { this.lastname = lastname; }
	 *
	 *
	 * public String getUsername() { return username; }
	 *
	 * public void setUsername(String username) { this.username = username; }
	 *
	 * public String getEmail() { return email; }
	 *
	 * public void setEmail(String email) { this.email = email; }
	 *
	 * public String getPassword() { return password; }
	 *
	 * public void setPassword(String password) { this.password = password; }
	 *
	 *
	 *
	 * public String getMobile() { return mobile; }
	 *
	 * public void setMobile(String mobile) { this.mobile = mobile; }
	 *
	 * public Set<Role> getRoles() { return roles; }
	 *
	 * public void setRoles(Set<Role> roles) { this.roles = roles; }
	 *
	 */
}
