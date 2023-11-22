package com.ecommarce.api.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.ecommarce.api.dao.ProductDao;
import com.ecommarce.api.dto.ProductDto;
import com.ecommarce.api.entity.Category;
import com.ecommarce.api.entity.Product;
import com.ecommarce.api.repo.AddToCartRepository;
import com.ecommarce.api.repo.CategoryRepository;
import com.ecommarce.api.repo.ProductOptionRepository;
import com.ecommarce.api.repo.ProductRepository;
import com.ecommarce.api.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private CategoryRepository categoryRepository;

	private ProductRepository productRepository;

	// autowired dao and dao directly use repository '
	private AddToCartRepository addToCartRepository;
	ProductDao productDao;
	ModelMapper mapper;
	private ProductOptionRepository productOptionRepository;

	@Override
	public boolean addProduct(ProductDto productDto) {
		// cheeck product is exists or not
		boolean status = false;
		try {
			Product findByProductName = this.productDao.findByProductName(productDto.getProductname());
			if (findByProductName != null) {
				return status;
			}
			log.info("product value:" + findByProductName);
			Product productentity = this.mapper.map(productDto, Product.class);
			Optional<Category> category = categoryRepository.findById(productDto.getCatname());
			if (!category.isPresent())
				return status;
			productentity.setCategory(categoryRepository.findById(productDto.getCatname()).get()); // set one object of
																									// // product table
			log.info("Execution Proccess Service Start ");
			try {
				log.info("list of image is :" + productDto.getFiles());
			} catch (Exception e) {
				e.getMessage();
			}

			Product save = this.productRepository.save(productentity);
			if (save != null) {
				log.info("Execution Proccess Service  End  ");
				status = true;
				return status;

			} else {
				status = false;
				return status;
			}

		} catch (Exception e) {
			log.error("Service Error is " + e.getMessage());
		}
		return status;
	}

	@Override
	public List<Product> getAllProduct() {
		try {
			List<Product> findAll = this.productRepository.findAll();
			if (findAll.isEmpty()) {
				return null;
			}

			log.info("All List" + findAll);
			return findAll;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean deleteProduct(int id) {
		try {
			this.productRepository.deleteById(id);
			return true;
		} catch (Exception e) {

			log.info("Exception After press deleting button :)" + e.getMessage());
		}
		this.productRepository.deleteById(id);
		return true;
	}

	@Override
	public Product findProductByName(String productname) {
		log.debug(productname);

		return this.productRepository.findByproductname(productname);

		// .findByProductName(productname);

	}

	@Override
	public List<Product> getProductByCategory() {
		return null;

	}

	@Override
	public Optional<Product> findProductById(int id) {

		Optional<Product> findById = this.productRepository.findById(id);
		log.info("Product is ::" + findById.get().getPrice());

		return this.productRepository.findById(id);
	}

	@Override
	public long totalProducts() {
		long count = this.productRepository.count();
		log.info("total products " + count);
		return count;
	}

	@Override
	public boolean updateProduct(ProductDto dto, int pid) {
		try {
			Optional<Product> findById = this.productRepository.findById(pid);
			if (findById.isPresent()) {
				Product product = findById.get();
				Optional<Category> category = categoryRepository.findById(dto.getCatname());
				Category category2 = category.get();
				product.setProductname(dto.getProductname());
				product.setPrice(dto.getPrice());
				product.setCategory(category2);
				product.setDiscription(dto.getDiscription());
				product.setSku(dto.getSku());
				product.setStocks(dto.getStocks());
				ArrayList<String> files = dto.getFiles();
				String string = files.toString();
				log.info("Save Image Service Side DataBase :" + string);
				product.setFiles(string);
				ProductDto map = mapper.map(product, ProductDto.class);
			//	map.setFiles(dto.getFiles());
				map.setFiles(files);
				map.setCatname(category2.getCatid());
				Product map2 = mapper.map(map, Product.class);
				map2.setCategory(category2);
				this.productRepository.save(map2);
				return true;
				// this.productRepository.save(product);
			} else {
				return false;
			}
		} catch (Exception e) {
			log.info("Exception Generated :" + e.getMessage());
		}

		return false;

	}

	@Override
	public List<Product> findProductByCategorId(long catid) {
		List<Product> findByCategory = this.productDao.findByCategory(catid);
		return findByCategory;
	}

	@Override
	public List<Product> filterProductByPrice(long priceone,long pricetwo) {
		List<Product> filterdProduct = this.productDao.filterdProduct(priceone,pricetwo);
		return filterdProduct;
	}

}
