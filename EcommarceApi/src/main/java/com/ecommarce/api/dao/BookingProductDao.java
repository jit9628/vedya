package com.ecommarce.api.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.ecommarce.api.dto.BookingProductDto;
import com.ecommarce.api.entity.BookingProduct;
import com.ecommarce.api.repo.BookingProductRepository;

import lombok.NoArgsConstructor;

@Component
//@NoArgsConstructor
public class BookingProductDao {
	@Autowired
	private BookingProductRepository bookingProductRepository;

	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EntityManager entityManager;

	@Autowired
	public BookingProductDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<BookingProduct> findBookedOrderByDate(Date Date) {
		try {
			List<BookingProduct> findByCurrentdate = this.bookingProductRepository.findByCurrentdate(Date);
			return findByCurrentdate;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

//	@Transactional
	public List<BookingProduct> findProductByUser(long userid) {
		try {
			List<BookingProduct> findByUserid = this.bookingProductRepository.findByUserid(2);
			return findByUserid;
		} catch (Exception e) {
			e.getMessage();

		}
		return null;

	}

	public List<BookingProductDto> getBookingDetail(long id) {

		try {

			return this.jdbcTemplate.query(
					"select p.productname,p.files, p.price, p.pid, p.productsize ,b.bid ,b.addressid,b.currentdate,b.productsid ,b.remark ,b.orderimages,b.order_booking_id from product as p inner join booking_product  as b on b.productsid= p.pid where b.usersid='"
							+ id + "'",
					new RowMapper<BookingProductDto>() {

						@Override
						public BookingProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
							BookingProductDto bookingProductDto = new BookingProductDto();
							bookingProductDto.setProductname(rs.getString("productname"));
							bookingProductDto.setBid(rs.getLong("bid"));
							String string = rs.getString("files");

							System.out.println("String File Is :" + string);
							String substring = string.substring(1, string.length() - 1);
							bookingProductDto.setProductimage(string.substring(1, string.length() - 1).split(",")[0]);
							bookingProductDto.setRemark(rs.getString("remark"));
							bookingProductDto.setPrice(rs.getLong("price"));
							bookingProductDto.setOrderimages(rs.getString("orderimages"));
							bookingProductDto.setOrder_booking_id(rs.getString("order_booking_id"));
							System.out.println(rs.getString("productname") + "booking id is ::" + rs.getLong("bid"));
							return bookingProductDto;
						}
					});
			// return (List<BookingProductDto>) bookingProductDto;
		} catch (Exception e) {
			return null;
		}
	}

	/* ============== DELETE ORDER ====================== */

	public int deleteOrder(long id) throws SQLException {

		try {
			String queries = "delete from booking_product where bid='" + id + "'";
			int update = this.jdbcTemplate.update(queries);
			return update;
		} catch (Exception e) {
			return 0;
		}

	}

	/* ============== status update===================== */

	public int updateOrderStatus(long id, String status) throws SQLException {

		try {
			String queries = "update booking_product set remark ='" + status + "' where order_booking_id='" + id + "'";
			int update = this.jdbcTemplate.update(queries);
			return update;
		} catch (Exception e) {
			return 0;
		}

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getFilterDateAndRemarkWiseBookngOrderDetails(java.sql.Date fromDate,
			java.sql.Date toDate, String remark) {
		/*
		 * StoredProcedureQuery createStoredProcedureQuery =
		 * this.entityManager.createStoredProcedureQuery(
		 * "getFilterDateAndRemarkWiseBookngOrderDetails(?,?,?)", BookingProduct.class);
		 * createStoredProcedureQuery.setParameter("fromDate", fromDate);
		 * createStoredProcedureQuery.setParameter("toDate", fromDate);
		 * createStoredProcedureQuery.setParameter("remark", remark); boolean execute =
		 * createStoredProcedureQuery.execute(); System.out.println("execute"+execute);
		 * 
		 * 
		 * SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		 * .withProcedureName("getFilterDateAndRemarkWiseBookngOrderDetails")
		 * .declareParameters( new SqlParameter("fromDate", Types.DATE), new
		 * SqlParameter("toDate", Types.DATE), new SqlParameter("remark", Types.VARCHAR)
		 * );
		 * 
		 */
		/* Calling Stored Procedure using JdbcTemplate */

		List<SqlParameter> parameters = new ArrayList<>();
		parameters.add(new SqlParameter(Types.DATE));
		parameters.add(new SqlParameter(Types.VARCHAR));
		Map<String, Object> call = jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("{call getFilterDateAndRemarkWiseBookngOrderDetails(?,?,?)}");
				// cs.setString(1, fromDate);
				cs.setDate(1, fromDate);
				cs.setDate(2, toDate);
				// cs.setString(2, toDate);
				cs.setString(3, remark);
				return cs;
			}
		}, parameters);

		System.out.println("CALL" + call);
		call.values();
		System.out.println("List Call :" + call.values());
		return call;
	}

	public List<BookingProduct> getFilterDatas() {

		try {
			List resultList = this.entityManager
					.createNamedStoredProcedureQuery("getFilterDateAndRemarkWiseBookngOrderDetails")
					.setParameter("fromdate", java.sql.Date.valueOf("2023-08-12")).setParameter("todate", java.sql.Date.valueOf("2023-08-18"))
					.setParameter("remark", "Dispatch").getResultList();
			// .getFirstResult();

			
			
			//System.out.println("List Of Data Is::"+);
			return resultList;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}

	}

}
