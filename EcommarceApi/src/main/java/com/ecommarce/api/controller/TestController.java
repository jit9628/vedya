package com.ecommarce.api.controller;

import java.beans.Transient;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecommarce.api.CheckAuthenticateUser;
import com.ecommarce.api.FileUploadHelper;
import com.ecommarce.api.dao.BookingProductDao;
import com.ecommarce.api.dao.CategoryDao;
import com.ecommarce.api.dao.ProductDao;
import com.ecommarce.api.dao.UserDao;
import com.ecommarce.api.dto.AddToCartDto;
import com.ecommarce.api.dto.AdderessDto;
import com.ecommarce.api.dto.CategoryDto;
import com.ecommarce.api.dto.OptionsGroupDto;
import com.ecommarce.api.dto.OrderDto;
import com.ecommarce.api.dto.ProductDto;
import com.ecommarce.api.dto.UserImageFileDto;
import com.ecommarce.api.entity.AddToCart;
import com.ecommarce.api.entity.Adderess;
import com.ecommarce.api.entity.Category;
import com.ecommarce.api.entity.EmailDetails;
import com.ecommarce.api.entity.OptionForGroups;
import com.ecommarce.api.entity.Order;
import com.ecommarce.api.entity.Product;
import com.ecommarce.api.entity.ProductOption;
import com.ecommarce.api.payload.OrderDetailsPayload;
import com.ecommarce.api.payload.OrderDetailsPojo;
import com.ecommarce.api.repo.ProductRepository;
import com.ecommarce.api.repo.UserRepository;
import com.ecommarce.api.request.ForgetPassword;
import com.ecommarce.api.response.JsonResponse;
import com.ecommarce.api.service.AddToCartService;
import com.ecommarce.api.service.AdderessService;
import com.ecommarce.api.service.BookingProductService;
import com.ecommarce.api.service.CategoryService;
import com.ecommarce.api.service.CityService;
import com.ecommarce.api.service.EmailService;
import com.ecommarce.api.service.OptionForGroupsService;
import com.ecommarce.api.service.OptionsGroupService;
import com.ecommarce.api.service.OrderService;
import com.ecommarce.api.service.ProductOptionService;
import com.ecommarce.api.service.ProductService;
import com.ecommarce.api.service.StateService;
import com.ecommarce.api.service.UserImageFileService;
import com.ecommarce.api.service.UserService;
import com.ecommarce.api.utility.GenericHandleData;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/test/")
@Slf4j
@CrossOrigin(origins = "*")
//@AllArgsConstructor
public class TestController {
	@Autowired
	private CheckAuthenticateUser checkAuthenticateUser;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserDao usrdao;
	@Autowired
	private EmailService emailService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private FileUploadHelper fuh;
	@Autowired
	private AdderessService adderessService;
	@Autowired
	private OptionsGroupService optionsGroupService;
	@Autowired
	private OptionForGroupsService optionForGroupsService;
	@Autowired
	private ProductOptionService productOptionService;
	@Autowired
	private AddToCartService addToCartService;
	@Autowired
	private StateService stateService;
	@Autowired
	private CityService cityService;
	@Autowired
	private UserImageFileService userImageFileService;
	@Autowired
	private BookingProductService bookingProductService;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private JsonResponse jsonResponse;
//	@Autowired
//	private CheckAuthenticateUser checkAuthenticateUser;
	@Autowired
	private CommonComponents commonComponents;
	@Autowired
	private ProductDao dao;
	@Autowired
	private CategoryDao catDao;
	@Autowired
	private OrderDetailsPayload payload;
	@Autowired
	private BookingProductDao bookingProductDao;

	@Autowired
	private UserService service;
@Autowired
	private UserRepository repository;
	
	/* ============================ CATEGORY PART==================== */
	/*------------------- ADD------------*/
	@PostMapping("add/category")
	public ModelAndView addCategory(@ModelAttribute("categoryDto") CategoryDto categoryDto,
			@RequestPart("file") MultipartFile file, HttpServletRequest request, ModelAndView mv) {

		String msg = "";
		try {
			//String chekRole = checkAuthenticateUser.chekRole();
			//String chekRole = (String)request.getAttribute("role");
			//System.out.println("Check Role Is ::"+chekRole);
			log.debug("multipart file is :" + file.getOriginalFilename());
			log.debug("category name   is :" + categoryDto.getCategoryname());
			if (categoryDto.getCategoryname().equals("") || categoryDto.getCategoryname() == null) {
				msg = " Category Field Can Not Be Blank : ";
				mv.addObject("msg", msg);
				mv.setViewName("redirect:/api/page/addCategory");
				return mv;
			}

			if (file.isEmpty()) {
				msg = " Select Image File  : ";
				mv.addObject("msg", msg);
				mv.setViewName("redirect:/api/page/addCategory");
				return mv;
			}

			fuh.doFileUpload(file, request);
			categoryDto.setFilecategory(file.getOriginalFilename());
			boolean addCategory = this.categoryService.addCategory(categoryDto);
			if (addCategory) {
				mv.setViewName("redirect:/api/test/category/list");
				return mv;
			}

			msg = "Category Is Existed";
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/addCategory");
			return mv;
		} catch (BindException e) {
			msg = "Category Can Not Be Blank Or Empty";
			mv.addObject("msg", msg);
			log.info("BindException Exception");
			mv.setViewName("redirect:/api/page/addCategory");
			return mv;
		} catch (BadRequest e) {
			msg = "Category Can Not Be Blank Or Empty";
			log.info("BadRequest Exception");
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/addCategory");
			return mv;
		} catch (MultipartException multipartException) {
			msg = " Please Select image";
			log.info("BadRequest Exception");
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/addCategory");
			return mv;
		} catch (Exception e) {
			msg = "Category Can Not Be Blank Or Empty";
			log.info("Root Exception" + e.getMessage());
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/addCategory");
			return mv;
		}

	}

	/*----------------------- CATEGORY UPDATE PAGE-----------------------------*/
	@RequestMapping("/categorypage/{catid}")
	public ModelAndView getCategoryUpdatePage(@PathVariable("catid") long catid, Category categoryy, ModelAndView mv,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Category category = this.categoryService.searchCategoryById(catid).get();

		mv.addObject("category", category);
		mv.setViewName("Admin/category-update");
		return mv;
	}

	@RequestMapping("/categoryupdate/{catid}")
	public ModelAndView getCategoryUpdate(@PathVariable("catid") long catid,
			@ModelAttribute("categoryDto") CategoryDto categoryDto, MultipartFile file, ModelAndView mv,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		String msg = "";
		try {

			if (file.isEmpty()) {

				String imageFileBasedOnCategory = catDao.getImageFileBasedOnCategory(catid);
				categoryDto.setFilecategory(imageFileBasedOnCategory);
				// categoryDto.setCategoryname(categoryDto.getCategoryname());

			}

			else {
				fuh.doFileUpload(file, httpServletRequest);
				categoryDto.setFilecategory(file.getOriginalFilename());
				// categoryDto.setCategoryname(categoryDto.getCategoryname());
			}

			boolean addCategory = this.categoryService.updateCategory(categoryDto, catid);
			if (addCategory) {
				mv.setViewName("redirect:/api/test/category/list");
				return mv;
			} else {
				mv.setViewName("redirect:/api/page/addCategory");
				return mv;
			}

		}

		catch (BindException e) {
			msg = "Category Can Not Be Blank Or Empty";
			mv.addObject("msg", msg);
			log.info("BindException Exception");
			mv.setViewName("redirect:/api/page/addCategory");
			return mv;
		} catch (BadRequest e) {
			msg = "Category Can Not Be Blank Or Empty";
			log.info("BadRequest Exception");
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/addCategory");
			return mv;
		} catch (MultipartException multipartException) {
			msg = " Please Select image";
			log.info("BadRequest Exception");
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/addCategory");
			return mv;
		} catch (Exception e) {
			msg = "Category Can Not Be Blank Or Empty";
			log.info("Root Exception" + e.getMessage());
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/addCategory");
			return mv;
		}

	}

	/*-------------------- LIST OF CATEGORY-----------------*/

	@GetMapping(value = "category/list")
	public ModelAndView getAllCategoryList(HttpServletRequest request, HttpServletResponse httpServletResponse,
			ModelAndView mv) {
		java.util.List<Category> allCategory = this.categoryService.getAllCategory();
		log.info("list of image is  :: " + allCategory);
		mv.addObject("allcategory", allCategory);
		mv.setViewName("Admin/All-Categories");
		return mv;
	}

	/*----------------- SEARCH CATEGORY BY ID--------------------*/

	@GetMapping("searchCategoryByid/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable("id") long id, HttpServletRequest request,
			HttpServletResponse httpServletResponse) {

		// call service category

		Optional<Category> searchCategoryById = this.categoryService.searchCategoryById(id);

		final Map<String, Object> body = new HashMap<>();
		if (searchCategoryById.empty() != null) {
			body.put("message", "Category Not Found ");
			return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);

			// return new ResponseEntity<>("Category Not Found ", HttpStatus.NO_CONTENT);
		}
		body.put("message", searchCategoryById);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	/*------------------- DELETE CATEGERY BY ID ----------------*/
	@GetMapping("categoryRemoveById/{catid}")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView categoryDelete(@PathVariable("catid") long catid, HttpServletRequest req,
			HttpServletResponse response, ModelAndView mv) {
		String msg = "";
		try {
			// delete category
			log.info("Press Delete Button .. ");
			String categoryRemove = this.categoryService.categoryRemove(catid);

			if (categoryRemove.equals("Category Deleted !!")) {
				mv.setViewName("redirect:/api/test/category/list");
				return mv;
			}
		} catch (DataIntegrityViolationException ex) {
			log.error("Data Integrity Exception:: " + ex.getMessage());
			mv.addObject("msg", "Can Not Delete catefory");
			mv.setViewName("redirect:/api/test/category/list");
			return mv;
		} catch (Exception ex) {
			ex.getMessage();
		}
		return mv;
	}
//,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.ALL_VALUE}
	// ,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE},produces =
	// {MediaType.ALL_VALUE}

