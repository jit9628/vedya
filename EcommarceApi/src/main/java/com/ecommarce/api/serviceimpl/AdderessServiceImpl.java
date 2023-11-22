package com.ecommarce.api.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommarce.api.dao.AdderessDao;
import com.ecommarce.api.dto.AdderessDto;
import com.ecommarce.api.entity.Adderess;
import com.ecommarce.api.entity.User;
import com.ecommarce.api.repo.AdderessRepository;
import com.ecommarce.api.repo.UserRepository;
import com.ecommarce.api.service.AdderessService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class AdderessServiceImpl implements AdderessService {
	ModelMapper mapper;
	private UserRepository userRepository;
	private AdderessRepository adderessRepository;
	@Autowired
	private AdderessDao dao;

	@Override
	public boolean addAdderess(AdderessDto adderessDto) {
//		check adderess is exists or not 
		String accountOfPrimary = "Primary-Account";
		String accountOfDefault = "Default-Account";
		System.out.println("Exists Email Id Are :: "+adderessDto.getEmail());
		boolean existByEmail = this.adderessRepository.existsByEmail(adderessDto.getEmail());
		boolean existsByUserEmail = this.userRepository.existsByEmail(adderessDto.getEmail());
		log.info("user is exists or not ::" + existsByUserEmail);
		List<Adderess> findByEmail = this.adderessRepository.findByEmail(adderessDto.getEmail());
		User user = this.userRepository.findById(adderessDto.getUseradr()).get();
		Adderess adderessEntity = mapper.map(adderessDto, Adderess.class);
//		check provide email by user is exists or not 
		// if user not exists then check provide email id is exists adderess class or
		// not
		// if it is provide thean update adderess can't save new adderess
		// if it 's not exists save new adderess default account
		if (existsByUserEmail) // true
		{
			log.info("Step one is True ......");
			if (!existByEmail) // true
			{
				log.info("Step Two is False ......");
				adderessEntity.setUseradr(user);
				adderessEntity.setAccounttype(accountOfPrimary);
				this.adderessRepository.save(adderessEntity);
				return true;
			}
			return false;
		}
		else {
			log.info("Step One is False ......");
			if (!existByEmail) // true
			{
			
				adderessEntity.setUseradr(user);
				adderessEntity.setAccounttype(accountOfDefault); // save adderess
				this.adderessRepository.save(adderessEntity);
 return true;
			}
			
//			else {
//				
//			}

		}

		
	//	this.adderessRepository.save(adderessEntity);
		return false;
		/*
		 * 
		 * if(existByEmail) {
		 * 
		 * 
		 * 
		 * // check accounttype // boolean existByEmail =
		 * this.adderessRepository.existsByEmail(adderessDto.getEmail()); List<Adderess>
		 * findByUseradr =
		 * this.adderessRepository.findByUseradr(adderessDto.getUseradr()); String
		 * accounttype = findByUseradr.get(0).getAccounttype();
		 * System.out.print(accounttype);
		 * 
		 * if(accounttype!=null) {
		 * 
		 * 
		 * User user = this.userRepository.findById(adderessDto.getUseradr()).get();
		 * Adderess adderessEntity = mapper.map(adderessDto, Adderess.class);
		 * adderessEntity.setUseradr(user);
		 * adderessEntity.setAccounttype("Default Account"); // save adderess
		 * this.adderessRepository.save(adderessEntity); } } else {
		 * 
		 * 
		 * User user = this.userRepository.findById(adderessDto.getUseradr()).get();
		 * Adderess adderessEntity = mapper.map(adderessDto, Adderess.class); //
		 * adderessEntity.setUseradr(EXISTINGUSER);
		 * adderessEntity.setAccounttype("Primary Account");
		 * adderessEntity.setUseradr(user); // save adderess
		 * this.adderessRepository.save(adderessEntity); }
		 */
	}

	@Override
	public Optional<Adderess> findAdderessDetailsById(int id) {
		Adderess adderessEntity = this.adderessRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Adderess Not Found"));

		return Optional.of(adderessEntity);
	}

	@Override
	public List<Adderess> getAdderessByUser(long user) {
		List<Adderess> findByUseradr = this.adderessRepository.findByUseradr(user);
		return findByUseradr;
	}

	@Override
	public void deleteAdderessById(int id) {

		try {
			this.dao.deleteAdderess(id);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public boolean updateAddress(int id, AdderessDto adderessDto) {
	 Adderess adderess = this.adderessRepository.findById(id).get();
	 adderess.setFirstname(adderessDto.getFirstname());
	 adderess.setLastname(adderessDto.getLastname());
	 adderess.setEmail(adderessDto.getEmail());
	 adderess.setLocaladderess(adderessDto.getLocaladderess());
	 adderess.setCity(adderessDto.getCity());
	 adderess.setCountry(adderessDto.getCountry());
	 adderess.setAdditionalinfo(adderessDto.getAdditionalinfo());
	 adderess.setPostalcode(adderessDto.getPostalcode());
	 adderess.setMobilenumber(adderessDto.getMobilenumber());
	 adderess.setAccounttype(adderess.getAccounttype());
	 adderess.setUseradr(adderess.getUseradr());
	 
// AdderessDto map = this.mapper.map(adderess,AdderessDto.class);
//	 map.setAccounttype(adderess.getAccounttype());
//	 map.setUseradr(adderess.getUseradr());
		Adderess save = this.adderessRepository.save(adderess);
		if(save instanceof Adderess)
			return true;
		return false;
	}

//	public boolean removeAddressFromUserIdAndAddressId(String email, int id) {
//		//this.adderessRepository.deleteByIdAndUseradr(id, userid);
//this.adderessRepository.deleteByEmailAndId(email, id);
//		return true;
//	}

}
