package com.ecommarce.api.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommarce.api.dao.OptionForGroupsDao;
import com.ecommarce.api.dto.OptionForGroupsDto;
import com.ecommarce.api.entity.OptionForGroups;
import com.ecommarce.api.entity.OptionsGroup;
import com.ecommarce.api.repo.OptionForGroupsRepository;
import com.ecommarce.api.repo.OptionsGroupRepository;
import com.ecommarce.api.service.OptionForGroupsService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class OptionForGroupsServiceImpl implements OptionForGroupsService {
	/*=============== DEPENDECY INJECTION CONSTRUCTOR INJECTION====================*/
	private OptionsGroupRepository optionsGroupRepository;
	private OptionForGroupsRepository optionForGroupsRepository;
	private OptionForGroupsDao optionForGroupsDao;
	private ModelMapper mapper;
	@Override
	public boolean addGroupOption(OptionForGroupsDto optionForGroupsDto) {
		// get group object
		OptionsGroup optionGroupEntity = this.optionsGroupRepository.findById(optionForGroupsDto.getGrouped())
				.orElseThrow(() -> new UsernameNotFoundException("Group Not Found "));

//		Set<OptionsGroup> optgroup=new HashSet<OptionsGroup>();
//		optgroup.add(optionGroupEntity)



		optionForGroupsDto.setGrouped(optionGroupEntity.getId());
		OptionForGroups optiongroup = this.mapper.map(optionForGroupsDto, OptionForGroups.class);
		optiongroup.setGrouped(optionGroupEntity);
		OptionForGroups save = this.optionForGroupsRepository.save(optiongroup);
		return false;


	}

	/*============== FIND OPTIONS BY GROUP ID  LIKE GROUP ID IS ONE ALL OPTIONS FETCH GROUP */


	@Override
	public Optional<OptionForGroups> findoptionByGroupId(int id) {

		OptionForGroups groupoptiondetails = this.optionForGroupsRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("Group Id Not Found"));
		return Optional.of(groupoptiondetails);
	}
	/*====== RETRIEVE ALL OPTIONS ===========*/
	@Override
	public List<OptionForGroups> findAllOptionsGroup() {
		return this.optionForGroupsRepository.findAll();
	}

	/*================ FIND GROUP NAME FROM GROUPID==================*/
	@Override
	public OptionForGroups findgroupnameByGroupId() {


	//this.optionForGroupsRepository.findByGrouped(grups);
		return null;
	}

	@Override
	public List<OptionForGroups> getAllOptionFromGroupId(int id) {

		//use dao layer
		List<OptionForGroups> findByGroupId = this.optionForGroupsDao.findByGroupId(id);
		//List<OptionForGroups> findByGrouped = this.optionForGroupsRepository.findByGrouped();
		log.info("List of Value :: "+findByGroupId.get(0).getOptionname());
		return findByGroupId;
	}

}