	/* ================================ PRODUCT PART========================= */
	/*-------------------ADD PRODUCT------------------*/
	@PostMapping(value = "add/product")
//	@PreAuthorize(value = "hashRole('ROLE_ADMIN')")
	public ModelAndView addProduct(@Valid @ModelAttribute("productDto") ProductDto productDto, BindingResult result,
			HttpServletRequest request, @RequestPart("file") MultipartFile[] file, ModelAndView mv) {
		String msg = "";
		try {

			// check authentication
//			int checkAuthenticatedIsTrue = checkAuthenticateUser.checkAuthenticatedIsTrue();
//
//			if (checkAuthenticatedIsTrue == 0) {
//				mv.setViewName("redirect:/api/page/LogIn");
//			}

			log.info("files Details is :: " + file.length);
			// has any error occured
			if (result.hasErrors()) {

				log.info("Bind Exception :: " + result.getAllErrors());
				List<ObjectError> allErrors = result.getAllErrors();
				log.error("All Errors are :: " + allErrors);

				for (Object object : result.getAllErrors()) {
					if (object instanceof FieldError) {
						FieldError fieldError = (FieldError) object;
						log.error("Field Errors are :: " + fieldError.getDefaultMessage());
					}
				}
				msg = "please Fill All Fields";
				mv.addObject("msg", msg);
				mv.setViewName("redirect:/api/page/ProductPage");
				return mv;
			}
			String parameter = request.getParameter("M");
			String parameter1 = request.getParameter("L");
			String parameter2 = request.getParameter("XL");
			String parameter3 = request.getParameter("XXL");
			log.error("Parameter Value  are :: " + parameter);
			log.error("Parameter1 Value  are :: " + parameter1);
			log.error("Parameter2 Value  are :: " + parameter2);
			log.error("Parameter3 Value  are :: " + parameter3);
			boolean doFileUpload = false;
			ArrayList<String> fileNames = new ArrayList<>();
			for (MultipartFile element : file) {

				if (element.isEmpty()) {
					log.info("File Is Empty");
					msg = "please Choose Image  File ";
					mv.addObject("msg", msg);
					mv.setViewName("redirect:/api/page/ProductPage");
					return mv;
				}
				if (element.getSize() == 0) {
					log.info("File Size Is Less Than 1");
					mv.addObject("msg", msg);

					msg = "please Choose Image  File ";
					mv.setViewName("redirect:/api/page/ProductPage");
					return mv;
				}

				doFileUpload = fuh.doFileUpload(element, request);

			}
			boolean addProduct = false;
			if (doFileUpload) {
				for (MultipartFile multipartFile : file) {
					fileNames.add(multipartFile.getOriginalFilename());
				}
				productDto.setFiles(fileNames);

				TreeSet<String> setdata = new TreeSet<>();

				// check select size is true
				if (parameter == null && parameter1 == null && parameter2 == null && parameter3 == null
						|| parameter == "" && parameter1 == "" && parameter2 == "" && parameter3 == "") {

					msg = "please Choose Product Size";
					mv.addObject("msg", msg);
					mv.setViewName("redirect:/api/page/ProductPage");
					return mv;
				}

				if (parameter != "" && parameter != null) {
					setdata.add(parameter);
				}
				if (parameter1 != "" && parameter1 != null) {
					setdata.add(parameter1);
				}
				if (parameter2 != "" && parameter2 != null) {
					setdata.add(parameter2);
				}
				if (parameter3 != "" && parameter3 != null) {
					setdata.add(parameter3);
				}
				productDto.setProductsize(setdata);
				addProduct = this.productService.addProduct(productDto);
				if (!addProduct) {
					msg = "please Fill All Fields";
					mv.addObject("msg", msg);
					mv.setViewName("redirect:/api/page/ProductPage");
					return mv;
				}
				mv.addObject("productdata", productDto);
				mv.setViewName("redirect:/api/page/All-Product");
				return mv;
			}
		} catch (BadRequest badRequest) {

			msg = "please Fill All Fields";
			mv.addObject("productdata", productDto);
			mv.addObject("msg", msg);
			log.info("Bad Request  Exception :: " + badRequest.getMessage());
			// mv.setViewName("Admin/Add-Product");
			mv.setViewName("redirect:/api/page/ProductPage");
			return mv;
		} catch (org.springframework.boot.context.properties.bind.BindException bind) {

			log.info("Bind Exception :: " + bind.getName());
			mv.addObject("productdata", productDto);
			msg = "please Fill All Fields";
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/ProductPage");
			return mv;

		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("productdata", productDto);
			msg = "please Fill All Fields";
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/api/page/ProductPage");
			return mv;
		}
		return mv;
	}

