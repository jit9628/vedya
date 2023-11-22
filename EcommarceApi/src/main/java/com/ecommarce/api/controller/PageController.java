package com.ecommarce.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ecommarce.api.CheckAuthenticateUser;
import com.ecommarce.api.dao.BookingProductDao;
import com.ecommarce.api.dao.CategoryDao;
import com.ecommarce.api.dao.OptionForGroupsDao;
import com.ecommarce.api.dao.ProductDao;
import com.ecommarce.api.dto.CategoryDto;
import com.ecommarce.api.dto.ProductDto;
import com.ecommarce.api.entity.Adderess;
import com.ecommarce.api.entity.Category;
import com.ecommarce.api.entity.OptionForGroups;
import com.ecommarce.api.entity.Product;
import com.ecommarce.api.payload.OrderDetailsPayload;
import com.ecommarce.api.repo.AdderessRepository;
import com.ecommarce.api.service.AddToCartService;
import com.ecommarce.api.service.CategoryService;
import com.ecommarce.api.service.OptionForGroupsService;
import com.ecommarce.api.service.OptionsGroupService;
import com.ecommarce.api.service.ProductService;
import com.ecommarce.api.utility.GenericHandleData;

import lombok.extern.slf4j.Slf4j;

@RestController
//@AllArgsConstructor
@Slf4j

@RequestMapping("/api/page/")
public class PageController {
	@Autowired
	private GenericHandleData data;
	@Autowired
	CheckAuthenticateUser checkAuth;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OptionForGroupsService optionForGroupsService;
	@Autowired
	private OptionsGroupService optionsGroupService;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AddToCartService addToCartService;
	@Autowired
	private CommonComponents commonComponents;

	// optionforgroup dao instantiation
	private OptionForGroupsDao optionForGroupsDao;
	@Autowired
	private CategoryDao catDao;
	@Autowired
	private OrderDetailsPayload detailsPayload;
	@Autowired
	private BookingProductDao bookingProductRepository;
	@Autowired
	private AdderessRepository adderessRepository;
	@Autowired
	private CheckAuthenticateUser checkAuthenticateUser;

