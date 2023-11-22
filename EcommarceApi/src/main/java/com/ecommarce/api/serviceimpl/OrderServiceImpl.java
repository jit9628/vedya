package com.ecommarce.api.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommarce.api.dto.OrderDto;
import com.ecommarce.api.entity.Order;
import com.ecommarce.api.entity.Product;
import com.ecommarce.api.entity.User;
import com.ecommarce.api.repo.OrderRepository;
import com.ecommarce.api.repo.ProductRepository;
import com.ecommarce.api.repo.UserRepository;
import com.ecommarce.api.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	ModelMapper mapper;
	@Override
	public boolean createOrder(OrderDto orderDto) {
		  boolean status=false;
			try {
				Order productentity = this.mapper.map(orderDto, Order.class);

				Optional<User> findById = userRepository.findById(orderDto.getCustomer());
				Optional<Product> productFindById=productRepository.findById(orderDto.getProduct());

				if(!findById.isPresent()||!productFindById.isPresent())
			      return status;
//
				Set<User> setdata=new HashSet<User>();
				setdata.add(findById.get());
				Set<Product> setdata2=new HashSet<Product>();
				setdata2.add(productFindById.get());
				productentity.setCustomer(setdata);
				productentity.setProduct(setdata2);
				
			//productentity.setCustomer(Set.of(findById.get())); // set one object of customer  in order table
			//productentity.setProduct(Set.of(productFindById.get()));
				log.info("Execution Proccess Service Start "+productentity.getCustomer());
				this.orderRepository.save(productentity);
				log.info("Execution Proccess Service  End  ");
				status=true;
				return status;
			} catch (Exception e) {
				log.error("Service Error is " + e.getMessage());
			}
			return status;

	}
	@Override
	public List<Order> getAllOrder() {
		return this.orderRepository.findAll();
	}

}
