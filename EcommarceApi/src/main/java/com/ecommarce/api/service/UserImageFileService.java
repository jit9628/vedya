package com.ecommarce.api.service;

import com.ecommarce.api.dto.UserImageFileDto;

public interface UserImageFileService {
	public boolean addUserImagePicture(UserImageFileDto userImageFileDto);

	public String findImage(long id);
}
