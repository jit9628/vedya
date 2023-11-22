package com.ecommarce.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "getFilterDateAndRemarkWiseBookngOrderDetails", procedureName = "getFilterDateAndRemarkWiseBookngOrderDetails", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "fromdate", type = java.sql.Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "todate", type = java.sql.Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "remark", type = String.class), }) })
public class BookingProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bid;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "productsid", insertable = true, updatable = true, referencedColumnName = "pid")
	// @JsonBackReference
	private Product productid;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "usersid", insertable = true, updatable = true, referencedColumnName = "id")
	// @JsonBackReference
	private User userid;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "addressid", insertable = true, updatable = true, referencedColumnName = "id")
	// @JsonBackReference
	private Adderess addressid;
	private String remark;
	@Temporal(TemporalType.DATE)
	private Date currentdate;
	private String orderimages;
	public String order_booking_id;
	/*
	 * private long actualprice; private long discountprice; private long
	 * payableprice;
	 */

}
