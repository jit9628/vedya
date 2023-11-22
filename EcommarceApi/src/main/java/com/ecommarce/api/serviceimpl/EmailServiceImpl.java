package com.ecommarce.api.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ecommarce.api.entity.EmailDetails;
import com.ecommarce.api.service.EmailService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender ;
	
	@Override
	public String sendSimpleMail(EmailDetails details) {
		// Try block to check for exceptions
		try {
			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			// Setting up necessary details
			mailMessage.setFrom("softwaree831@gmail.com");
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());
			
			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully...";
		}
		// Catch block to handle the exceptions
		catch (Exception e) {
			return "Error while Sending Mail" + e.getMessage();
		}
	}
	@Override
	public String sendMailWithAttachment(EmailDetails details) {
		return null;
		
	}
}
