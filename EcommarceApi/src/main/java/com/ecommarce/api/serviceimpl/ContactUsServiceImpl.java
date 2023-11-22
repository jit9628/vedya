package com.ecommarce.api.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommarce.api.entity.ContactUs;
import com.ecommarce.api.repo.ContactUsRepository;
import com.ecommarce.api.service.ContactUsService;
@Service
public class ContactUsServiceImpl implements ContactUsService {
	@Autowired
	private ContactUsRepository contactUsRepository;

	@Override
	public boolean addContacts(ContactUs contactUs) {
		return (this.contactUsRepository.save(contactUs) instanceof ContactUs)?true:false;	
	}

}
