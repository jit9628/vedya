package com.ecommarce.api.service;

import java.util.List;

import com.ecommarce.api.dto.StateDto;
import com.ecommarce.api.entity.State;

public interface StateService {
	public boolean addState(StateDto stateDto);
	public List<State> retrieveAllState();

}
