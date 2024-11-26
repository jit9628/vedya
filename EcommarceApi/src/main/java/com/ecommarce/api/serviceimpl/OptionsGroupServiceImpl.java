//package com.ecommarce.api.serviceimpl;
//
//import java.util.Optional;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.ecommarce.api.dto.OptionsGroupDto;
//import com.ecommarce.api.entity.OptionsGroup;
//import com.ecommarce.api.repo.OptionsGroupRepository;
//import com.ecommarce.api.service.OptionsGroupService;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@AllArgsConstructor
//@Service
//public class OptionsGroupServiceImpl implements OptionsGroupService {
//
//	private OptionsGroupRepository groupRepository;
//	private ModelMapper mapper;
//
//	@Override
//	public boolean addOptionGroups(OptionsGroupDto optionGroupDto) {
//		boolean result = false;
//
//		OptionsGroup optionsGroupentity = mapper.map(optionGroupDto, OptionsGroup.class);
//		OptionsGroup save = this.groupRepository.save(optionsGroupentity);
//		if (save != null) {
//			result = true;
//			return result;
//		} else {
//			return result;
//		}
//
//		// TODO Auto-generated method stub
//
//	}
//
//
//	@Override
//	public Optional<OptionsGroup> findByGroupId(int id) {
// 		OptionsGroup groupdetails = this.groupRepository.findById(id).orElseThrow((()->new UsernameNotFoundException("Group Not Found")));
//		return Optional.of(groupdetails);
//	}
//
//}
