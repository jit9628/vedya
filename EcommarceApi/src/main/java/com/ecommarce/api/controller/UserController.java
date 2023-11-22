package com.ecommarce.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ecommarce.api.dao.AdderessDao;
import com.ecommarce.api.dao.BookingProductDao;
import com.ecommarce.api.dto.AddToCartDto;
import com.ecommarce.api.dto.BookingProductDto;
import com.ecommarce.api.dto.CategoryDto;
import com.ecommarce.api.dto.ProductDto;
import com.ecommarce.api.entity.BookingProduct;
import com.ecommarce.api.entity.Category;
import com.ecommarce.api.entity.ContactUs;
import com.ecommarce.api.entity.EmailDetails;
import com.ecommarce.api.entity.Product;
import com.ecommarce.api.service.AddToCartService;
import com.ecommarce.api.service.BookingProductService;
import com.ecommarce.api.service.CategoryService;
import com.ecommarce.api.service.ContactUsService;
import com.ecommarce.api.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/api/user/")
@Slf4j
public class UserController {
	@Autowired
	private BookingProductService bookingProductService;
	private AddToCartService addToCartService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CommonComponents commonComponents;

	@Autowired
	private BookingProductDao bookingProductDao;
	@Autowired
	private AdderessDao adderessDao;
	@Autowired
	private ProductService productService;
	@Autowired
	private ContactUsService contactUsService;

	@GetMapping("bookproduct")

	public ResponseEntity<?> bookiing(@RequestParam("adrid") int adrid, HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) {
		Map<String, Object> body = new HashMap<>();
		long attribute = (long) request.getSession().getAttribute("userid");
		log.info("users request id is ::" + attribute);
		boolean bookProduct = this.bookingProductService.bookProduct(attribute, adrid);
		if (!bookProduct) {
			body.put("message", bookProduct);
			body.put("successResponse", "Your Order can not  Booked ");
			return new ResponseEntity<>(body, HttpStatus.OK);
		}

		body.put("message", bookProduct);
		body.put("successResponse", "Your Order is Booked Please  Check Your Email id !");
		return new ResponseEntity<>(body, HttpStatus.OK);

		// return new ResponseEntity<>(Map.of("message", bookProduct), HttpStatus.OK);
	}

	@GetMapping("my-order")
	public ResponseEntity<?> getMyOrder(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> body = new HashMap<>();
		// boolean cancelOrder = this.bookingProductService.cancelOrder(10010);
		long attribute2 = (long) request.getSession().getAttribute("userid");
		// long attribute = (long)request.getAttribute("userid");
		log.info("User Id  are ::" + attribute2);
		List<BookingProductDto> bookingDetail = this.bookingProductDao.getBookingDetail(attribute2);
		List<BookingProduct> booking_order_detail = this.bookingProductService.findByUserId(attribute2);

		List<CategoryDto> CategoryDatalist = commonComponents.getAllCategories();
		log.info("details are ::" + booking_order_detail);
		body.put("bookingDetail", bookingDetail);
		body.put("CategoryDatalist", CategoryDatalist);
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("status", "200", "message",findByUserId),
		// HttpStatus.OK);
	}

//
//	@GetMapping("forgote-password")
//	// @PreAuthorize("hashRole('ROLE_USER')")
//	public ResponseEntity<?> forgotePassword() {
//
//		return new ResponseEntity<>(Map.of("status", "200", "message", "You have Access Your Order"), HttpStatus.OK);
//	}

	/* ================= ADD TO CART PRODUCT=================== */

	@GetMapping("addtocartproduct")

