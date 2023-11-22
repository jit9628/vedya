package com.ecommarce.api.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommarce.api.dao.BookingProductDao;
import com.ecommarce.api.entity.AddToCart;
import com.ecommarce.api.entity.BookingProduct;
import com.ecommarce.api.entity.EmailDetails;
import com.ecommarce.api.repo.AddToCartRepository;
import com.ecommarce.api.repo.AdderessRepository;
import com.ecommarce.api.repo.BookingProductRepository;
import com.ecommarce.api.service.BookingProductService;
import com.ecommarce.api.service.EmailService;
import com.ecommarce.api.utility.RandomStringValue;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingProductServiceImpl implements BookingProductService {
	@Autowired
	private AddToCartRepository addToCartRepository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private BookingProductRepository bookingProductRepository;
	@Autowired
	private BookingProductDao bookingProductDao;
	@Autowired
	private AdderessRepository adderessRepository;
	@Autowired
	private EmailDetails details;
	
	@Autowired
	private EmailService emailService;

	@Override
	public boolean bookProduct(long id, int adrid) {
		String randomnumber = "";
		randomnumber = RandomStringValue.getRandomNumber();

		List<AddToCart> findByUsers = this.addToCartRepository.findByUsers(id);
		log.info("add cart data is :: " + findByUsers.get(0).getProducts().getPid());
		int size = findByUsers.size();
		List<BookingProduct> bookingproductdata = new ArrayList<>();
		for (int i = 0; i < findByUsers.size(); i++) {
			BookingProduct dto = new BookingProduct();
			dto.setProductid(findByUsers.get(i).getProducts());
			dto.setUserid(findByUsers.get(i).getUsers());
			
			dto.setRemark("In Progress");
			dto.setCurrentdate(new Date());

			dto.setOrderimages(findByUsers.get(i).getOrderimage());
			bookingproductdata.add(dto);
			BookingProduct map = this.mapper.map(dto, BookingProduct.class);
			map.setProductid(dto.getProductid());

			map.setAddressid(this.adderessRepository.findById(adrid).get());
			map.setOrder_booking_id(randomnumber);
			this.bookingProductRepository.save(map);
			this.addToCartRepository.deleteById(findByUsers.get(i).getCartid());
		}
		details.setRecipient(this.adderessRepository.findById(adrid).get().getEmail());
		details.setMsgBody(randomnumber);
		details.setSubject("Bookid Order Status");
		
		String sendSimpleMail = emailService.sendSimpleMail(details);
		log.info(sendSimpleMail);
		
		
// convert dto into entity
//	BookingProduct map = this.mapper.map(bookingproductdata, BookingProduct.class);
//		this.bookingProductRepository.save(map);

		log.info("list Of Data Is ::" + findByUsers);
		return true;
	}

	@Override
	public List<BookingProduct> findBookingOrderByDate(Date Date) {
		try {
			List<BookingProduct> findBookedOrderByDate = this.bookingProductDao.findBookedOrderByDate(Date);
			// List<BookingProduct> filter =
			// findBookedOrderByDate.stream().filter(x->x.getRemark().equals("Booked")).toList();

			// log.info(("filter Data is "+filter.get(0).getCurrentdate()));
			return findBookedOrderByDate;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;

	}

	@Override
	public List<BookingProduct> getProductByRemark(String remark) {
		try {
			// this.bookingProductRepository.findByRemark(remark);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<BookingProduct> getAllBooking() {
		// TODO Auto-generated method stub
		return this.bookingProductRepository.findAll();
	}

	@Override
	public List<BookingProduct> findByUserId(long id) {

//	List<BookingProduct> findByUserid = this.bookingProductDao.findProductByUser(id);
		List<BookingProduct> findByUserid = this.bookingProductDao.findProductByUser(id);

		log.info("details are :" + findByUserid);
		return findByUserid;
	}

	@Override
	public boolean cancelOrder(long bid) {
		try {
			this.bookingProductRepository.deleteById(bid);
			return true;
		} catch (Exception e) {
			log.info("Exception is :: " + e);
			e.getStackTrace();
			return false;
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public Map<String,Object> getFilterDateAndRemarkWiseBookngOrderDetails(String fromdate,String todate,String remark) {
		
	java.sql.Date fromdates = java.sql.Date.valueOf(fromdate);
	java.sql.Date toDates = java.sql.Date.valueOf(todate);
	System.out.println("fromdates"+fromdates);
	System.out.println("toDates"+toDates);
	Map<String, Object> filterDateAndRemarkWiseBookngOrderDetails = this.bookingProductDao.getFilterDateAndRemarkWiseBookngOrderDetails(fromdates, toDates, remark);
		/*List<BookingProduct> filterDateAndRemarkWiseBookngOrderDetails = this.bookingProductRepository.getFilterDateAndRemarkWiseBookngOrderDetails();
		return filterDateAndRemarkWiseBookngOrderDetails;*/
	log.info("Filtering Datas Are : "+filterDateAndRemarkWiseBookngOrderDetails);
		return filterDateAndRemarkWiseBookngOrderDetails;
	}

	@Override
	public int totalProducts() {
		long count = this.bookingProductRepository.count();
		return (int)count;
	}

	
}
