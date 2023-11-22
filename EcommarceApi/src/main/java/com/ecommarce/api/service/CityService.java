package com.ecommarce.api.service;

import java.util.List;

import com.ecommarce.api.dao.CityDto;
import com.ecommarce.api.entity.City;

public interface CityService {
public boolean addCity(CityDto cityDto);
public List<City> findCityByState(int id);

}
