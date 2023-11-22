package com.ecommarce.api.service;

import java.util.List;
import java.util.Optional;

import com.ecommarce.api.dto.AdderessDto;
import com.ecommarce.api.entity.Adderess;

public interface AdderessService {

	public boolean addAdderess(AdderessDto adderessDto);

	public Optional<Adderess> findAdderessDetailsById(int id);
	public List<Adderess> getAdderessByUser(long user);
	public void deleteAdderessById(int id);
	
public boolean updateAddress(int id,AdderessDto adderessDto);

}