package com.ecommarce.api.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecommarce.api.CheckAuthenticateUser;
import com.ecommarce.api.FileUploadHelper;
import com.ecommarce.api.dto.CategoryDto;
import com.ecommarce.api.entity.AboutBrand;
import com.ecommarce.api.entity.BookingProduct;
import com.ecommarce.api.entity.Category;
import com.ecommarce.api.service.AboutBrandService;
import com.ecommarce.api.service.BookingProductService;
import com.ecommarce.api.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/admin/")
@Slf4j
public class AdminController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	FileUploadHelper fuh;
	@Autowired
	private CheckAuthenticateUser checkAuthenticateUser;

	@Autowired
	private BookingProductService bookingProductService;
//	@Autowired
//	private FileUploadDAO fileUploadDao;
	@Autowired
	private AboutBrandService aboutBrandService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> showUploadForm(HttpServletRequest request) {
		Map<String, Object> body = new HashMap<>();

//		int checkAuthenticatedIsTrue = checkAuthenticateUser.checkAuthenticatedIsTrue();
//		if (checkAuthenticatedIsTrue == 0) {
//body.put("status", "false");
//return new ResponseEntity<>(body,HttpStatus.OK);
//		//	return new ResponseEntity<>(Map.of("status", "false"), HttpStatus.OK);
//		}
//		if (checkAuthenticateUser.checkAuthority() == 1) {
//			body.put("status", "true");
//			return new ResponseEntity<>(body,HttpStatus.OK);
//			//return new ResponseEntity<>(Map.of("status", "true"), HttpStatus.OK);
//		}
		body.put("status", "false");
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("status", "false"), HttpStatus.OK);
	}

	@GetMapping("order-list")
	public ModelAndView getOrderListPage(ModelAndView mv, HttpServletRequest req) {
		mv.setViewName("/Admin/orderlist");
		return mv;
	}
	/*
	 * @GetMapping("getAllOrder") public ResponseEntity<?> getString() { try { int
	 * checkAuthenticatedIsTrue = checkAuthenticateUser.checkAuthenticatedIsTrue();
	 * if (checkAuthenticatedIsTrue == 0) {
	 * 
	 * return new ResponseEntity<>(Map.of("status", "false"), HttpStatus.OK); } if
	 * (checkAuthenticateUser.checkAuthority() == 1) {
	 * 
	 * Date date1=new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-08");
	 * List<BookingProduct> findBookingOrderByDate =
	 * this.bookingProductService.findBookingOrderByDate(date1); return new
	 * ResponseEntity<>(Map.of("status", "true","message",findBookingOrderByDate),
	 * HttpStatus.OK); } return new ResponseEntity<>(Map.of("status", "false"),
	 * HttpStatus.OK); } catch (Unauthorized e) {
	 * log.debug("UnAuthorize Exception"); return new
	 * ResponseEntity<>(Map.of("status", "UnAuthorized"), HttpStatus.UNAUTHORIZED);
	 * } catch (AuthenticationException ex) {
	 * log.info("Authentication Exception ex"); return new
	 * ResponseEntity<>(Map.of("status", "UnAuthentication Exception"),
	 * HttpStatus.OK);// TODO: handle exception } catch (Exception e) {
	 * log.debug("Other Exception"); return new
	 * ResponseEntity<>(Map.of("status","Other Exception"), HttpStatus.OK); } }
	 */

	@GetMapping("order-listdata")
	public ResponseEntity<?> getAllOrder() {
		Map<String, Object> body = new HashMap<>();
		body.put("status", this.bookingProductService.getAllBooking());
		return new ResponseEntity<>(body, HttpStatus.OK);

		// return new
		// ResponseEntity<>(Map.of("status",this.bookingProductService.getAllBooking()),
		// HttpStatus.OK);
	}

//    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
//    public String handleFileUpload(HttpServletRequest request,
//            @RequestBody MultipartFile file) throws Exception {
//
//    	boolean doFileUpload = fuh.doFileUpload(file);
//    	log.info("All Proccess Start ");
//    	if(doFileUpload)
//
//    	{
//	UploadFile uploadFile=new UploadFile();
//
////    		String originalFilename = file.getOriginalFilename();
////    		uploadFile.setFileName(originalFilename);
//
//    		//uploadFile.setFileName(fileName);
//	log.info("Original namet ");
//
//
//    		this.categoryService.saveFile(uploadFile);
//    		log.info("All Proccess have been Done ");
//    		return "File Uploaded";
//    	}
//    	else
//    	{
//    		return "Troubling from error";}
//
//    }

	@GetMapping("getcategory")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> addAllCategory() {
		try {
			List<Category> allCategory = this.categoryService.getAllCategory();
			Map map = new HashMap<>();
			map.put("message", "All Category is ");
			map.put("Data", allCategory);

			return new ResponseEntity<>(map, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}

	}

	@GetMapping("aboutbrand")
	public ModelAndView aboutBrand(ModelAndView MV) {

		// String discription = aboutBrand.getDiscription();
		// String[] split = discription.split(System.lineSeparator());
		// String lineSeparator = System.lineSeparator();
		// return (this.aboutBrandService.addBrand(aboutBrand))
		// ? new ResponseEntity<>(split, HttpStatus.OK)
		// : new ResponseEntity<>("Your Proccess is ends... ", HttpStatus.OK);
		MV.setViewName("/Admin/Add-Brand");
		return MV;
	}

	@PostMapping("add/aboutbrand")
	public ModelAndView addCategory(@ModelAttribute("categoryDto") AboutBrand aboutBrand,
			@RequestPart("file") MultipartFile file, HttpServletRequest request, ModelAndView mv) {

		String msg = "";
		try {

			log.debug("multipart file is :" + file.getOriginalFilename());
			log.debug("category name   is :" + aboutBrand.getDiscription());

			if (aboutBrand.getDiscription().equals("") || aboutBrand.getDiscription() == null) {
				msg = " Category Field Can Not Be Blank : ";
				mv.addObject("msg", msg);
				mv.setViewName("/Admin/Add-Brand");
				return mv;
			}

			if (file.isEmpty()) {
				msg = " Select Image File  : ";
				mv.addObject("msg", msg);
				mv.setViewName("/Admin/Add-Brand");
				return mv;
			}

			fuh.doFileUpload(file, request);
			aboutBrand.setFilebrand(file.getOriginalFilename());
			boolean addCategory = this.aboutBrandService.addBrand(aboutBrand);

			if (addCategory) {
				mv.setViewName("/Admin/Add-Brand");
				return mv;
			}
		} catch (BindException e) {
			msg = "Category Can Not Be Blank Or Empty";
			mv.addObject("msg", msg);
			log.info("BindException Exception");
			mv.setViewName("redirect:/api/page/index");
			return mv;
		} catch (BadRequest e) {
			msg = "Category Can Not Be Blank Or Empty";
			log.info("BadRequest Exception");
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/index");
			return mv;
		} catch (MultipartException multipartException) {
			msg = " Please Select image";
			log.info("BadRequest Exception");
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/index");
			return mv;
		} catch (Exception e) {
			msg = "Category Can Not Be Blank Or Empty";
			log.info("Root Exception" + e.getMessage());
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/index");
			return mv;
		}
		return mv;

	}
	
	@GetMapping("all-brands")
	public ResponseEntity<?> getBrandData(){
		return new ResponseEntity<>("Data Available",HttpStatus.OK);
	}
	 

}
