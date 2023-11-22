package com.ecommarce.api.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ecommarce.api.dto.StateDto;
import com.ecommarce.api.entity.State;
import com.ecommarce.api.repo.StateRepository;
import com.ecommarce.api.service.StateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StateServiceImpl implements StateService {
private StateRepository repository;
private ModelMapper mapper;
	@Override
	public boolean addState(StateDto stateDto) {
		
		List<State> findByStatename = this.repository.findByStatename(stateDto.getStatename());
		if (!findByStatename.isEmpty()) {
			return false;
		}
		State save = this.repository.save(this.mapper.map(stateDto, State.class));
		
		if(save!=null)
		return true;
		else
		return false;
	}
	@Override
	public List<State> retrieveAllState() {
		List<State> findAll = this.repository.findAll();
		return (!findAll.isEmpty())? findAll:null;
	}






}
