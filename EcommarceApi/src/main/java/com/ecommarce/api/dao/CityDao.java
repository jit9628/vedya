package com.ecommarce.api.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ecommarce.api.entity.City;
import com.ecommarce.api.repo.CityRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CityDao {
	private CityRepository cityRepository;

	@Transactional
	public List<City> findCityByStateId(int id) {
		List<City> findByStateids = this.cityRepository.findByStateids(id);
		return (!findByStateids.isEmpty() && findByStateids != null) ? findByStateids : null;
	}
}
