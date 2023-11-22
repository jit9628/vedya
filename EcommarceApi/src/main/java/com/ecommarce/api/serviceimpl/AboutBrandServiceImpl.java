package com.ecommarce.api.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommarce.api.entity.AboutBrand;
import com.ecommarce.api.repo.AboutBrandRepository;
import com.ecommarce.api.service.AboutBrandService;

@Service
public class AboutBrandServiceImpl implements AboutBrandService {
	
	@Autowired
	private AboutBrandRepository aboutBrandRepository;

	@Override
	public boolean addBrand(AboutBrand aboutBrand) {
		return (this.aboutBrandRepository.save(aboutBrand) instanceof AboutBrand)?true:false;
	}

}
