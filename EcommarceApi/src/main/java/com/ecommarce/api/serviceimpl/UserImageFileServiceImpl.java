package com.ecommarce.api.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommarce.api.dto.UserImageFileDto;
import com.ecommarce.api.entity.User;
import com.ecommarce.api.entity.UserImageFile;
import com.ecommarce.api.repo.UserImageFileRepository;
import com.ecommarce.api.repo.UserRepository;
import com.ecommarce.api.service.UserImageFileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserImageFileServiceImpl implements UserImageFileService {
	@Autowired
	private UserImageFileRepository fileRepository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean addUserImagePicture(UserImageFileDto userImageFileDto) {
		
		String imagepicture =null;
		// check user is available or not 
		

		User userData = this.userRepository.findById(userImageFileDto.getUid())
				.orElseThrow(() -> new UsernameNotFoundException("User Is Not Available"));
		
		// after dto convert into entity object 
		UserImageFile map = this.mapper.map(userImageFileDto, UserImageFile.class);
		
		
		
		map.setImagepicture(userImageFileDto.getImagepicture());
		map.setUid(userData);
		UserImageFile findByUid2 = this.fileRepository.findByUid(userData.getId());
		if(findByUid2==null ) {
			map.setUid(userData);
			map.setImagepicture(userImageFileDto.getImagepicture());
			 return (this.fileRepository.save(map) != null) ? true
						: false;	
		}else {
			 imagepicture = this.fileRepository.findByUid(userData.getId()).getImagepicture();		
				if(imagepicture != "" && imagepicture != null) {
				UserImageFile findByUid = this.fileRepository.findByUid(userData.getId());
				findByUid.setImagepicture(userImageFileDto.getImagepicture());
				findByUid.setUid(userData);
				this.fileRepository.save(findByUid);
					return true;
				}else {
					log.error("something went wrong");
				}
		}
		 return (this.fileRepository.save(map) != null) ? true
				: false;
	}

	@Override
	public String findImage(long id) {
		UserImageFile findByUid = this.fileRepository.findByUid(id);
		log.info("image file user :" + findByUid);
		return (findByUid != null) ? findByUid.getImagepicture() : null;
	}

}
