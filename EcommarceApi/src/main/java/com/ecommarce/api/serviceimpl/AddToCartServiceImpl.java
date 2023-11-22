package com.ecommarce.api.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ecommarce.api.dao.AddToCartDao;
import com.ecommarce.api.dto.AddToCartDto;
import com.ecommarce.api.entity.AddToCart;
import com.ecommarce.api.entity.Product;
import com.ecommarce.api.entity.User;
import com.ecommarce.api.repo.AddToCartRepository;
import com.ecommarce.api.repo.ProductRepository;
import com.ecommarce.api.repo.UserRepository;
import com.ecommarce.api.service.AddToCartService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@AllArgsConstructor
public class AddToCartServiceImpl implements AddToCartService {
	private AddToCartRepository addToCartRepository;
	private ProductRepository productRepository;
	private UserRepository userRepository;
	private ModelMapper mapper;
	private AddToCartDao addToCartDao;

	@Override
	public int addProductToCart(AddToCartDto addToCartDto) {
		
		
		

		Optional<Product> findById = this.productRepository.findById(addToCartDto.getProducts());
Optional<User> findById2 = this.userRepository.findById(addToCartDto.getUsersid());
log.info("User Details is :"+findById2);
		if(findById.empty()!=null  &&  findById2.empty()!=null) {
			Product product = findById.get();
			User user = findById2.get();
			AddToCart map = this.mapper.map(addToCartDto, AddToCart.class);
			map.setProducts(product);
			map.setUsers(user);
			map.setColor(addToCartDto.getColor());
			map.setSize(addToCartDto.getSize());
			/*=== check product is exists or not in add to cart table======= */
			
			int existsByUsersAndProducts = this.addToCartRepository.existsByUsersAndProducts(user.getId(),product.getPid());
			if(existsByUsersAndProducts==0) {
				log.info("Product not exists...");
				AddToCart save = this.addToCartRepository.save(map);
				if(save!=null)
					return 1;
				else
					return 0;
			}
			else {
				log.info("Product not exists...");
				log.info("product is exists or not inside add to cart table this userid"+existsByUsersAndProducts);
				return -1;	
			}
		
			
		}
		return 0;
	}

	@Override
	public List<AddToCart> getpProductFromCart() {
	
		
		
		List<AddToCart> findAll = this.addToCartRepository.findAll();
		if(!findAll.isEmpty())
		return findAll;
		return null;
	}

	@Override
	public List<AddToCart> findCartDetailBasedOnUserId(long id) {
		try {
			List<AddToCart> findByUsers = this.addToCartDao.findByUsers(id);
return findByUsers;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean removecartproduct(int id,long userid) {
	
		this.addToCartDao.removeByProductId( id, userid);
		return true;
	}
	@Override
	public boolean removeProductFromCart(int id) {
		try {
			int existsByProducts = this.addToCartRepository.existsByProducts(id);
			
//			check content is exists or  not 
		if(existsByProducts>0) {
			
			this.addToCartDao.removeAddToCartFromProductId(id);
			return true;
		}
			return false;
			
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public int countAddToCartProductBasedOnUser(long id) {
		int existsByUsers = this.addToCartRepository.existsByUsers(id);
		log.info("total number of product specific user add to cart "+existsByUsers);
		return existsByUsers;
	}

	@Override
	public List<AddToCart> getCategoryDetildFromUser(long id) {
	List<AddToCart> findByUsers = this.addToCartDao.findByUsers(id);

		return findByUsers;
	}

}