	/*--------------- INDEX PAGE  ---------------*/
	@GetMapping("index")
	public ModelAndView getIndexPage(ModelAndView mv, HttpServletRequest request) {
		int countAddToCartProductBasedOnUser = 0;
		try {
			long totalProducts2 = this.productService.totalProducts();
			log.info("totalProducts2 :-- " + totalProducts2);
			if (request.getSession().getAttribute("userid") != null) {
				Long attribute = (Long) request.getSession().getAttribute("userid");
				// Long attribute = (Long)request.getAttribute("userid");
				countAddToCartProductBasedOnUser = this.addToCartService.countAddToCartProductBasedOnUser(attribute);
				mv.addObject("countAddToCartProductBasedOnUser", countAddToCartProductBasedOnUser);
			}

			// Integer countDataValue = this.data.countDataValue("users");
			// log.info("countDataValue"+countDataValue);
			// detailsPayload.getBookingDetail();
// List<BookingProduct>
// filterDateAndRemarkWiseBookngOrderDetails =
// this.bookingProductRepository.getFilterDateAndRemarkWiseBookngOrderDetails("","","");
// log.info("filterDateAndRemarkWiseBookngOrderDetails is :"
// + filterDateAndRemarkWiseBookngOrderDetails);
// String imageFileBasedOnCategory =
// catDao.getImageFileBasedOnCategory(8);
// log.info("Category Image File is :" +
// imageFileBasedOnCategory);

			List<Product> allProduct = null;
			List<Category> allcategories = null;
			long totalProducts = this.productService.totalProducts();
			log.info("total products is ::" + totalProducts);
			allProduct = productService.getAllProduct();

			// log.info("topFourCategory size :: "
			// +topFourCategory.get(0).getCategoryname());
			// allcategories = categoryService.getAllCategory();
			allcategories = this.catDao.topFourCategory();
			log.info("product size :: " + allProduct.size());
			List<ProductDto> listOfObject = new ArrayList<>();
			List<CategoryDto> CategoryDatalist = new ArrayList<>();
			String files = "";
			String filename = "";
			if (!allcategories.isEmpty() && allcategories != null) {

				for (int i = 0; i < allcategories.size(); i++) {
					CategoryDto dto = new CategoryDto();
					dto.setCatid(allcategories.get(i).getCatid());
					dto.setCategoryname(allcategories.get(i).getCategoryname());
					dto.setFilecategory(allcategories.get(i).getFilecategory());
					CategoryDatalist.add(dto);
				}
			}
			log.info(filename);
			/* ===================== for products list =================== */
			if (!allProduct.isEmpty() && allProduct != null) {

				// Stream<Product> streamOf = streamOf(allProduct);
				// streamOf = streamOf.filter(x -> x.getFiles()!= null &&
				// x.getFiles().isEmpty());
				// streamOf.collect(() ->new :: getFiles());
//				List<String> collect2 = allProduct.stream()
//						.map(Product::getFiles)
//						.collect(Collectors.toList());
				// log.info("files are {}",collect2);
//				streamOf.forEach(
//						x -> x.setFilesretrieve(x.getFiles().substring(1, x.getFiles().length() - 1).split(".")));
				// streamOf.close();
				// List<Product> collect = streamOf.collect(Collectors.toList());
				// log.info("product image List is ::" + collect);
				// allProduct.forEach(x -> x.setFilesretrieve(x.getFiles().substring(1,
				// x.getFiles().length() - 1).split(",")));
				// String files2 = allProduct.get(0).getFiles();
				log.info("all images are :: " + allProduct.get(0).getFiles());
				for (int i = 0; i < allProduct.size(); i++) {
					log.info("Proccess statrt period => " + i);
					ProductDto dto = new ProductDto();
					dto.setPid(allProduct.get(i).getPid());
					dto.setProductname(allProduct.get(i).getProductname());
					dto.setPrice(allProduct.get(i).getPrice());
					dto.setStocks(allProduct.get(i).getStocks());
					dto.setSku(allProduct.get(i).getSku());
					files = allProduct.get(i).getFiles();
					String filesName = files.substring(1, files.length() - 1);
					dto.setFilesretrieve(filesName.split(","));
					listOfObject.add(dto);
					log.info("Proccess end period => " + i);
				}
				mv.addObject("listOfData", listOfObject);
				mv.addObject("CategoryDatalist", CategoryDatalist);
				mv.addObject("totalproducts", totalProducts);

				mv.setViewName("index");
				return mv;
			}

		} catch (NullPointerException nullPointerException) {
			log.warn("Null Pointer Exception  Products Is {}", nullPointerException.getMessage());
			log.warn("Exceptions All Products Is {}", nullPointerException.getMessage());
			mv.setViewName("index");
			return mv;
		} catch (Exception e) {
			log.warn("Exceptions All Products Is {}", e.getMessage());
			// log.debug("Exceptions All Products Is {}", e.printStackTrace());
			e.printStackTrace();

			e.getMessage();
			mv.setViewName("index");
			return mv;
		}
		mv.setViewName("index");
		return mv;
	}

	/*-------------------- LOGIN PAGE-------------------*/
	@GetMapping("LogIn")
	public ModelAndView getSignUpPage(ModelAndView MV, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		String parameter = httpServletRequest.getParameter("isNotValid");

		log.info("parameter value is ::" + parameter);

		if (parameter == null || parameter == "") {
			MV.addObject("isNotValid", true);
		} else if (parameter != null) {
			MV.addObject("isNotValid", false);
		}
		MV.setViewName("login");

		return MV;
	}

	/*------------------- REGISTER PAGE--------------------------*/
	@GetMapping("SignUp")
	public ModelAndView getLogInPage(ModelAndView MV) {

		MV.setViewName("SignUp");
		return MV;
		// MV.setViewName("Test");
		// return MV;
	}

	/* ==================== CATEGORY PART==================== */

	@GetMapping("All-Category")
	public ModelAndView getAllCategory(ModelAndView MV) {
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
		MV.addObject("CategoryDatalist", CategoryDatalist);
		log.debug("list of category :: " + CategoryDatalist);
		MV.setViewName("category");
		return MV;
	}

	/*--------------------- Send JSON Response ----------------------*/

