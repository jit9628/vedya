//package com.ecommarce.api.serviceimpl;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.ecommarce.api.dto.ProductOptionDto;
//import com.ecommarce.api.entity.OptionForGroups;
//import com.ecommarce.api.entity.ProductOption;
//import com.ecommarce.api.repo.OptionForGroupsRepository;
//import com.ecommarce.api.repo.ProductOptionRepository;
//import com.ecommarce.api.repo.ProductRepository;
//import com.ecommarce.api.service.ProductOptionService;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@AllArgsConstructor
//@Service
//@Slf4j
//
//public class ProductOptionServiceImpl implements ProductOptionService {
//	private ProductRepository productRepository;
//	private ProductOptionRepository productOptionRepository;
//	private OptionForGroupsRepository optionForGroupsRepository;
//	private ModelMapper mapper;
//
//	@Override
//	public boolean addMoreProductDetails(ProductOptionDto productOptionDto) {
//
//		try {
//			Optional<OptionForGroups> optionasdata = Optional
//					.of(this.optionForGroupsRepository.findById(1)
//							.orElseThrow(() -> new UsernameNotFoundException("Not Found Options")));
//			log.info("options details based on option id " + optionasdata.get().getOptionId());
//			OptionForGroups groupoptons = optionasdata.get();
//
//
//
//			ProductOption map = this.mapper.map(productOptionDto, ProductOption.class);
//			Set<OptionForGroups> setoptionobject = new HashSet<>();
//
////			setoptionobject.add(groupoptons);
////			map.setOptionids(setoptionobject);
//
//                ProductOption save = this.productOptionRepository.save(map);
//			log.info("return value save object is :: "+save);
//			if (save != null)
//				return true;
//			else
//				return false;
//
//		} catch (Exception e) {
//			return false;
//		}
//
//
//	}
//
//	@Override
//	public Optional<ProductOption> findProductDetailsById(long id) {
//		ProductOption productdetails = this.productOptionRepository.findById(id)
//				.orElseThrow(() -> new UsernameNotFoundException("Details Not Found"));
//		return Optional.of(productdetails);
//	}
//
//}
