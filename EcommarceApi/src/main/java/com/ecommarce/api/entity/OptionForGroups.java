//package com.ecommarce.api.entity;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//public class OptionForGroups {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long optionId;
//	private String optionname;
//
//	// mapping one group can have many options
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,optional = true)
//	@JoinColumn(name = "groupid",insertable = true,updatable = true)
////	  @Fetch(FetchMode.JOIN)
//	 @JsonBackReference
//	  @JsonIgnore
//	private OptionsGroup grouped;
//
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "optionForGroups")
//	 @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name = "productoption_id")
//	private ProductOption productoptionid;
//}