	@GetMapping("All-Category-list")
	public ResponseEntity<?> getAllCategoryList() {

		Map<String, Object> body = new HashMap<>();
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
		body.put("CategoryDatalist", CategoryDatalist);

		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@GetMapping("CategoryWiseProduct/{catid}")
	public ModelAndView getCategoryWiseProduct(@PathVariable("catid") long catid, ModelAndView MV,HttpServletRequest request) {
	
		if (request.getSession().getAttribute("userid") != null) {
			Long attribute = (Long) request.getSession().getAttribute("userid");
			// Long attribute = (Long)request.getAttribute("userid");
			int countAddToCartProductBasedOnUser = this.addToCartService.countAddToCartProductBasedOnUser(attribute);
			MV.addObject("countAddToCartProductBasedOnUser", countAddToCartProductBasedOnUser);
		}
		
		Optional<Category> searchCategoryById = categoryService.searchCategoryById(catid);
		Category category = searchCategoryById.get();
		Set<Product> productlist = category.getProduct();
		
		
		
		List<Product> CategoryDatalist = new ArrayList<>();
		String filesName = "";
		String files = "";
		List<ProductDto> listOfObject = new ArrayList<>();
		if (!productlist.isEmpty() && productlist != null) {
			List<Product> collect = productlist.stream().collect(Collectors.toList());
			streamOf(collect);
			log.debug("list of category :: " + collect);
			for (int i = 0; i < collect.size(); i++) {

				ProductDto dtos = new ProductDto();
				dtos.setPid(collect.get(i).getPid());
				dtos.setProductname(collect.get(i).getProductname());
				dtos.setPrice(collect.get(i).getPrice());
				dtos.setStocks(collect.get(i).getStocks());
				dtos.setSku(collect.get(i).getSku());
				files = collect.get(i).getFiles();
				filesName = files.substring(1, files.length() - 1);
				dtos.setFilesretrieve(filesName.split(","));

				listOfObject.add(dtos);

			}
		}
		MV.addObject("CategoryDatalist", listOfObject);
		log.debug("list of category :: " + listOfObject);

		MV.setViewName("CategoryWiseProduct");
		return MV;
	}

	/* ======================== Products================================ */

	/*------------------ PRODUCT PAGE -------------*/
	@GetMapping("ProductPage")
	// @PreAuthorize(value = "hashRole('ADMIN')")
	public ModelAndView getProductPage(ModelAndView mv, HttpServletRequest request) {

		try {
//			int checkAuthenticatedIsTrue = checkAuth.checkAuthenticatedIsTrue();
//			if(checkAuthenticatedIsTrue==0)
//			{
//				mv.setViewName("redirect:/api/page/LogIn");
//				 return mv;
//			}
			String chekRole = checkAuthenticateUser.chekRole();
			if(chekRole==null ) {
				 mv.setViewName("redirect:/api/page/LogIn");
				 return mv;
			}
			if(chekRole!="admin")
			{
				 mv.setViewName("redirect:/api/page/LogIn");
				 return mv;
			}
			
			log.info("query string value is " + request.getParameter("msg"));
			List<Category> allCategory = categoryService.getAllCategory();
			mv.addObject("categorydatavalue", allCategory);
			log.info("list of category is " + allCategory);

//			message.setFiles(((String) jsonObject.get("files")).split(","));
//			String filesName = (String) jsonObject.get("files");
//			filesName = filesName.substring(1, filesName.length() - 1);
			mv.addObject("msg", request.getParameter("msg"));
			mv.setViewName("Admin/Add-Product");
			return mv;
		} catch (Exception e) {
			e.getMessage();
		}
		return mv;
	}

	/*-------------------- LIST OF PRODUCT---------------*/
	@GetMapping("All-Product")
	public ModelAndView getAllProductPage(ModelAndView mv) {
		try {
			List<Product> allProduct = null;

			// allproducts are
			long totalProducts = this.productService.totalProducts();
			log.info("total products is ::" + totalProducts);
			allProduct = productService.getAllProduct();
			List<ProductDto> listOfObject = new ArrayList<>();

			String files = "";
//			List<String> datasize = new ArrayList<>();

//			check product is null or not

			if (!allProduct.isEmpty() && allProduct != null) {
				for (int i = 0; i < allProduct.size(); i++) {
					ProductDto dto = new ProductDto();
					dto.setPid(allProduct.get(i).getPid());
					dto.setProductname(allProduct.get(i).getProductname());
					dto.setPrice(allProduct.get(i).getPrice());
					dto.setStocks(allProduct.get(i).getStocks());
					dto.setSku(allProduct.get(i).getSku());
					files = allProduct.get(i).getFiles();

					String filesName = files.substring(1, files.length() - 1);
					dto.setFilesretrieve(filesName.split(","));
					listOfObject.add(dto);
				}
				mv.addObject("listOfData", listOfObject);
				mv.addObject("totalproducts", totalProducts);
				mv.setViewName("Admin/All-Products");
				return mv;
			}
			log.warn("Product is empty {}", allProduct.isEmpty());
		} catch (NullPointerException nullPointerException) {
			log.warn("Null Pointer Exception  Products Is {}", nullPointerException.getMessage());
			log.warn("Exceptions All Products Is {}", nullPointerException.getMessage());
			mv.setViewName("Admin/All-Products");
			return mv;
		}

		catch (Exception e) {
			log.warn("Exceptions All Products Is {}", e.getMessage());
			e.getMessage();
			mv.setViewName("Admin/All-Products");
			return mv;
		}

		return mv;

	}
	/*----------------------PRODUCT DETAILS PAGE--------------------*/

	/*-------------------- LIST OF PRODUCT---------------*/
	@GetMapping("Product-dtl")
	public ModelAndView getProductDetailsPage(ModelAndView mv) {
		try {
			// allproducts are
			List<Product> allProduct = productService.getAllProduct();
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

	@GetMapping("Product-dtl-usr")
	public ModelAndView getProductDetailsPageUser(ModelAndView mv,HttpServletRequest request) {
		
		if (request.getSession().getAttribute("userid") != null) {
			Long attribute = (Long) request.getSession().getAttribute("userid");
			// Long attribute = (Long)request.getAttribute("userid");
		int	countAddToCartProductBasedOnUser = this.addToCartService.countAddToCartProductBasedOnUser(attribute);
			mv.addObject("countAddToCartProductBasedOnUser", countAddToCartProductBasedOnUser);
		}
		mv.setViewName("shop");
		return mv;

	}

	@SuppressWarnings({ "unused", "null" })
	@GetMapping("Product-dtls")
	public ResponseEntity<?> getProductDetailsPages(HttpServletRequest request) {
		
		Map<String, Object> body = new HashMap<>();
		List<Product> allProduct = null;
		List<ProductDto> listOfObject = null;
		try {
			allProduct = productService.getAllProduct();
			List<Category> allcategories = null;
			allcategories = categoryService.getAllCategory();
			long id = (long) request.getSession().getAttribute("userid");
			log.info("User id is Zero" + id);
			int countAddToCartProductBasedOnUser = this.addToCartService.countAddToCartProductBasedOnUser(id);
			log.info("users countAddToCartProductBasedOnUser is ::" + countAddToCartProductBasedOnUser);
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
			body.put("countAddToCartProductBasedOnUser", countAddToCartProductBasedOnUser);
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		catch (NullPointerException e) {
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

	@SuppressWarnings("unused")
	@GetMapping("indexpage-Product-dtls")
	public ResponseEntity<?> getProductDetailsIndexPages() {
		Map<String, Object> body = new HashMap<>();
		List<Product> allProduct = null;
		List<ProductDto> listOfObject = null;

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
		body.put("status", "200");
		body.put("listOfData", listOfObject);

		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	/*
	 * catch (NullPointerException e) { body.put("status", "201");
	 * //body.put("listOfData", listOfObject); return new ResponseEntity<>(body,
	 * HttpStatus.OK); }
	 */

	/*---------------------------------------   product based on specific product id and category matchig products---------------- */

	@GetMapping("product-details/{pid}")
	public ModelAndView getSpecificProductDetails(@PathVariable("pid") int no, ModelAndView mv,HttpServletRequest request) {
		if (request.getSession().getAttribute("userid") != null) {
			Long attribute = (Long) request.getSession().getAttribute("userid");
			// Long attribute = (Long)request.getAttribute("userid");
			int countAddToCartProductBasedOnUser = this.addToCartService.countAddToCartProductBasedOnUser(attribute);
			mv.addObject("countAddToCartProductBasedOnUser", countAddToCartProductBasedOnUser);
		}
		Optional<Product> findProductById = Optional.ofNullable(productService.findProductById(no).get());
		Product product = findProductById.get();
		Optional<Category> searchCategoryById = this.categoryService
				.searchCategoryById(product.getCategory().getCatid());
		Category category = searchCategoryById.get();
		// access all product
		Set<Product> product2 = category.getProduct();
		String files3 = product.getFiles();
		String string2 = files3.toString();
		String substring2 = string2.substring(1, string2.length() - 1);
		log.info(" Sub  string Files details are :: {}", substring2);
		log.info("Files details are :: {}", product.getFiles());
		String files2 = product.getFiles();
		ProductDto map1 = mapper.map(product2, ProductDto.class);
		ArrayList<String> listoffile = map1.getFiles();
		mv.addObject("details1", map1);
		mv.addObject("categorydtl", category);
		mv.addObject("listoffile", listoffile);
		/* =========== List of files ============== */
		ProductDto map = mapper.map(product, ProductDto.class);
		ArrayList<String> files = map.getFiles();
		String string = files2.toString();
		log.info(" string Files details are :: {}", string);
		String substring = string.substring(1, string.length() - 1);
		log.info(" Sub  string Files details are :: {}", substring);
		map.setFilesretrieve(substring.split(","));
		mv.addObject("details", map);

		mv.addObject("imagedetails", files);
		// matching products
		mv.addObject("details", map);
		mv.addObject("imagedetails", files);
		log.info("imagedetails :" + files);
		TreeSet<String> productsize = map.getProductsize();
		log.info("set size is :" + productsize);
		log.info("set size is :" + productsize.size());

//		check imgae file is more then one or not if file size grater then one
		List<String> sliderfile = new ArrayList<>();
		String[] filesretrieve = map.filesretrieve;
		if (filesretrieve.length == 1) {
			sliderfile.add(filesretrieve[0]);
		}

		for (int i = 1; i < filesretrieve.length; i++) {
			log.debug("debug files are {}", filesretrieve[i]);
			sliderfile.add(filesretrieve[i].toString().trim());
		}
		log.info("list of file is :" + sliderfile);
		log.info("files here " + files);

		mv.addObject("productsize", productsize);
		mv.addObject("sliderfile", sliderfile);

		/* ======================= MATCHING PRODUCTS =========================== */

		List<Product> findByCategory = this.productDao.findByCategory(product.getCategory().getCatid());
		List<ProductDto> matchingproduct = new ArrayList<>();
		ArrayList<String> matchingimages = new ArrayList<>();
		String matchesfile = "";

		for (int i = 0; i < findByCategory.size(); i++) {
			ProductDto dto2 = new ProductDto();

			dto2.setPid(findByCategory.get(i).getPid());
			dto2.setProductname(findByCategory.get(i).getProductname());
			dto2.setDiscription(findByCategory.get(i).getDiscription());
			dto2.setSku(findByCategory.get(i).getSku());
			dto2.setPrice(findByCategory.get(i).getPrice());
			matchesfile = findByCategory.get(i).getFiles();
			String filesName = matchesfile.substring(1, matchesfile.length() - 1);
			dto2.setFilesretrieve(filesName.split(","));
			matchingproduct.add(dto2);
		}

		log.debug("matches product :: {}", matchingproduct);
		log.debug("matches product Files :: {}", matchingimages);
		mv.addObject("matchingproduct", matchingproduct);

		mv.addObject("matchingimages", matchingimages);

		mv.setViewName("product-detail");
		return mv;
	}

	/* ========================== Product Details Response Json ================= */

	@GetMapping("specificProduct/{id}")
	public ResponseEntity<?> getSpecificProductDetails(@PathVariable("id") int id) {
		Map<String, Object> body = new HashMap<>();
		try {

			Optional<Product> findProductById = Optional.ofNullable(productService.findProductById(id).get());
			Product product = findProductById.get();
			Optional<Category> searchCategoryById = this.categoryService
					.searchCategoryById(product.getCategory().getCatid());
			Category category = searchCategoryById.get();
			// access all product
			Set<Product> product2 = category.getProduct();
			String files3 = product.getFiles();
			String string2 = files3.toString();
			String substring2 = string2.substring(1, string2.length() - 1);
			log.info(" Sub  string Files details are :: {}", substring2);
			log.info("Files details are :: {}", product.getFiles());
			String files2 = product.getFiles();
			ProductDto map1 = mapper.map(product2, ProductDto.class);
			ArrayList<String> listoffile = map1.getFiles();
			/*
			 * mv.addObject("details1", map1); mv.addObject("categorydtl", category);
			 * mv.addObject("listoffile", listoffile);
			 */
			/* =========== List of files ============== */
			ProductDto map = mapper.map(product, ProductDto.class);
			ArrayList<String> files = map.getFiles();
			String string = files2.toString();
			log.info(" string Files details are :: {}", string);
			String substring = string.substring(1, string.length() - 1);
			log.info(" Sub  string Files details are :: {}", substring);
			map.setFilesretrieve(substring.split(","));
			// matching products
			body.put("imagedetails", files);
			TreeSet<String> productsize = map.getProductsize();

			String string3 = productsize.toString();
			String substring3 = string3.substring(1, string3.length() - 1);

			log.info("substring value :: " + substring3);
			String[] split = substring3.split(",");

			log.info("set size is :" + productsize);
			log.info("set size is :" + productsize.size());

//			check imgae file is more then one or not if file size grater then one
			List<String> sliderfile = new ArrayList<>();
			String[] filesretrieve = map.filesretrieve;
			if (filesretrieve.length == 1) {
				sliderfile.add(filesretrieve[0]);
			}

			for (int i = 1; i < filesretrieve.length; i++) {
				log.debug("debug files are {}", filesretrieve[i]);
				sliderfile.add(filesretrieve[i].toString().trim());
			}
			log.info("list of file is :" + sliderfile);
			log.info("files here " + files);

			body.put("productsize", split);
			body.put("sliderfile", sliderfile);

			/* ======================= MATCHING PRODUCTS =========================== */

			List<Product> findByCategory = this.productDao.findByCategory(product.getCategory().getCatid());
			List<ProductDto> matchingproduct = new ArrayList<>();
			ArrayList<String> matchingimages = new ArrayList<>();
			String matchesfile = "";

			for (int i = 0; i < findByCategory.size(); i++) {
				ProductDto dto2 = new ProductDto();

				dto2.setPid(findByCategory.get(i).getPid());
				dto2.setProductname(findByCategory.get(i).getProductname());
				dto2.setDiscription(findByCategory.get(i).getDiscription());
				dto2.setSku(findByCategory.get(i).getSku());
				dto2.setPrice(findByCategory.get(i).getPrice());
				matchesfile = findByCategory.get(i).getFiles();
				String filesName = matchesfile.substring(1, matchesfile.length() - 1);
				dto2.setFilesretrieve(filesName.split(","));
				matchingproduct.add(dto2);
			}

			return new ResponseEntity<>(body, HttpStatus.OK);

		} catch (Exception e) {
			body.put("message", "abc");
			return new ResponseEntity<>(body, HttpStatus.OK);

		}
	}

	/*
	 * =============================================================================
	 * =====
	 */
	/* ADMIN */

	@GetMapping("product-view/{pid}")
	public ModelAndView getProductView(@PathVariable("pid") int no, ModelAndView mv) {

		Optional<Product> findProductById = Optional.ofNullable(productService.findProductById(no).get());
		Product product = findProductById.get();
		Optional<Category> searchCategoryById = this.categoryService
				.searchCategoryById(product.getCategory().getCatid());
		Category category = searchCategoryById.get();
		// access all product
		Set<Product> product2 = category.getProduct();
		String files3 = product.getFiles();
		String string2 = files3.toString();
		String substring2 = string2.substring(1, string2.length() - 1);
		// log.info(" Sub string Files details are :: {}", substring2);
		log.info("Files details are :: {}", product.getFiles());
		String files2 = product.getFiles();
		ProductDto map1 = mapper.map(product2, ProductDto.class);
		ArrayList<String> listoffile = map1.getFiles();
		mv.addObject("details1", map1);
		mv.addObject("categorydtl", category);
		mv.addObject("listoffile", listoffile);
		ProductDto map = mapper.map(product, ProductDto.class);
		ArrayList<String> files = map.getFiles();
		String string = files2.toString();
		log.info(" string Files details are :: {}", string);
		String substring = string.substring(1, string.length() - 1);
		log.info(" Sub  string Files details are :: {}", substring);
		map.setFilesretrieve(substring.split(","));
		mv.addObject("details", map);
		mv.addObject("imagedetails", files);
		// matching products
		mv.addObject("details", map);
		mv.addObject("imagedetails", files);
		mv.setViewName("Admin/product-view");
		return mv;
	}

	/* ===========================CATEGORY====================== */
	@GetMapping("addCategory")
	public ModelAndView getCategoryPage(ModelAndView mv, HttpServletRequest request) {
//		int checkAuthenticatedIsTrue = checkAuth.checkAuthenticatedIsTrue();
//		if(checkAuthenticatedIsTrue==0)
//		{
//			 mv.setViewName("redirect:/api/page/LogIn");
//			 return mv;
//		}
		
		String chekRole = checkAuthenticateUser.chekRole();
		System.out.println("CHECK ROLE IS .. "+chekRole);
		if(chekRole==null || chekRole!="admin")
		{
			 mv.setViewName("redirect:/api/page/LogIn");
			 return mv;
		}
		
		
		System.out.println("Check Role .."+chekRole);
		mv.addObject("msg", request.getParameter("msg"));
		log.debug("status message is ::" + request.getParameter("msg"));
		mv.setViewName("Admin/Add-Category");
		return mv;
	}

	/*------------------ common method -----------------------*/

	public List<ProductDto> fetchDataValue() {

		List<ProductDto> listOfObject = new ArrayList<>();
		try {
			// allproducts are
			
			List<Product> allProduct = productService.getAllProduct();

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
			return listOfObject;
		} catch (Exception e) {
			e.getMessage();
		}
		return listOfObject;
	}
	@GetMapping("/productproperty/{id}")
	public ModelAndView productproperty(@PathVariable("id") int id, ModelAndView mv) {

		// get the size and color
		List<OptionForGroups> size = this.optionForGroupsDao.findByGroupId(1);
		List<OptionForGroups> color = this.optionForGroupsDao.findByGroupId(2);
		Stream<OptionForGroups> stream = size.stream();
		List<OptionForGroups> collect = stream.collect(Collectors.toList());
		mv.addObject("sizedata", size);
		mv.addObject("colordata", color);
		mv.setViewName("Admin/product-property-add");
		return mv;
	}

	@GetMapping("about")
	public ModelAndView getAbout(ModelAndView mv ,HttpServletRequest request) {
		if (request.getSession().getAttribute("userid") != null) {
			Long attribute = (Long) request.getSession().getAttribute("userid");
			// Long attribute = (Long)request.getAttribute("userid");
			int countAddToCartProductBasedOnUser = this.addToCartService.countAddToCartProductBasedOnUser(attribute);
			mv.addObject("countAddToCartProductBasedOnUser", countAddToCartProductBasedOnUser);
		}
		mv.setViewName("About");
		return mv;
	}

	public Stream<Product> streamOf(List<Product> list) {
		return list == null || list.isEmpty() ? Stream.empty() : list.stream();
	}

	public List<Object> CommonMethods() {
		return null;
	}
	/* =========== Access loginpage =================== */

	@GetMapping("log")
	public String AccessPage() {
		return "login";
	}

	@GetMapping("AllCategories")
	public ModelAndView getAllCategories(ModelAndView mv) {
		String chekRole = checkAuthenticateUser.chekRole();
		if(chekRole!=null && chekRole!="admin")
		{
			 mv.setViewName("redirect:/api/page/LogIn");
			 return mv;
		}
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
		mv.addObject("CategoryDatalist", CategoryDatalist);
		mv.setViewName("AllCategories");
		return mv;

	}

	/* ===================== Ajax Call Product Load========================== */

	/*-------------------- LIST OF PRODUCT---------------*/
	@GetMapping("All-Products")
	public ResponseEntity<?> getAllProductPages(ModelAndView mv) {
		Map<String, Object> body = new HashMap<>();
		try {
			List<Product> allProduct = null;

			// allproducts are
			long totalProducts = this.productService.totalProducts();
			log.info("total products is ::" + totalProducts);
			allProduct = productService.getAllProduct();
			List<ProductDto> listOfObject = new ArrayList<>();

			String files = "";
//			List<String> datasize = new ArrayList<>();

//			check product is null or not

			if (!allProduct.isEmpty() && allProduct != null) {
				for (int i = 0; i < allProduct.size(); i++) {
					ProductDto dto = new ProductDto();
					dto.setPid(allProduct.get(i).getPid());
					dto.setProductname(allProduct.get(i).getProductname());
					dto.setPrice(allProduct.get(i).getPrice());
					dto.setStocks(allProduct.get(i).getStocks());
					dto.setSku(allProduct.get(i).getSku());
					files = allProduct.get(i).getFiles();

					String filesName = files.substring(1, files.length() - 1);
					dto.setFilesretrieve(filesName.split(","));
					listOfObject.add(dto);
				}

				body.put("filesdata", files);
				body.put("message", listOfObject);
				// mv.addObject("listOfData", listOfObject);
				// mv.addObject("totalproducts", totalProducts);
				mv.setViewName("Admin/All-Products");
				return new ResponseEntity<>(body, HttpStatus.OK);
				// return mv;

			}
			log.warn("Product is empty {}", allProduct.isEmpty());
		} catch (NullPointerException nullPointerException) {
			body.put("message", "Product Not Available");
			return new ResponseEntity<>(body, HttpStatus.NO_CONTENT);
			// log.warn("Null Pointer Exception Products Is {}",
			// nullPointerException.getMessage());
			// log.warn("Exceptions All Products Is {}", nullPointerException.getMessage());
			// mv.setViewName("Admin/All-Products");
			// return mv;
		}

		catch (Exception e) {
			// log.warn("Exceptions All Products Is {}", e.getMessage());
			// e.getMessage();
			// mv.setViewName("Admin/All-Products");

			body.put("message", "Product Not Available");
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
			// return mv;
		}

		return null;

	}

	/* ============================= category name==================== */

	public List<CategoryDto> getCategoryDetails() {
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
		return CategoryDatalist;
	}

	@GetMapping("testfile")
	public ModelAndView getTestfile(ModelAndView mv) {
		// mv.setViewName("Admin/orderdetails");
		mv.setViewName("Admin/orderlist");
		return mv;

	}

	@GetMapping("orderdetails")
	public ModelAndView getoOderDetailsProductAndSum(ModelAndView mv) {
		mv.setViewName("Admin/orderdetails");
		// mv.setViewName("Admin/orderlist");
		return mv;

	}
	
	@GetMapping("order-delivered-details")
	public ModelAndView getOderDeliveredDetailsProduct(ModelAndView mv) {
		mv.setViewName("Admin/orderdelevereddetails");
		// mv.setViewName("Admin/orderlist");
		return mv;

	}

	@GetMapping("order-dispatch-details")
	public ModelAndView getOderDispatchDetailsProduct(ModelAndView mv) {
		mv.setViewName("Admin/orderdispatchdetails");
		// mv.setViewName("Admin/orderlist");
		return mv;

	}

	@GetMapping("forgote-password")
	public ModelAndView getForgotePage(ModelAndView mv) {
		mv.setViewName("forgotten-password");
		// mv.setViewName("Admin/orderlist");
		return mv;

	}

	// @GetMapping("forgote-password")
	@GetMapping("updateAddress/{id}")
	public ModelAndView getUpdateAddressPage(@PathVariable("id") int id, ModelAndView mv) {
		Adderess adderess = this.adderessRepository.findById(id).get();
		mv.addObject("updateaddress", adderess);
		mv.setViewName("address-update");

		return mv;
		/*
		 * Map<String, Object> body = new HashMap<>(); Adderess adderess =
		 * this.adderessRepository.findById(id).get();
		 * System.out.println("Address Id Is :: "+adderess.getEmail());
		 * body.put("message", adderess); return new ResponseEntity<>(body,
		 * HttpStatus.OK);
		 * 
		 */
	}


	@GetMapping("contacts")
	public ModelAndView getContact(ModelAndView view) {
		view.setViewName("contactus");
		return view;
	}

}
