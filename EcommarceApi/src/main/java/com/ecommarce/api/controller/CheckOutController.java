package com.ecommarce.api.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommarce.api.dao.CityDto;
import com.ecommarce.api.service.CityService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController("/api/checkout/")
@AllArgsConstructor
@Slf4j
public class CheckOutController {
	private CityService cityService;

//	@PostMapping("createcity")
//	public ResponseEntity<?> addCity(@RequestBody CityDto cityDto) {
//		
//		if(cityDto.getCityname()==null || cityDto.getCityname()==""){
//			return new ResponseEntity<>(Map.of("message ", "please Fill city name ", "status", "200"), HttpStatus.OK);
//		}
//
//		boolean addState = this.cityService.addCity(cityDto);
//		if (addState)
//			return new ResponseEntity<>(Map.of("message ", "State created ", "status", "200"), HttpStatus.OK);
//		else
//			return new ResponseEntity<>(Map.of("message ", "can not add state", "status", "200"), HttpStatus.OK);
//	}

}