	/*--------------------- LIST OF PRODUCTS -----------------*/
	@GetMapping("GetAllProducts")
	public ResponseEntity<?> allProducts(ModelAndView mv) {
		Map<String, Object> body = new HashMap<>();
		try {

//			SecurityContext context = securityContextHolderStrategy.getContext();
//			log.error("Authentication Instance is ::{}", context.getAuthentication());
//			Authentication authentication = context.getAuthentication();
//				// Principal principal = (Principal)securityContextHolderStrategy.getContext().getAuthentication();
//				//log.error("Authentication Instance is ::{}", principal.);
//				if (authentication instanceof AnonymousAuthenticationToken) {
//					log.info("start testing");
//					mv.setViewName("redirect:/api/page/LogIn");
//					return mv;
//				}

			List<Product> allProduct = this.productService.getAllProduct();
			log.info("list Data is " + allProduct);
			ResponseEntity<?> response = this.jsonResponse.getResponse("200", "success", allProduct);
			log.info("Response Entity is :: " + response);
			body.put("status", "200");
			body.put("message", allProduct);
			return new ResponseEntity<>(body, HttpStatus.OK);

			// return new ResponseEntity<>(Map.of("message", allProduct), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		body.put("status", "402");
		body.put("message", "Not Available");
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("status", "402", "message", "Not
		// Available"), HttpStatus.OK);
	}

	/*
	 * ============================= FIND PRODUCT BY CATEGORY NAME
	 * =============================
	 */

	/*---------------- GET PRODUCTS BY CATEGORY ID ----------------------*/
	@GetMapping("productByCategory/{catid}")
	public ResponseEntity<?> findProductByCategory(@PathVariable(value = "catid") long catid) {
		Map<String, Object> body = new HashMap<>();
		Optional<Category> productByCategory = this.categoryService.searchCategoryById(catid);
		body.put("status", "200");
		body.put("data", productByCategory);
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("data", productByCategory),
		// HttpStatus.OK);
	}

	/*------------------ DELETE PRODUCTS------------------ */

	@GetMapping("/product/{pid}")
	public ModelAndView deleteProduct(@PathVariable("pid") int pid, ModelAndView mv) {
		try {
			// org.springframework.security.core.context.SecurityContext context =
			// securityContextHolderStrategy.getContext();
			// log.error("Authentication Instance is ::{}", context.getAuthentication());
			// Authentication authentication = context.getAuthentication();
			// if (authentication instanceof AnonymousAuthenticationToken) {
//				log.info("start testing");
//				mv.setViewName("redirect:/api/page/LogIn");
//				return mv;
//			}

			// check authentication
//			int checkAuthenticatedIsTrue = checkAuthenticateUser.checkAuthenticatedIsTrue();
//
//			if (checkAuthenticatedIsTrue == 0) {
//				mv.setViewName("redirect:/api/page/LogIn");
//			}

			log.info(" Hit deleted products Url ");
			boolean removeProductFromCart = this.addToCartService.removeProductFromCart(pid);
			if (removeProductFromCart) {
				boolean deleteProduct = this.productService.deleteProduct(pid);
			}
			boolean deleteProduct = this.productService.deleteProduct(pid);
			if (deleteProduct) {
//				mv.setViewName("Admin/All-Products");
				mv.setViewName("redirect:/api/page/All-Product");
				return mv;
			} else {
				// log.info(" can not be deleted products ");
				return mv;
			}

			// return new ResponseEntity<>(Map.of("message", "Product Deleted"),
			// HttpStatus.OK);shoping-cart
		}

		catch (DataIntegrityViolationException dataIntegrityViolationException) {
			mv.addObject("message", "Can Not Delete this Product");
			mv.setViewName("redirect:/api/page/All-Product");
			return mv;
		}

		catch (Exception e) {
			// return new ResponseEntity<>(Map.of("message", e.getMessage()),
			// HttpStatus.OK);
			return mv;
		}
	}

	/*------------ SEARCH PRODUCTS BY NAME------------------*/

	@GetMapping("productByName/{productname}")
	public ResponseEntity<?> getProductByName(@PathVariable("productname") String productname) {
		Map<String, Object> body = new HashMap<>();
		log.info(productname);

		Product findProductByName = this.productService.findProductByName(productname);

		log.info("list of product is" + findProductByName);
		body.put("status", "200");
		body.put("message", findProductByName);
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("message", findProductByName),
		// HttpStatus.OK);
	}

	/*------------------- UPDATE PRODUCTS --------------------*/
	@GetMapping("/update-product/{pid}")
	public ModelAndView updateProductPage(@PathVariable("pid") int pid, Product product, ModelAndView mv) {
		Optional<Product> findProductByCategoryId = Optional.ofNullable(this.productService.findProductById(pid).get());
		if (findProductByCategoryId.isPresent()) {
			product = findProductByCategoryId.get();
			String files = product.getFiles();
			log.warn("product file name is :: " + files);
			String string = files.toString();
			String substring = string.substring(1, string.length() - 1);
			String[] split = substring.split(",");
			String d = "";
			for (String s : split) {
				d += s + " ,";
			}
			mv.addObject("files", d);
			mv.addObject("productdata", product);
			List<Category> allCategory = categoryService.getAllCategory(); // category
			// check file is empty
			mv.addObject("categorydatavalue", allCategory);
			TreeSet<String> productsize = product.getProductsize();
			int size = productsize.size();
			List<String> productsizelist;
			for (String listofproductsize : productsize) {
				productsize.add(listofproductsize);
			}
			log.info("product size list is : " + productsize);

			mv.addObject("product", productsize);

			mv.setViewName("Admin/update-product");
		}
		log.info("Product Details is " + product.getFiles() + " Discription  " + product.getDiscription()
				+ "   product Id :: " + product.getPid());
		return mv;
	}

	/* ======================= UPDATE PRODUCT======================== */
	@PostMapping(value = "ProductUpdate")
	public ModelAndView updateProduct(@ModelAttribute("productdata") ProductDto productDto, HttpServletRequest request,
			@RequestPart("file") MultipartFile[] file, ModelAndView mv) {
		boolean updateProduct = false;
		try {
			ArrayList<String> fileNames = new ArrayList<>();
			ArrayList<String> productImage = new ArrayList<>();

			log.info("Your Files Value Is ::  " + file);

			for (MultipartFile files : file) {

				// if file is not empty
				fuh.doFileUpload(files, request);
				/*
				 * if(files.isEmpty()|| files.getSize()==0) {
				 * log.debug("multipart files without selection  is :" +
				 * files.getOriginalFilename()); }
				 */

//				if it is true means its site equal 0 and empty 
				if (files.getSize() == 0 || files.isEmpty()) {

					// fuh.doFileUpload(files, request);
					log.info("Updated Images -------- :)");
					productImage = dao.getProductImage(productDto.getPid());
					productDto.setFiles(productImage);
					log.info("file name is :: " + productDto.getFiles());
					// updateProduct = this.productService.updateProduct(productDto,
					// productDto.getPid());
				} else {
					log.debug("multipart file is :" + files.getOriginalFilename());
					fileNames.add(files.getOriginalFilename());
					if (!fileNames.isEmpty()) {

						// if file name is not empty empty
						log.info("file name is :: " + productDto.getFiles());
						productDto.setFiles(fileNames);
						log.info("set file in dto class");

					}

				}

//				log.debug("multipart file is :" + files.getOriginalFilename());
//				fileNames.add(files.getOriginalFilename());
			}
//			check file is empty
			// if (!fileNames.isEmpty()) {

			// if file name is not empty empty
			// log.info("file name is :: " + productDto.getFiles());
			// productDto.setFiles(fileNames);
			// log.info("set file in dto class");
			// }

			// productDto.setFiles(fileNames);
			// log.info("set file in dto class");

			// log.info("hit Update Controller .... ");

//			 updateProduct = this.productService.updateProduct(productDto, productDto.getPid());
//			if (updateProduct) {
//				mv.addObject("status", updateProduct);
//				List<Category> allCategory = categoryService.getAllCategory();
//				// check file is empty
//				mv.addObject("categorydatavalue", allCategory);
//				mv.setViewName("Admin/update-product");
//				return mv;
//			}
//			List<Category> allCategory = categoryService.getAllCategory();
//			mv.addObject("categorydatavalue", allCategory);
//			mv.setViewName("Admin/update-product");

			updateProduct = this.productService.updateProduct(productDto, productDto.getPid());
			if (updateProduct) {
				mv.addObject("status", updateProduct);
				List<Category> allCategory = categoryService.getAllCategory();
				// check file is empty
				mv.addObject("categorydatavalue", allCategory);
				mv.setViewName("Admin/update-product");
				return mv;
			}
			List<Category> allCategory = categoryService.getAllCategory();
			mv.addObject("categorydatavalue", allCategory);
			mv.setViewName("Admin/update-product");

			return mv;
		} catch (BadRequest badRequest) {
			mv.addObject("msg", "error");
			log.info("Bad Request  Exception :: " + badRequest.getMessage());
			List<Category> allCategory = categoryService.getAllCategory();
			mv.addObject("categorydatavalue", allCategory);
			mv.setViewName("Admin/update-product");
			return mv;
		}

		catch (org.springframework.boot.context.properties.bind.BindException bind) {

			log.info("Bind Exception :: " + bind.getName());
			mv.addObject("msg", "error");
			mv.setViewName("Admin/Add-Product");
			return mv;
			// TODO: handle exception
		} catch (Exception e) {

			log.error("Error Value is " + e.getMessage().toUpperCase());
			mv.setViewName("Admin/All-Product");
			return mv;

		}

	}

	/*
	 * ======================================== USER ADDERESS END
	 * POINTS==================================
	 */

	@PostMapping("adderess")
	public ResponseEntity<?> addAdderess(@RequestBody AdderessDto adderessDto, HttpServletRequest request) {
		try {
			request.getSession().getAttribute("userid");
			if (request.getSession().getAttribute("userid") != null) {
				log.info("value is not null");
			} else {
				log.info("value is  null");
			}
			long userid = (long) request.getSession().getAttribute("userid");

			this.adderessService.addAdderess(adderessDto);

			Map<String, Object> body = new HashMap();

			body.put("message", "added Adderess");

			return new ResponseEntity<>(body, HttpStatus.OK);

			// return new ResponseEntity<>(Map.of("message", "added Adderess"),
			// HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/getAdderessDetails/{id}")
	public ResponseEntity<?> getAdderessDetails(@PathVariable("id") int id) {
		Map<String, Object> body = new HashMap<>();
		try {

			Optional<Adderess> findAdderessDetailsById = this.adderessService.findAdderessDetailsById(id);

			body.put("status", "200");
			body.put("message", findAdderessDetailsById);
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(Map.of("message", findAdderessDetailsById),
			// HttpStatus.OK);

		} catch (Exception e) {
			body.put("status", "501");
			body.put("message", e.getMessage());
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
			// return new ResponseEntity<>(Map.of("exception", e.getMessage()),
			// HttpStatus.EXPECTATION_FAILED);

		}
	}

	/* ======================== ORDER END POINTS {PALCED ORDR}============== */

	@PostMapping("placed")
	public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
		Map<String, Object> body = new HashMap<>();
		try {
			boolean createOrder = this.orderService.createOrder(orderDto);
			if (!createOrder) {
				body.put("status", "202");
				body.put("message", "your Order can not replace some server side error  ::");
				return new ResponseEntity<>(body, HttpStatus.OK);

			}
//				return new ResponseEntity<>(
//						Map.of("status", "202", "message", "your Order can not replace some server side error  ::"),
//						HttpStatus.OK);
		} catch (Exception e) {

			e.getMessage();

		}
		body.put("status", "202");
		body.put("message", "your order is places ::");
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("status", "200", "message", "your order is
		// places ::"), HttpStatus.OK);
	}

	/* ----------------- Get All Order----------------- */
	@GetMapping("getAllOrder")
	public ResponseEntity<?> getAllOrder() {
		Map<String, Object> body = new HashMap<>();
		try {
			List<Order> allOrder = this.orderService.getAllOrder();
			if (allOrder.isEmpty()) {
				body.put("status", "202");
				body.put("message", "No Order   ::");
				return new ResponseEntity<>(body, HttpStatus.OK);

			} else {

				body.put("status", "200");
				body.put("data", allOrder);
				return new ResponseEntity<>(body, HttpStatus.OK);

			}
//				return new ResponseEntity<>(Map.of("status", "202", "message", "No Order   ::"), HttpStatus.OK);
//			return new ResponseEntity<>(Map.of("status", "200", "data", allOrder), HttpStatus.OK);
		} catch (Exception e) {

			e.getMessage();

		}
		body.put("status", "200");
		body.put("data", "Internal Server Error");
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("status", "200", "data", "Internal Server
		// Error "), HttpStatus.OK);
	}

	/* ========================== SENDING EMAIL LINKS=================== */
	@PostMapping("sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailDetails emailDetails) {
		Map<String, Object> body = new HashMap<>();
		log.info("msg body " + emailDetails.getMsgBody() + "receipt  ::" + emailDetails.getRecipient() + "subject  ::"
				+ emailDetails.getSubject());
		try {
			log.debug("debug start");

			String sendSimpleMail = emailService.sendSimpleMail(emailDetails);
			log.info("rturn value is  " + sendSimpleMail);
			body.put("status", "200");
			body.put("data", sendSimpleMail);
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(Map.of("status", "200", "data", sendSimpleMail),
			// HttpStatus.OK);
		} catch (Exception e) {
			e.getMessage();
			body.put("status", "200");
			body.put("data", "can not send email");
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
//			return new ResponseEntity<>(Map.of("status", "500", "data", "can not send email"),
//					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/* ======================= options groupend points ================= */
	@PostMapping("addOptionGroups")
	public ResponseEntity<?> addOptionGroups(@RequestBody OptionsGroupDto optionGroupDto) {
		Map<String, Object> body = new HashMap<>();
		try {

			this.optionsGroupService.addOptionGroups(optionGroupDto);

			body.put("status", "200");
			body.put("message", "added Options Based On Groups :: ");
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(Map.of("message", "added Options Based On Groups
			// :: "), HttpStatus.OK);
		} catch (Exception e) {
			// return new ResponseEntity<>(Map.of("exception", e.getMessage()),
			// HttpStatus.OK);
		}
		return null;
	}

//	@PostMapping("addGroupsInOption")
//	public ResponseEntity<?> addGroupsInOption(@RequestBody OptionForGroupsDto optionForGroupsDto) {
//		try {
//
//			this.optionForGroupsService.addGroupOption(optionForGroupsDto);
//
//			return new ResponseEntity<>(Map.of("message", "added"), HttpStatus.OK);
//
//		} catch (Exception e) {
//			return new ResponseEntity<>(Map.of("exception", e.getMessage()), HttpStatus.OK);
//
//		}
//
//	}

	/* find optins by group name */

//	@GetMapping("FindAllOptions")
//	public ResponseEntity<?> findoptionsByGroupId() {
//		try {
//			List<OptionForGroups> findAllOptionsGroup = this.optionForGroupsService.findAllOptionsGroup();
//			return new ResponseEntity<>(Map.of("message", findAllOptionsGroup), HttpStatus.OK);
//
//		} catch (Exception e) {
//			return new ResponseEntity<>(Map.of("exception", e.getMessage()), HttpStatus.OK);
//
//		}
//
//	}
//
//	@GetMapping("findGroupById/{id}")
//	public ResponseEntity<?> findAllGroups(@PathVariable("id") int id) {
//		try {
//			Optional<OptionsGroup> findByGroupId = this.optionsGroupService.findByGroupId(id);
//			return new ResponseEntity<>(Map.of("message", findByGroupId.get()), HttpStatus.OK);
//
//		} catch (Exception e) {
//			return new ResponseEntity<>(Map.of("exception", e.getMessage()), HttpStatus.OK);
//
//		}
//
//	}

	/* ================== ADD PRODUCT MORE DETAILS ============================== */

//	@PostMapping("addMoreProductDetail")
//	public ResponseEntity<?> addMoreProductDetail(
//			@ModelAttribute("productOptionDto") ProductOptionDto productOptionDto) {
//		try {
//
////			  if(!file.isEmpty()) {
////				log.info("file name is :: "+file.getName());
////			  }
//
//			boolean addMoreProductDetails = this.productOptionService.addMoreProductDetails(productOptionDto);
//
//			if (addMoreProductDetails)
//				return new ResponseEntity<>(Map.of("message", "Your Product Details Saved"), HttpStatus.OK);
//			else
//				return new ResponseEntity<>(Map.of("message", "Detailse not saved "), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(Map.of("exception", e.getMessage()), HttpStatus.OK);
//
//		}
//
//	}

	@GetMapping("findProductPropertyDetails/{id}")
	public ResponseEntity<?> findProductPropertyDetailsById(@PathVariable("id") long id) {
		Map<String, Object> body = new HashMap<>();
		try {
			Optional<ProductOption> findProductDetailsById = this.productOptionService.findProductDetailsById(id);

			body.put("status", "200");
			body.put("message", findProductDetailsById.get());
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(Map.of("message", findProductDetailsById.get()),
			// HttpStatus.OK);

		} catch (Exception e) {
			body.put("status", "200");
			body.put("message", e.getMessage());
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(Map.of("exception", e.getMessage()),
			// HttpStatus.OK);

		}

	}

//	get groupoption name
	@GetMapping("findGroupOptionNameByGroupId/{id}")
	@Transient
	public ResponseEntity<?> findGroupOptionNameByGroupId(@PathVariable("id") int id) {
		Map<String, Object> body = new HashMap<>();
		try {
			OptionForGroups findgroupnameByGroupId = this.optionForGroupsService.findgroupnameByGroupId();
			body.put("status", "200");
			body.put("message", findgroupnameByGroupId);
			return new ResponseEntity<>(body, HttpStatus.OK);

			// return new ResponseEntity<>(Map.of("message", findgroupnameByGroupId),
			// HttpStatus.OK);

		} catch (Exception e) {
			body.put("status", "200");
			body.put("message", e.getMessage());
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(Map.of("exception", e.getMessage()),
			// HttpStatus.OK);

		}

	}

	// get all option based on group
	@GetMapping("getProductByCategorId/{id}")
	public ResponseEntity<?> getAllOptionFromGroupId(@PathVariable("id") long id) {
		Map<String, Object> body = new HashMap<>();
		try {
			// List<OptionForGroups> allOptionFromGroupId =
			// this.optionForGroupsService.getAllOptionFromGroupId(id);
			List<Product> allOptionFromGroupId = this.productService.findProductByCategorId(id);
			body.put("status", "200");
			body.put("message", allOptionFromGroupId);
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(Map.of("message", allOptionFromGroupId),
			// HttpStatus.OK);
		} catch (NullPointerException ex) {
			body.put("status", "200");
			body.put("message", "Product Not Available that Category");
			return new ResponseEntity<>(body, HttpStatus.OK);
//			return new ResponseEntity<>(Map.of("message", "Product Not Available that Category"),
//					HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			body.put("status", "500");
			body.put("message", ex.getLocalizedMessage());
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
			// return new ResponseEntity<>(Map.of("message", ex.getLocalizedMessage()),
			// HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	=========================================== ADD TO CART ====================================
	@GetMapping("addtocartproduct")
//	@ResponseBody
	public ModelAndView addProductInCart(@RequestParam("products") int products, @RequestParam("size") String size,
			@RequestParam("orderimage") String orderimage, HttpServletRequest request, HttpSession s, ModelAndView mv) {
		try {
			log.info(" Session value is :: " + request.getAttribute("userid"));
			log.info("Session ::" + request.getSession().getAttribute("userid"));
			HttpSession session = request.getSession();
			session.getServletContext().getAttribute("userid");
			log.info("context object ::" + session.getServletContext().getAttribute("userid"));
			if (request.getSession().getAttribute("userid") != null
					&& request.getSession().getAttribute("userid") != "") {

				Long attribute = (Long) request.getSession().getAttribute("userid");
				int countAddToCartProductBasedOnUser = this.addToCartService.countAddToCartProductBasedOnUser(attribute);
//List<CategoryDto> allCategories = commonComponents.getAllCategories();
				log.info("user id is" + attribute);
				AddToCartDto addToCart = new AddToCartDto();
				addToCart.setProducts(products);
				addToCart.setUsersid(attribute);
				addToCart.setColor("blue");
				addToCart.setSize(size);
				addToCart.setSize(orderimage);
				int addProductToCart = this.addToCartService.addProductToCart(addToCart);
				if (addProductToCart == 1) {
					// mv.setViewName("redirect:");
					mv.setViewName("redirect:/api/test/shoping-cart");
				}
				// return new ResponseEntity<>(Map.of("message", "Product is Add To Cart"),
				// HttpStatus.OK);
				if (addProductToCart == -1) {
					mv.setViewName("redirect:/api/page/LogIn");
					return mv;
				}
				// return new ResponseEntity<>(Map.of("message", "Something Went Wrong "),
				// HttpStatus.OK);
			} else {
				// return new ResponseEntity<>(Map.of("message", "Please Logged In First Than
				// Product Add To Cart .. "),HttpStatus.OK);
				mv.setViewName("redirect:/api/page/LogIn");
				return mv;
			}
		} catch (NullPointerException ex) {
			// return new ResponseEntity<>(Map.of("message", "Product Not Available that
			// Category"),HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			mv.setViewName("redirect:/api/page/LogIn");
			return mv;
			// return new ResponseEntity<>(Map.of("message", ex.getLocalizedMessage()),
			// HttpStatus.BAD_REQUEST);
		}
		return mv;
	}

	@GetMapping("getProductFromCart")
	public ResponseEntity<?> getProductFromCart(@RequestBody AddToCartDto addToCart) {
		Map<String, Object> body = new HashMap<>();
		try {

			List<AddToCart> getpProductFromCart = this.addToCartService.getpProductFromCart();
			if (getpProductFromCart.isEmpty() && getpProductFromCart != null) {
				body.put("message", "Product is Add To Cart");
				return new ResponseEntity<>(body, HttpStatus.OK);
				// return new ResponseEntity<>(Map.of("message", "Product is Add To Cart"),
				// HttpStatus.OK);
			} else {
				body.put("message", getpProductFromCart);
				return new ResponseEntity<>(body, HttpStatus.OK);
				// return new ResponseEntity<>(Map.of("message", getpProductFromCart),
				// HttpStatus.OK);
			}

		} catch (NullPointerException ex) {
			body.put("message", "Product Not Available in Cart");
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(Map.of("message", "Product Not Available in
			// Cart"), HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			body.put("message", ex.getLocalizedMessage());
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
			// return new ResponseEntity<>(Map.of("message", ex.getLocalizedMessage()),
			// HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@GetMapping("remodeproductfromcart/{id}")
//	public ModelAndView removecart( @PathVariable("id") int id, HttpServletRequest request ,ModelAndView mv){
//		long userid = (long)request.getSession().getAttribute("userid");
//		this.addToCartService.removecartproduct(id,userid);
//		mv.setViewName("shoping-cart");
//		return  mv;
//	}

	@GetMapping("remodeproductfromcart/{id}")
	public ResponseEntity<?> removecart(@PathVariable("id") int id, HttpServletRequest request) {
		Map<String, Object> body = new HashMap<>();
		long userid = (long) request.getSession().getAttribute("userid");
		log.info("remove product from cart" + userid);
		this.addToCartService.removecartproduct(id, userid);
		body.put("message", "Product Removed From Cart");
		body.put("status", "200");
		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	/*
	 * ============================ SHOPING CART END POINTS START==================
	 */

	@GetMapping("shoping-cart")

	public ModelAndView getShopingCart(ModelAndView mv, HttpServletRequest request, HttpServletResponse response,
			HttpSession s) {
		/* ALL PRODUCT BASED ON USERID */
		/*
		 * try {
		 * 
		 * long id = (long) request.getSession().getAttribute("userid"); int
		 * totaladdtocartvalue = 0; List<AddToCart> findCartDetailBasedOnUserId = null;
		 * log.info("Session id is ::" + id); findCartDetailBasedOnUserId =
		 * this.addToCartService.findCartDetailBasedOnUserId(id); List<ProductDto>
		 * productList = new ArrayList<>(); String files = ""; String filename = "";
		 * long totalprice = 0; long tax = 0; long subtotal = 0; if
		 * (!findCartDetailBasedOnUserId.isEmpty() && findCartDetailBasedOnUserId !=
		 * null) { for (int i = 0; i < findCartDetailBasedOnUserId.size(); i++) {
		 * ProductDto dto = new ProductDto();
		 * dto.setPid(findCartDetailBasedOnUserId.get(i).getProducts().getPid());
		 * dto.setProductname(findCartDetailBasedOnUserId.get(i).getProducts().
		 * getProductname()); totalprice +=
		 * findCartDetailBasedOnUserId.get(i).getProducts().getPrice(); tax +=
		 * totalprice * 12 / 100;// getting tax value
		 * dto.setPrice(findCartDetailBasedOnUserId.get(i).getProducts().getPrice());
		 * dto.setStocks(findCartDetailBasedOnUserId.get(i).getProducts().getStocks());
		 * dto.setSku(findCartDetailBasedOnUserId.get(i).getProducts().getSku());
		 * dto.setSizes(findCartDetailBasedOnUserId.get(i).getSize());
		 * 
		 * files = findCartDetailBasedOnUserId.get(i).getProducts().getFiles(); String
		 * filesName = files.substring(1, files.length() - 1);
		 * dto.setFilesretrieve(filesName.split(",")); productList.add(dto);
		 * log.info("Proccess end period => " + i); } // List<AddToCart> list =
		 * findCartDetailBasedOnUserId.stream().filter(x -> // x.getSize() !=
		 * null).toList(); mv.addObject("productList", productList);// add product
		 * object in model mv.addObject("total", totalprice); tax += (12 / 100) *
		 * totalprice; mv.addObject("Tax" + tax); log.info("Tax Rate Value Is", tax =
		 * (12 / 100) * totalprice); subtotal += totalprice + tax;
		 * mv.addObject("subtotal", subtotal); log.info("total Rate Value Is",
		 * subtotal); // log.info("total price is ::" + subtotal);
		 * 
		 * log.info("Tax Rate Value Is" + tax); //
		 * mv.addObject("countAddToCartProductBasedOnUser", //
		 * countAddToCartProductBasedOnUser); mv.setViewName("shoping-cart"); return mv;
		 * } return mv; } catch (NullPointerException ex) {
		 * mv.setViewName("shoping-cart"); return mv; }
		 */
		mv.setViewName("shoping-cart");
		return mv;

	}

	// get product from cart

	@GetMapping("jitu")
	public ResponseEntity<?> getProductFromShopingCart() {

		// long id = (long) request.getSession().getAttribute("userid");
		int totaladdtocartvalue = 0;
		List<AddToCart> findCartDetailBasedOnUserId = null;
		// log.info("Session id is ::" + id);
		findCartDetailBasedOnUserId = this.addToCartService.findCartDetailBasedOnUserId(2);
		// int countAddToCartProductBasedOnUser =
		// this.addToCartService.countAddToCartProductBasedOnUser(id);
		// log.info("total number of product specific user add to cart
		// countAddToCartProductBasedOnUser ::"+countAddToCartProductBasedOnUser);
		// log.info("Add Cart Product Details is::"+findCartDetailBasedOnUserId);
		List<ProductDto> productList = new ArrayList<>();
		String files = "";
		String filename = "";
		long totalprice = 0;
		long tax = 0;
		long subtotal = 0;

		if (!findCartDetailBasedOnUserId.isEmpty() && findCartDetailBasedOnUserId != null) {
			for (int i = 0; i < findCartDetailBasedOnUserId.size(); i++) {
				ProductDto dto = new ProductDto();
				dto.setPid(findCartDetailBasedOnUserId.get(i).getProducts().getPid());
				dto.setProductname(findCartDetailBasedOnUserId.get(i).getProducts().getProductname());
				totalprice += findCartDetailBasedOnUserId.get(i).getProducts().getPrice();
				tax += totalprice * 12 / 100;// getting tax value
				dto.setPrice(findCartDetailBasedOnUserId.get(i).getProducts().getPrice());
				dto.setStocks(findCartDetailBasedOnUserId.get(i).getProducts().getStocks());
				dto.setSku(findCartDetailBasedOnUserId.get(i).getProducts().getSku());
				dto.setSizes(findCartDetailBasedOnUserId.get(i).getSize());

				files = findCartDetailBasedOnUserId.get(i).getProducts().getFiles();
				String filesName = files.substring(1, files.length() - 1);
				dto.setFilesretrieve(filesName.split(","));
				productList.add(dto);
				log.info("Proccess end period => " + i);
			}
		}
		Map<String, Object> body = new HashMap<>();
		body.put("product", productList);
		body.put("total", totalprice);
		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@GetMapping("check-out")
	public ModelAndView getcheckoutpage(ModelAndView mv, HttpServletRequest request, HttpServletResponse response,
			HttpSession s) {
		try {
			long id = (long) request.getSession().getAttribute("userid");
			int totaladdtocartvalue = 0;
			List<AddToCart> findCartDetailBasedOnUserId = null;
			log.info("Session id is ::" + id);
			findCartDetailBasedOnUserId = this.addToCartService.findCartDetailBasedOnUserId(id);
			// int countAddToCartProductBasedOnUser =
			int countAddToCartProductBasedOnUser = this.addToCartService.countAddToCartProductBasedOnUser(id);
			// log.info("total number of product specific user add to cart
			// countAddToCartProductBasedOnUser ::"+countAddToCartProductBasedOnUser);
			// log.info("Add Cart Product Details is::"+findCartDetailBasedOnUserId);
			List<ProductDto> productList = new ArrayList<>();
			String files = "";
			String filename = "";
			long totalprice = 0;
			long tax = 0;
			long subtotal = 0;

			if (!findCartDetailBasedOnUserId.isEmpty() && findCartDetailBasedOnUserId != null) {
				for (int i = 0; i < findCartDetailBasedOnUserId.size(); i++) {
					ProductDto dto = new ProductDto();
					dto.setPid(findCartDetailBasedOnUserId.get(i).getProducts().getPid());
					dto.setProductname(findCartDetailBasedOnUserId.get(i).getProducts().getProductname());
					totalprice += findCartDetailBasedOnUserId.get(i).getProducts().getPrice();
					tax += totalprice * 12 / 100;// getting tax value
					dto.setPrice(findCartDetailBasedOnUserId.get(i).getProducts().getPrice());
					dto.setStocks(findCartDetailBasedOnUserId.get(i).getProducts().getStocks());
					dto.setSku(findCartDetailBasedOnUserId.get(i).getProducts().getSku());
					dto.setSizes(findCartDetailBasedOnUserId.get(i).getSize());

					files = findCartDetailBasedOnUserId.get(i).getProducts().getFiles();
					String filesName = files.substring(1, files.length() - 1);
					dto.setFilesretrieve(filesName.split(","));
					productList.add(dto);
					log.info("Proccess end period => " + i);
				}

				// List<AddToCart> list = findCartDetailBasedOnUserId.stream().filter(x ->
				// x.getSize() != null).toList();
				mv.addObject("productList", productList);
				mv.addObject("total", totalprice);
				tax += (12 / 100) * totalprice;
				mv.addObject("Tax" + tax);
				log.info("Tax Rate Value Is", tax = (12 / 100) * totalprice);
				subtotal += totalprice + tax;
				mv.addObject("subtotal", subtotal);
				log.info("total Rate Value Is", subtotal);
				//
				log.info("total price is ::" + subtotal);

				log.info("Tax Rate Value Is" + tax);
				mv.addObject("countAddToCartProductBasedOnUser", countAddToCartProductBasedOnUser);
				mv.setViewName("check-out");
				return mv;
			}
			return mv;
		} catch (NullPointerException ex) {
			mv.setViewName("shoping-cart");
			return mv;
		}

	}

	/* ============== get card details ====================== */

	@GetMapping("getCartDetailsBasedonUsser")
	public ResponseEntity<?> getCartDetailsBasedonUsser(HttpServletRequest request) {
		Map<String, Object> body = new HashMap<>();
		long usrid = (long) request.getSession().getAttribute("userid");
		List<AddToCart> categoryDetildFromUser = this.addToCartService.getCategoryDetildFromUser(usrid);
		List<AddToCartDto> AddToCartDtos = new ArrayList<>();
		for (AddToCart cart : categoryDetildFromUser) {
			AddToCartDto carts = new AddToCartDto();
			carts.setProducts(cart.getProducts().getPid());
			carts.setUsersid(cart.getUsers().getId());
			carts.setColor(cart.getColor());
			carts.setSize(cart.getSize());
			AddToCartDtos.add(carts);
		}
		body.put("status", "200");
		body.put("message", AddToCartDtos);
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("status", "200", "message",
		// AddToCartDtos), HttpStatus.OK);
	}

	/* ========================== get ip adderess ====================== */

//	@GetMapping("getipadderess")
//	public ResponseEntity<?> getIpAdderess(HttpServletRequest request) throws SocketException, UnknownHostException {
//		InetAddress localHost = InetAddress.getLocalHost();
//
//		NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
//		byte[] hardwareAddress = ni.getHardwareAddress();
//
//		String[] hexadecimal = new String[hardwareAddress.length];
//		for (int i = 0; i < hardwareAddress.length; i++) {
//			hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
//		}
//		String macAddress = String.join("-", hexadecimal);
//		return new ResponseEntity<>(Map.of("mac Adderess ", macAddress, "status", "200", "localhost", localHost),
//				HttpStatus.OK);
//	}

//	@PostMapping("createstate")
//	public ResponseEntity<?> addStates(@RequestBody StateDto stateDto) {
//
//		boolean addState = this.stateService.addState(stateDto);
//		if (addState)
//			return new ResponseEntity<>(Map.of("message ", "State created ", "status", "200"), HttpStatus.OK);
//		else
//			return new ResponseEntity<>(Map.of("message ", "can not add state", "status", "200"), HttpStatus.OK);
//	}

	/* ========== manage state country amd postal code =========== */

//	@GetMapping("findallstate")
//	public ResponseEntity<?> findStateAll() {
//
//		List<State> allstates = this.stateService.retrieveAllState();
//		if (!allstates.isEmpty())
//			return new ResponseEntity<>(Map.of("message ", allstates, "status", "200"), HttpStatus.OK);
//		else
//			return new ResponseEntity<>(Map.of("message ", "Not Present Any State", "status", "200"),
//					HttpStatus.NO_CONTENT);
//	}

//	@PostMapping("createcity")
//	public ResponseEntity<?> addCity(@RequestBody CityDto cityDto) {
//
//		if (cityDto.getCityname() == null || cityDto.getCityname() == "") {
//			return new ResponseEntity<>(Map.of("message ", "please Fill city name ", "status", "200"), HttpStatus.OK);
//		}
//
//		boolean addState = this.cityService.addCity(cityDto);
//		if (addState)
//			return new ResponseEntity<>(Map.of("message ", "State created ", "status", "200"), HttpStatus.OK);
//		else
//			return new ResponseEntity<>(Map.of("message ", "can not add state", "status", "204"), HttpStatus.OK);
//	}

//	@GetMapping("findcity/{stateids}")
//	public ResponseEntity<?> findStateAll(@PathVariable("stateids") int stateids) {
//
//		List<City> findCityByState = this.cityService.findCityByState(stateids);
//
//		return (!findCityByState.isEmpty() && findCityByState != null)
//				? new ResponseEntity<>(Map.of("message ", findCityByState, "status", "200"), HttpStatus.OK)
//				: new ResponseEntity<>(Map.of("message ", findCityByState, "status", "204"), HttpStatus.NO_CONTENT);
//	}

//	@GetMapping("/api/test/adminDashBoard")
//	@PreAuthorize("hashRole('ROLE_ADMIN')")
//	public String adminDashBoard() {
//		return null;
//	}

	@RequestMapping(value = "upload/userimage", headers = ("content-type=multipart/*"), method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadUserImage(UserImageFileDto userImageFileDto,
			@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws IOException, IllegalStateException {
		Map<String, Object> body = new HashMap<>();
		boolean doFileUpload = fuh.doFileUpload(file, request);
		if (doFileUpload) {
			userImageFileDto.setImagepicture(file.getOriginalFilename());
			long uid = (long) request.getSession().getAttribute("userid");
			log.info("user id is :: " + uid);
			userImageFileDto.setUid(uid);
			this.userImageFileService.addUserImagePicture(userImageFileDto);

			body.put("status", "200");
			body.put("message", file.getOriginalFilename());
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(Map.of("status", "200", "message",
			// file.getOriginalFilename()), HttpStatus.OK);
		}
		body.put("status", "200");
		body.put("message", "file is not uploaded");
		return new ResponseEntity<>(body, HttpStatus.OK);
//		return new ResponseEntity<>(Map.of("status", "501", "message", "file is not uploaded"),
//				HttpStatus.NOT_IMPLEMENTED);

	}
	/* ======================== Adderess Module================== */

	// save adderess
	@PostMapping("/saveAdderess")
	public ResponseEntity<?> saveAdderess(@RequestBody AdderessDto adderessDto, HttpServletRequest request) {

		Map<String, Object> body = new HashMap<>();
		try {

			if (request.getSession().getAttribute("userid") != null) {
				long attribute = (long) request.getSession().getAttribute("userid");
				adderessDto.setUseradr(attribute);

				/*
				 * if (adderessDto.getMobilenumber() == "" || adderessDto.getMobilenumber() ==
				 * null) { System.out.println("Please Fill Mobile Number .. " +
				 * adderessDto.getMobilenumber()); body.put("message",
				 * "Please Fill Mobile Number"); body.put("statusCode", "202"); return new
				 * ResponseEntity<>(body, HttpStatus.OK); }
				 */
				System.out.println("Mobile Number Length.. " + adderessDto.getMobilenumber().length());
				/*
				 * if(adderessDto.getMobilenumber().length()==10) {
				 * 
				 * }
				 */

				/*
				 * if(adderessDto.getMobilenumber().length()<>10) {
				 * System.out.println("valid mobile number.. "+adderessDto.getMobilenumber());
				 * body.put("message", "valid mobile number"); body.put("statusCode", "203");
				 * return new ResponseEntity<>(body, HttpStatus.OK); }
				 */

				boolean addAdderess = this.adderessService.addAdderess(adderessDto);

				if (addAdderess) {
					body.put("value", adderessDto);
					body.put("message", "Saved Your Address ..  ");
					body.put("statusCode", "200");
					return new ResponseEntity<>(body, HttpStatus.OK);
				}
				body.put("value", adderessDto);
				body.put("message", "Address Is Exists .. ");
				body.put("statusCode", "409");
				return new ResponseEntity<>(body, HttpStatus.CONFLICT);
				// return new ResponseEntity<>(Map.of("value", adderessDto), HttpStatus.OK);

			} else {
				body.put("value", "Please LogIn..");
				return new ResponseEntity<>(body, HttpStatus.OK);
				// return new ResponseEntity<>(Map.of("value", "Please LogIn.."),
				// HttpStatus.BAD_GATEWAY);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		body.put("value", adderessDto.getCity());
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("value", adderessDto.getCity()),
		// HttpStatus.OK);
	}

	@PostMapping("editAddress/{id}")
	public ResponseEntity<?> editAddress( @PathVariable("id") int id, @RequestBody AdderessDto adderessDto, 
			HttpServletRequest request ) {
		Map<String, Object> body = new HashMap<>();
		System.out.println("JITENDRA");
		System.out.println("Adderess Id I : " + id);
		/*
		 * if (adderessDto.getFirstname() == "" || adderessDto.getFirstname() == null) {
		 * System.out.println("Please Fill Mobile Number .. " +
		 * adderessDto.getMobilenumber()); body.put("message",
		 * "Please Fill getFirstname"); body.put("statusCode", "202"); return new
		 * ResponseEntity<>(body, HttpStatus.OK); }
		 * 
		 * if (adderessDto.getLastname() == "" || adderessDto.getLastname() == null) {
		 * System.out.println("Please Fill Mobile Number .. " +
		 * adderessDto.getMobilenumber()); body.put("message",
		 * "Please Fill getLastname"); body.put("statusCode", "202"); return new
		 * ResponseEntity<>(body, HttpStatus.OK); }
		 * 
		 * if (adderessDto.getLocaladderess() == "" || adderessDto.getLocaladderess() ==
		 * null) { System.out.println("Please Fill Mobile Number .. " +
		 * adderessDto.getMobilenumber()); body.put("message",
		 * "Please Fill getLocaladderess"); body.put("statusCode", "202"); return new
		 * ResponseEntity<>(body, HttpStatus.OK); }
		 * 
		 * if (adderessDto.getCity() == "" || adderessDto.getCity() == null) {
		 * System.out.println("Please Fill Mobile Number .. " +
		 * adderessDto.getMobilenumber()); body.put("message", "Please Fill getCity");
		 * body.put("statusCode", "202"); return new ResponseEntity<>(body,
		 * HttpStatus.OK); } if (adderessDto.getCountry() == "" ||
		 * adderessDto.getCountry() == null) {
		 * System.out.println("Please Fill Mobile Number .. " +
		 * adderessDto.getMobilenumber()); body.put("message",
		 * "Please Fill getCountry"); body.put("statusCode", "202"); return new
		 * ResponseEntity<>(body, HttpStatus.OK); }
		 */
		
		/*
		 * if (adderessDto.getMobilenumber() == "" || adderessDto.getMobilenumber() ==
		 * null) { System.out.println("Please Fill Mobile Number .. " +
		 * adderessDto.getMobilenumber()); body.put("message",
		 * "Please Fill Mobile Number"); body.put("statusCode", "202"); return new
		 * ResponseEntity<>(body, HttpStatus.OK); }
		 */
		boolean updateAddress = this.adderessService.updateAddress(id, adderessDto);
		System.out.println("JITENDRA" + updateAddress);
		body.put("statuscode", "200");
		body.put("message", updateAddress);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	
//	@PostMapping("editAddress/{id}")
//	public ResponseEntity<?> editAddress( @Valid @PathVariable("id") int id, @RequestBody AdderessDto adderessDto, 
//			HttpServletRequest request ,BindingResult bindingResult) {
//		Map<String, Object> body = new HashMap<>();
//		System.out.println("JITENDRA");
//		System.out.println("Adderess Id I : " + id);
//		
//		if(bindingResult.hasErrors()) {
//			List<ObjectError> allErrors = bindingResult.getAllErrors();	
//			body.put("message", allErrors);
//			return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);	
//		}
//		boolean updateAddress = this.adderessService.updateAddress(id, adderessDto);
//		return new ResponseEntity<>(body.put("message", "success"), HttpStatus.OK);	
//	}
	// get Adderess

	@GetMapping("/getAdderess")
	public ResponseEntity<?> getAdderess(HttpServletRequest request) {
		Map<String, Object> body = new HashMap<>();
		try {
			long attribute = (long) request.getSession().getAttribute("userid");
			List<Adderess> adderessByUser = this.adderessService.getAdderessByUser(attribute);
			body.put("message", adderessByUser);
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(Map.of("message", adderessByUser),
			// HttpStatus.OK);

		} catch (Exception e) {
			body.put("message", e.getMessage());
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(Map.of("message", e.getMessage()),
			// HttpStatus.OK);
		}
	}

	/* =================== booking part======================== */

	@GetMapping("bookproduct")
	public ResponseEntity<?> bookiing(@RequestParam("adrid") int adrid, HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) {
		log.info("start proccedd" + adrid);
		long attribute = (long) request.getSession().getAttribute("userid");
		log.info("users request id is ::" + attribute);
		boolean bookProduct = this.bookingProductService.bookProduct(attribute, adrid);
		// mv.setViewName("redirect:/");
		Map<String, Object> body = new HashMap<>();
		body.put("message", bookProduct);
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("message", bookProduct), HttpStatus.OK);
//return mv;
	}

	@GetMapping("/getAddressForOrder")
	public ResponseEntity<?> getAddressForOrder(@RequestParam("addressid") int addressid) {
		this.adderessService.deleteAdderessById(addressid);

		Map<String, Object> body = new HashMap<>();
		body.put("status", addressid);
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("status", addressid), HttpStatus.OK);

	}

	/*-----------------------------------ALL CATEGORY   -------------------------------------------------------*/

	@GetMapping(value = "categoryLists")
	public ResponseEntity<?> getAllCategoryLists() {
		Map<String, Object> body = new HashMap<>();
		java.util.List<Category> allCategory = this.categoryService.getAllCategory();
		body.put("message", allCategory);
		log.info("list of image is  :: " + allCategory);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	/*---------------------------------------REMOVE CATEGORY------------------------------------------------*/

	@GetMapping("categoryRemoveByIds/{catid}")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> categoryDeleteById(@PathVariable("catid") long catid) {
		Map<String, Object> body = new HashMap<>();

		try {

			String categoryRemove = this.categoryService.categoryRemove(catid);
			if (categoryRemove.equals("Category Deleted !!")) {

				body.put("status", "200");
				return new ResponseEntity<>(body, HttpStatus.OK);

			}
		} catch (DataIntegrityViolationException ex) {
			body.put("status", "226");
			body.put("message", "this category belongs to some products.. ");
			return new ResponseEntity<>(body, HttpStatus.IM_USED);
		} catch (Exception ex) {
			ex.getMessage();
			body.put("status", "500");
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;

	}

	/*--------------------------- DELETE  ALL PRODUCT BY PRODUCT ID-------------------------*/

	@GetMapping("/deleteproduct/{pid}")
	public ResponseEntity<?> deleteProductById(@PathVariable("pid") int pid) {
		Map<String, Object> body = new HashMap<>();
		try {

			log.info(" Hit deleted products Url ");
			boolean removeProductFromCart = this.addToCartService.removeProductFromCart(pid);
			if (removeProductFromCart) {
				boolean deleteProduct = this.productService.deleteProduct(pid);
			}
			boolean deleteProduct = this.productService.deleteProduct(pid);
			if (deleteProduct) {
//				mv.setViewName("Admin/All-Products");
				body.put("status", "200");
				body.put("message", "Your Product is Deleted");
				return new ResponseEntity<>(body, HttpStatus.OK);

			} else {
				body.put("status", "201");
				body.put("message", "Your Product Can not be  Deleted");
				return new ResponseEntity<>(body, HttpStatus.ALREADY_REPORTED);
			}

			// return new ResponseEntity<>(Map.of("message", "Product Deleted"),
			// HttpStatus.OK);shoping-cart
		}

		catch (DataIntegrityViolationException dataIntegrityViolationException) {
			body.put("status", "226");
			body.put("message", "that product is used another .... ");
			return new ResponseEntity<>(body, HttpStatus.IM_USED);
		}

		catch (Exception e) {
			body.put("status", "500");
			body.put("message", "Internal Server Error .... ");
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*------------------- SHOPING CARTS --------------------------------*/

	@GetMapping("shoping-carts")

	public ResponseEntity<?> getShopingCartS(HttpServletRequest request, HttpServletResponse response, HttpSession s) {
		/* ALL PRODUCT BASED ON USERID */
		Map<String, Object> body = new HashMap<>();
		try {

			long id = (long) request.getSession().getAttribute("userid");
			int totaladdtocartvalue = 0;
			List<AddToCart> findCartDetailBasedOnUserId = null;
			log.info("Session id is ::" + id);
			findCartDetailBasedOnUserId = this.addToCartService.findCartDetailBasedOnUserId(id);
			int countAddToCartProductBasedOnUser = this.addToCartService.countAddToCartProductBasedOnUser(id);

			// int countAddToCartProductBasedOnUser =
			// this.addToCartService.countAddToCartProductBasedOnUser(id);
			// log.info("total number of product specific user add to cart
			// countAddToCartProductBasedOnUser ::"+countAddToCartProductBasedOnUser);
			// log.info("Add Cart Product Details is::"+findCartDetailBasedOnUserId);
			List<ProductDto> productList = new ArrayList<>();
			String files = "";
			String filename = "";
			long totalprice = 0;
			long tax = 0;
			long subtotal = 0;

			if (!findCartDetailBasedOnUserId.isEmpty() && findCartDetailBasedOnUserId != null) {
				for (int i = 0; i < findCartDetailBasedOnUserId.size(); i++) {
					ProductDto dto = new ProductDto();
					dto.setPid(findCartDetailBasedOnUserId.get(i).getProducts().getPid());
					dto.setProductname(findCartDetailBasedOnUserId.get(i).getProducts().getProductname());
					totalprice += findCartDetailBasedOnUserId.get(i).getProducts().getPrice();
					tax += totalprice * 12 / 100;// getting tax value
					dto.setPrice(findCartDetailBasedOnUserId.get(i).getProducts().getPrice());
					dto.setStocks(findCartDetailBasedOnUserId.get(i).getProducts().getStocks());
					dto.setSku(findCartDetailBasedOnUserId.get(i).getProducts().getSku());
					dto.setSizes(findCartDetailBasedOnUserId.get(i).getSize());

					files = findCartDetailBasedOnUserId.get(i).getProducts().getFiles();
					String filesName = files.substring(1, files.length() - 1);
					dto.setFilesretrieve(filesName.split(","));
					productList.add(dto);
					log.info("Proccess end period => " + i);
				}

				// =============== load category ====================================
				//List<CategoryDto> allCategories = commonComponents.getAllCategories();
				List<Category> allcategories = null;
				allcategories = categoryService.getAllCategory();
				List<CategoryDto> CategoryDatalist = new ArrayList<>();
				if (!allcategories.isEmpty() && allcategories != null) {
					for (int i = 0; i < allcategories.size(); i++) {
						CategoryDto dto = new CategoryDto();
						dto.setCatid(allcategories.get(i).getCatid());
						dto.setCategoryname(allcategories.get(i).getCategoryname());
						dto.setFilecategory(allcategories.get(i).getFilecategory());
						CategoryDatalist.add(dto);
					}
				}
				log.info("All Categories are :: " + CategoryDatalist);
				// List<AddToCart> list = findCartDetailBasedOnUserId.stream().filter(x ->
				// x.getSize() != null).toList();
				body.put("total", totalprice);
				body.put("productList", productList);// add product object in model
				body.put("CategoryDatalist", CategoryDatalist);
				body.put("countAddToCartProductBasedOnUser", countAddToCartProductBasedOnUser);
				log.info("countAddToCartProductBasedOnUser 0123 " + countAddToCartProductBasedOnUser);
				tax += (12 / 100) * totalprice;
				body.put("Tax", tax);
				log.info("Tax Rate Value Is", tax = (12 / 100) * totalprice);
				subtotal += totalprice + tax;
				body.put("subtotal", subtotal);

				log.info("total Rate Value Is", subtotal);
				log.info("total price is ::" + subtotal);
				log.info("Tax Rate Value Is" + tax);

				return new ResponseEntity<>(body, HttpStatus.OK);
			}

			return new ResponseEntity<>(body, HttpStatus.OK);
		} catch (NullPointerException ex) {
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
	}

	@GetMapping("addtocartproducts")
//	@ResponseBody
	public ResponseEntity<?> addProductInCarts(@RequestParam("products") int products,
			@RequestParam("size") String size, @RequestParam("orderimage") String orderimage,
			@RequestParam("color") String color,
//			@RequestParam("usersid") int usersid1,
			HttpServletRequest request) {
		Map<String, Object> body = new HashMap<>();
		try {
			log.info(" Session value is :: " + request.getAttribute("userid"));
			log.info("Session ::" + request.getSession().getAttribute("userid"));
			HttpSession session = request.getSession();
			session.getServletContext().getAttribute("userid");
			log.info("context object ::" + session.getServletContext().getAttribute("userid"));
			if (request.getSession().getAttribute("userid") != null
					&& request.getSession().getAttribute("userid") != "") {

				Long attribute = (Long) request.getSession().getAttribute("userid");
				log.info("user id is" + attribute);
				AddToCartDto addToCart = new AddToCartDto();
				addToCart.setProducts(products);
				addToCart.setUsersid(attribute);
				log.info("choose Color is :" + color);
				addToCart.setColor(color);
				/*
				 * if(size=="" || size==null) { log.info("Please Select Size .. ");
				 * body.put("message", "Please Select Size "); body.put("status", "200"); return
				 * new ResponseEntity<>(body, HttpStatus.OK); }
				 */
				addToCart.setSize(size);
				addToCart.setOrderimage(orderimage);
				int addProductToCart = this.addToCartService.addProductToCart(addToCart);
				if (addProductToCart == 1) {
					// mv.setViewName("redirect:");
					// mv.setViewName("redirect:/api/page/index");
					body.put("message", "Product add to cart");
					body.put("status", "200");
					return new ResponseEntity<>(body, HttpStatus.OK);
				}
				// return new ResponseEntity<>(Map.of("message", "Product is Add To Cart"),
				// HttpStatus.OK);
				if (addProductToCart == -1) {
					body.put("message", "Your Product Is Allready Exists InSide Cart ");
					body.put("status", "226");
					return new ResponseEntity<>(body, HttpStatus.IM_USED);
				}

				// return new ResponseEntity<>(Map.of("message", "Something Went Wrong "),
				// HttpStatus.OK);
			} else {
				// return new ResponseEntity<>(Map.of("message", "Please Logged In First Than
				// Product Add To Cart .. "),HttpStatus.OK);
				body.put("message", "Please Login");
				body.put("status", "401");
				return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
			}
		} catch (NullPointerException ex) {
			body.put("message", "Please Login");
			body.put("status", "401");
			return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
		} catch (Exception ex) {
			body.put("message", "Please Login");
			body.put("status", "401");
			return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
			// return new ResponseEntity<>(Map.of("message", ex.getLocalizedMessage()),
			// HttpStatus.BAD_REQUEST);
		}
		return null;

	}

	/* ======================= All OrderList========== */

	@GetMapping("allOrderLists/{remark}")
	public ResponseEntity<?> getAllOrders(@PathVariable("remark") String remark) {
		System.out.println("Your Remark Is :: "+remark);
		Map<String, Object> body = new HashMap<>();
		List<OrderDetailsPojo> bookingDetail = this.payload.getBookingDetail(remark);
		long totalProducts = this.productService.totalProducts();
		int totalordrr = this.bookingProductService.totalProducts();
		        long countByRolesId = this.repository.countByRolesId();  
		// long totalUserCount = this.usrdao.totalUserCount();
		 System.out.println("totalUserCount"+countByRolesId);
		body.put("message", bookingDetail);
		body.put("totalProducts", totalProducts);
		body.put("totalordrr", totalordrr);
		body.put("countByRolesId", countByRolesId);


		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	/*
	 * @GetMapping("dispatchDetails") public ResponseEntity<?> getDispatchDetails()
	 * { Map<String, Object> body=new HashMap<>(); List<OrderDetailsPojo>
	 * bookingDetail = this.payload.getSpecificUserBookingDetail();
	 * body.put("message", bookingDetail);
	 * 
	 * return new ResponseEntity<>(body,HttpStatus.OK); }
	 */

	@GetMapping("dispatchDetails/{orderid}")
	public ModelAndView getDispatchDetails(@PathVariable("orderid") long orderid, ModelAndView mv) {
		List<OrderDetailsPojo> bookingDetail = this.payload.getSpecificUserBookingDetail(orderid);
		mv.addObject("bookingDetail", bookingDetail);
		mv.addObject("getTotalprice", bookingDetail.get(0).getTotalprice());
		mv.addObject("orderid", bookingDetail.get(0).getOrderid());
		mv.addObject("localaddress", bookingDetail.get(0).getOrderaddress());
		mv.setViewName("Admin/orderdetails");
		return mv;
	}

	@GetMapping("orderstatus/{orderid}/{status}")
	public ResponseEntity<?> setOrderStatus(@PathVariable("orderid") long orderid,
			@PathVariable("status") String status) throws SQLException {
		log.info("update status value is :-" + status);
		log.info("order id value is :-" + orderid);

		Map<String, Object> body = new HashMap<>();
		body.put("status", status);
		body.put("orderid", orderid);
		int updateOrderStatus = bookingProductDao.updateOrderStatus(orderid, status);
		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	/* =======================filtering data================ */

	@GetMapping("getFilterDatas/{fdate}/{tdate}/{mark}")
//	@GetMapping("getFilterDatas")
	@ResponseBody
	public ResponseEntity<?> getFilterDatas(@PathVariable("fdate") String fdate, @PathVariable("tdate") String tdate,
			@PathVariable("mark") String mark) {
		Map<String, Object> body = new HashMap<>();
		try {

			System.out.println("FIRST:" + fdate);
			System.out.println("LAST:" + tdate);
			System.out.println("MARK:" + mark);

			Map<String, Object> filterDateAndRemarkWiseBookngOrderDetails = this.bookingProductService
					.getFilterDateAndRemarkWiseBookngOrderDetails(fdate, tdate, mark);
			@SuppressWarnings("rawtypes")
			List<OrderDetailsPojo> bookingdao = new ArrayList();
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> results = (List<Map<String, Object>>) filterDateAndRemarkWiseBookngOrderDetails
					.get("#result-set-1");
			System.out.println("RESULTS ARE : " + results.get(0).get(results));
			// body.put("message", filterDateAndRemarkWiseBookngOrderDetails);

			results.forEach(rs -> {
				OrderDetailsPojo pojo = new OrderDetailsPojo();

				pojo.setCustomername((String) rs.get("customername"));
				// pojo.setPrice((long) rs.get("price"));
				pojo.setOrderstatus((String) rs.get("remark"));
				pojo.setOrderimage((String) rs.get("orderimages"));
				// pojo.setOrderid((long) rs.get("order_booking_id"));
				pojo.setOrderaddress((String) rs.get("deliverdaddress"));
				pojo.setOpname((String) rs.get("productname"));
				bookingdao.add(pojo);
			});

			// List<BookingProduct> filterDatas = this.bookingProductDao.getFilterDatas();
			body.put("message", bookingdao);
			return new ResponseEntity<>(body, HttpStatus.OK);
			// return new ResponseEntity<>(filterDateAndRemarkWiseBookngOrderDetails,
			// HttpStatus.OK);
		} catch (Exception e) {
			body.put("message", e.getMessage());
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
	}

	@PostMapping("reset-password")
	public ResponseEntity<?> restYourPassword(@RequestBody ForgetPassword forgetPassword) {
		Map<String, Object> body = new HashMap<>();
		String forgotPassword = this.service.forgotPassword(forgetPassword.getEmails());

		// String resetPassword = this.service.resetPassword(forgotPassword,
		// forgetPassword.getPasswords());

		System.out.println(forgetPassword.getPasswords());
		System.out.println(forgetPassword.getEmails());
		System.out.println("Reset Pass Code " + forgotPassword);
		body.put("message", "resetPassword");
		body.put("status", "200");

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@PostMapping("verifiy-otp")
	public ResponseEntity<?> verifyOtp(@RequestBody ForgetPassword forgetPassword) {
		Map<String, Object> body = new HashMap<>();
		System.out.println("Reset Pass Code " + forgetPassword.getOtpverifier());
		System.out.println("Reset Pass Code " + forgetPassword.getPasswords());
		String resetPassword = this.service.resetPassword(forgetPassword.getOtpverifier(),
				forgetPassword.getPasswords());
		body.put("message", resetPassword);
		body.put("status", "200");

		return new ResponseEntity<>(body, HttpStatus.OK);

	}
	
	
	@GetMapping("search-product/{name}")
	public ResponseEntity<?> searchProductData(@PathVariable("name") String name){
		Map<String, Object> body=new HashMap<String, Object>();
		 List<ProductDto> searchProductData = this.productDao.searchProductData(name);
		//Product findByproductname = this.productRepository.findByproductname(name);	
		 body.put("data", searchProductData);
		
		return new ResponseEntity<>(body,HttpStatus.OK);
	}

}