	public ResponseEntity<?> addProductInCart(@RequestParam("products") int products, @RequestParam("size") String size,
			HttpServletRequest request, HttpSession s) {
		Map<String, Object> body = new HashMap<>();
		log.info("call add to product method and return json response... ");
		try {
			log.info(" Session value is :: " + s.getAttribute("userid"));
			log.info("Session ::" + request.getSession().getAttribute("userid"));
			HttpSession session = request.getSession();
			session.getServletContext().getAttribute("userid");
			log.info("context object ::" + session.getServletContext().getAttribute("userid"));
			if (request.getSession().getAttribute("userid") != null
					&& request.getSession().getAttribute("userid") != "") {

				Long attribute = (Long) request.getSession().getAttribute("userid");
				log.info("user id is");
				AddToCartDto addToCart = new AddToCartDto();
				addToCart.setProducts(products);
				addToCart.setUsersid(attribute);
				addToCart.setColor("blue");
				addToCart.setSize(size);
				int addProductToCart = this.addToCartService.addProductToCart(addToCart);
				log.info("return value is :: " + addProductToCart);
				if (addProductToCart == 1) {

					body.put("status", "200");
					body.put("message", "Your Product is Add To Cart");
					return new ResponseEntity<>(body, HttpStatus.OK);

				} else {
					body.put("status", "409");
					body.put("message", "Your Product is Exists Add To Cart");
					return new ResponseEntity<>(body, HttpStatus.OK);

				}

//						? new ResponseEntity<>(Map.of("status", "200", "message", "Your Product is Add To Cart"),
//								HttpStatus.OK)
//						: new ResponseEntity<>(Map.of("status", "409", "message", "Your Product is Exists Add To Cart"),
//								HttpStatus.CONFLICT);
			} else {

				body.put("status", "204");
				body.put("message", "UnAuthorized User");
				return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);

//				return new ResponseEntity<>(Map.of("status", "401", "message", "UnAuthorized User"),
//						HttpStatus.UNAUTHORIZED);
			}
		} catch (NullPointerException ex) {
			body.put("status", "202");
			body.put("message", "Internal Server Error");
			return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
//			
//			return new ResponseEntity<>(Map.of("status", "204","message", "Internal Server Error"),
//					HttpStatus.NO_CONTENT);

		} catch (Exception ex) {

			body.put("status", "500");
			body.put("message", "Internal Server Error");
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
//			return new ResponseEntity<>(Map.of("status", "401", "message", "Internal Server Error"),
//					HttpStatus.INTERNAL_SERVER_ERROR);

			// return new ResponseEntity<>(Map.of("message", ex.getLocalizedMessage()),
			// HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("cancelorder")
	public ResponseEntity<?> cancelOrderProduct(@RequestParam("bid") long bid, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> body = new HashMap<>();
		try {
			log.isDebugEnabled();

			int deleteOrder = this.bookingProductDao.deleteOrder(bid);
			log.info("delete retur value is " + deleteOrder);
			// boolean cancelOrder = this.bookingProductService.cancelOrder(bid);
			// log.debug("{}", cancelOrder);
			if (deleteOrder == 1) {
				log.debug(" deleteOrder {}", deleteOrder);
				body.put("message", "deleted Order");
				body.put("statusCode", "200");
				body.put("status", deleteOrder);
				return new ResponseEntity<>(body, HttpStatus.OK);
			} else {
				log.debug(" deleteOrder {}", deleteOrder);
				body.put("message", " Can't deleted Order");
				body.put("statusCode", "415");
				body.put("status", deleteOrder);
				return new ResponseEntity<>(body, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
			}
		} catch (Exception e) {
			body.put("message", e);
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("deleteAddress/{id}")
	public ResponseEntity<?> deleteAdderess(@PathVariable("id") long id) {
		Map<String, Object> body = new HashMap<>();
		try {
			int deleteAdderess = this.adderessDao.deleteAdderess(id);
			if (deleteAdderess == 1) {
				body.put("message", "deleted Order");
				body.put("statusCode", "200");
				body.put("status", deleteAdderess);
				return new ResponseEntity<>(body, HttpStatus.OK);
			}
			body.put("message", "This Address Is Used");
			body.put("statusCode", "226");
			return new ResponseEntity<>(body, HttpStatus.IM_USED);
		} catch (Exception e) {

			body.put("message", "This Address Is Used");
			body.put("statusCode", "226");
			return new ResponseEntity<>(body, HttpStatus.IM_USED);
		}

	}

	/* ===filtering data price */
	@GetMapping("filterPrice/{priceone}/{pricetwo}")
	public ResponseEntity<?> getFilteringPriceData(@PathVariable("priceone") long priceone,
			@PathVariable("pricetwo") long pricetwo) {
		Map<String, Object> body = new HashMap<>();
		List<Product> allProduct = null;
		List<ProductDto> listOfObject = null;
		try {
			allProduct = this.productService.filterProductByPrice(priceone, pricetwo);
			List<Category> allcategories = null;
			allcategories = categoryService.getAllCategory();
			listOfObject = new ArrayList<>();
			String files = "";
			for (int i = 0; i < allProduct.size(); i++) {
				ProductDto dto = new ProductDto();
				dto.setProductname(allProduct.get(i).getProductname());
				dto.setPid(allProduct.get(i).getPid());
				dto.setPrice(allProduct.get(i).getPrice());
				dto.setSku(allProduct.get(i).getSku());
				files = allProduct.get(i).getFiles();
				String filesName = files.substring(1, files.length() - 1);
				dto.setFilesretrieve(filesName.split(","));
				listOfObject.add(dto);
			}

			List<CategoryDto> CategoryDatalist = commonComponents.getAllCategories();
			body.put("status", "200");
			body.put("listOfData", listOfObject);
			body.put("CategoryDatalist", CategoryDatalist);
			return new ResponseEntity<>(body, HttpStatus.OK);
		} catch (NullPointerException e) {
			log.info("Execute Null Pointer Exception");
			List<Category> allcategories = null;
			allcategories = categoryService.getAllCategory();
			listOfObject = new ArrayList<>();
			String files = "";
			for (int i = 0; i < allProduct.size(); i++) {
				ProductDto dto = new ProductDto();
				dto.setProductname(allProduct.get(i).getProductname());
				dto.setPid(allProduct.get(i).getPid());
				dto.setPrice(allProduct.get(i).getPrice());
				dto.setSku(allProduct.get(i).getSku());
				files = allProduct.get(i).getFiles();
				String filesName = files.substring(1, files.length() - 1);
				dto.setFilesretrieve(filesName.split(","));
				listOfObject.add(dto);
			}

			List<CategoryDto> CategoryDatalist = commonComponents.getAllCategories();
			body.put("status", "201");
			body.put("listOfData", listOfObject);
			body.put("CategoryDatalist", CategoryDatalist);
			return new ResponseEntity<>(body, HttpStatus.OK);
		}

		catch (Exception e) {

			body.put("message", e.getMessage());
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//@GetMapping("filterPrice/{priceone}/{pricetwo}")
	public ModelAndView getProductDetailsPage(@PathVariable("priceone") long priceone,
			@PathVariable("pricetwo") long pricetwo, ModelAndView mv) {
		try {
			// allproducts are
			List<Product> allProduct = this.productService.filterProductByPrice(priceone, pricetwo);
			// List<Product> allProduct = productService.getAllProduct();
			List<ProductDto> listOfObject = new ArrayList<>();
			String files = "";

			for (int i = 0; i < allProduct.size(); i++) {
				ProductDto dto = new ProductDto();
				dto.setProductname(allProduct.get(i).getProductname());
				dto.setPid(allProduct.get(i).getPid());
				dto.setPrice(allProduct.get(i).getPrice());
				dto.setSku(allProduct.get(i).getSku());
				files = allProduct.get(i).getFiles();
				String filesName = files.substring(1, files.length() - 1);

				dto.setFilesretrieve(filesName.split(","));
				listOfObject.add(dto);
			}
			mv.addObject("listOfData", listOfObject);
			mv.setViewName("shop");
			return mv;
		} catch (Exception e) {
			e.getMessage();
		}
		return mv;
	}

	/* =========================Handle ContactUs Service===================== */

	@GetMapping("getintouch")
	public ModelAndView getContactUsPage(ModelAndView modelAndView) {
		modelAndView.setViewName("contactus");
		return modelAndView;
	}

	@GetMapping("touch")
	public ResponseEntity<?> getInTouch(@RequestBody ContactUs contactUs) {

		return (this.contactUsService.addContacts(contactUs))
				? new ResponseEntity<>("i will be shortlly contact  with youb ", HttpStatus.OK)
				: new ResponseEntity<>("i will be shortlly contact  with youb ", HttpStatus.OK);
	}
	
	
	
	
	

}