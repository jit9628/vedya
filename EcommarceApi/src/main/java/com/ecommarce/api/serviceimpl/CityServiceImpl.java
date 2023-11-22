package com.ecommarce.api.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommarce.api.dao.CityDao;
import com.ecommarce.api.dao.CityDto;
import com.ecommarce.api.entity.City;
import com.ecommarce.api.entity.State;
import com.ecommarce.api.repo.CityRepository;
import com.ecommarce.api.repo.StateRepository;
import com.ecommarce.api.service.CityService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CityServiceImpl implements CityService {

	private StateRepository stateRepository;
	private CityRepository cityRepository;
	private CityDao cityDao;
	private ModelMapper mapper;

	@Override
	public boolean addCity(CityDto cityDto) {
		State statedata = this.stateRepository.findById(cityDto.getStateids())
				.orElseThrow(() -> new UsernameNotFoundException("Details Not Found"));

		// convrt dto to entity
		City cityObject = this.mapper.map(cityDto, City.class);
		cityObject.setStateids(statedata);
		City save = this.cityRepository.save(cityObject);
		if (save != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<City> findCityByState(int id) {
		List<City> findCityByStateId = this.cityDao.findCityByStateId(id);
		return (!findCityByStateId.isEmpty() && findCityByStateId != null) ? findCityByStateId : null;

	}

}
