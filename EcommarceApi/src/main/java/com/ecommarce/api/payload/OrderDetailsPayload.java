package com.ecommarce.api.payload;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsPayload {

	@Autowired
	private EntityManager entityManager;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public OrderDetailsPayload(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<OrderDetailsPojo> getBookingDetail(String remark) {
	//	getSpecificUserBookingDetail() ;
		try {

			return this.jdbcTemplate.query(
					"select bp.bid, bp.orderimages,p.price,p.productname,bp.remark ,CONCAT(adr.firstname, ' ', adr.lastname) AS customername, CONCAT(adr.localadderess, ' ', adr.city,   ' ' ,adr.postalcode) AS deliverdaddress ,bp.order_booking_id from  booking_product as bp inner join adderess as adr on bp.addressid=adr.id inner join product as p on bp.productsid=p.pid where remark='"+remark+"'",
					new RowMapper<OrderDetailsPojo>() {

						@Override
						public OrderDetailsPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
							OrderDetailsPojo pojo = new OrderDetailsPojo();

							pojo.setCustomername(rs.getString("customername"));
							pojo.setPrice(rs.getLong("price"));
							pojo.setOrderstatus(rs.getString("remark"));
							pojo.setOrderimage(rs.getString("orderimages"));
							pojo.setOrderid(rs.getLong("order_booking_id"));
							pojo.setOrderaddress(rs.getString("deliverdaddress"));
							pojo.setOpname(rs.getString("productname"));
							System.out.println("Customer Name Is :: " + rs.getString("customername"));
							System.out.println("List Order Details :" + pojo);
							return pojo;
						}
					});
			// return (List<BookingProductDto>) bookingProductDto;
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
			return null;
		}
	}

	public List<OrderDetailsPojo> getSpecificUserBookingDetail(long orderid) {

		
		try {

			//a.userid='2' and 
			return this.jdbcTemplate.query(
					"Select a.userid, a.localadderess,a.city,b.orderimages,p.productname,b.order_booking_id ,b.remark,a.country,concat(a.firstname,'  ',a.lastname) as customername, p.price,p.price,Sum(p.price)   Over(partition by order_booking_id order by order_booking_id)as total_sum\r\n"
					+ "From adderess a "
					+ "Inner join booking_product b "
					+ "On a.userid = b.usersid "
					+ "Inner join product p "
					+ "On b.productsid=p.pid "
					+ "where order_booking_id ='"+orderid+"' "
					+ "Group by a.userid, a.localadderess,a.city,p.productname,p.price,b.order_booking_id,b.orderimages,b.remark ,a.country,a.firstname,a.lastname",
					new RowMapper<OrderDetailsPojo>() {

						@Override
						public OrderDetailsPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
							OrderDetailsPojo pojo = new OrderDetailsPojo();

							//pojo.setCustomername(rs.getString("localadderess"));

							pojo.setPrice(rs.getLong("price"));
							pojo.setTotalprice(rs.getLong("total_sum"));
						pojo.setOrderstatus(rs.getString("remark"));
							pojo.setOrderimage(rs.getString("orderimages"));
							pojo.setOrderid(rs.getLong("order_booking_id"));
							pojo.setOrderaddress(rs.getString("localadderess"));
							pojo.setOpname(rs.getString("productname"));
							pojo.setCustomername(rs.getString("customername"));
							System.out.println("localadderess  Is :: " + rs.getString("localadderess"));
							System.out.println("List Order Details :" + pojo);
							return pojo;
						}
					});
			// return (List<BookingProductDto>) bookingProductDto;
		} catch (Exception e) {
			System.out.println("Exception is :" + e);
			return null;
		}
	}

}
