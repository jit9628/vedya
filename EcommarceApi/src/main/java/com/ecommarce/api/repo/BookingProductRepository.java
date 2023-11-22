package com.ecommarce.api.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommarce.api.entity.BookingProduct;

@Repository
//@FilterJoinTables(value = { @FilterJoinTable })
public interface BookingProductRepository extends JpaRepository<BookingProduct, Long> {

	/** ===== FindByDate==== */
	@Modifying
	@Query(value = "select * from booking_product where currentdate=:currentdate ", nativeQuery = true)
	List<BookingProduct> findByCurrentdate(Date currentdate);

	/*
	 * @Modifying
	 * 
	 * @Query(value="select * from booking_product where usersid=:userid "
	 * ,nativeQuery = true) List<BookingProduct> findByUserid(long userid);
	 */
	/* === FindByStatus======== */
	@Modifying
	@Query(value = "select p.productname,p.files, p.pid, p.productsize ,b.bid ,b.addressid ,b.currentdate ,b.productsid ,b.remark ,b.usersid from product as p inner join booking_product  as b on b.productsid= p.pid where b.usersid=2", nativeQuery = true)
	// @Query(value = "select p.productname from product as p inner join
	// booking_product as b on b.productsid= p.pid where b.usersid=2", nativeQuery =
	// true)
	List<BookingProduct> findByUserid(long userid);

//	void getFilterDateAndRemarkWiseBookngOrderDetails(String string, String string2, String string3);

	// List<BookingProduct> findByRemark(String remark);

	/*
	 * @Modifying
	 * 
	 * @Query(value = "delete from booking_product where booking_product.bid= ?",
	 * nativeQuery = true) void deleteByBid(@Param("bid") long bid);
	 */

	// @Query(value = "EXEC
	// filterDateAndRemarkWiseBookngOrderDetails(:fromDate,:toDate,:remark);",
	// nativeQuery = true)

	// @Procedure(procedureName = "abcd")
	
	//@Modifying
	//@Query(value = " exec filterDateAndRemarkWiseBookngOrderDetails(:fromDate,:toDate,:remark)", nativeQuery = true)
	//List<BookingProduct> getFilterDateAndRemarkWiseBookngOrderDetails(@Param("fromDate") String fromDate,
		//	@Param("toDate") String toDate, @Param("remark") String remark);
	// List<BookingProduct> getFilterDateAndRemarkWiseBookngOrderDetails();

}
