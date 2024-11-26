package com.ecommarce.api.entity;

import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@NotBlank(message = "product name can not be blank")
	private String productname;
	private long price;
	@NotBlank(message = "SKU can not be blank")
	private String sku;
	@NotBlank(message = "discription can not be blank")
@Size(max = 512)
	//@Column(columnDefinition="TEXT",name ="discription" )
	private String discription;
	private String files;
	@Transient
	public String[] filesretrieve;
	private boolean isActive;
	private int stocks;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "catid")
//	  @Fetch(FetchMode.JOIN)
	@JsonBackReference
//	  @JsonIgnore
	private Category category;
//	@OneToMany(mappedBy = "product", cascade = { CascadeType.ALL },fetch = FetchType.LAZY,orphanRemoval = true)
//	@JsonManagedReference
//
//	private List<Order> orderss = new ArrayList<>();
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "orderid")
//	  @Fetch(FetchMode.JOIN)
	@JsonBackReference
//	  @JsonIgnore
	private Order orderss;
//	private String[] size;
	private TreeSet<String> productsize = new TreeSet<>();
	private int createdby;
	private int updatedby;
	private boolean isOpen;
	/*
	 * @Column
	 *
	 * @ElementCollection(targetClass=String.class) private List<String> sized=new
	 * ArrayList<>();
	 *
	 * @Transient private String[] sizes;
	 */

//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,optional = true)
//	@JoinColumn(name = "poid")
//private ProductOption productoption;

	/*
	 * public int getPid() { return pid; }
	 *
	 * public void setPid(int pid) { this.pid = pid; }
	 *
	 * public String getProductname() { return productname; }
	 *
	 * public void setProductname(String productname) { this.productname =
	 * productname; }
	 *
	 * public String getDiscription() { return discription; }
	 *
	 * public void setDiscription(String discription) { this.discription =
	 * discription; }
	 *
	 * public String getFiles() { return files; }
	 *
	 * public void setFiles(String files) { this.files = files; }
	 *
	 * public boolean isActive() { return isActive; }
	 *
	 * public void setActive(boolean isActive) { this.isActive = isActive; }
	 *
	 * public Category getCategory() { return category; }
	 *
	 * public void setCategory(Category category) { this.category = category; }
	 *
	 * public Order getOrderss() { return orderss; }
	 *
	 * public void setOrderss(Order orderss) { this.orderss = orderss; }
	 *
	 * public long getPrice() { return price; }
	 *
	 * public void setPrice(long price) { this.price = price; }
	 *
	 * public String getSku() { return sku; }
	 *
	 * public void setSku(String sku) { this.sku = sku; }
	 *
	 *
	 * public int getStocks() { return stocks; } public void setStocks(int stocks) {
	 * this.stocks = stocks; }
	 */

}
