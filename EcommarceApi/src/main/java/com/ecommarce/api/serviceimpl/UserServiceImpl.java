package com.ecommarce.api.serviceimpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommarce.api.entity.EmailDetails;
import com.ecommarce.api.entity.User;
import com.ecommarce.api.repo.UserRepository;
import com.ecommarce.api.service.EmailService;
import com.ecommarce.api.service.UserService;
import com.ecommarce.api.utility.RandomStringValue;
import java.time.*;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RandomStringValue rendomtoken;
	@Autowired
	private PasswordEncoder encoder;
	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 10;
	@Autowired
	private EmailService emailService;
	@Autowired
	private EmailDetails details;
	@Override
	public User getAllUser() {

		return (User) this.userRepository.findAll();
	}

	@Override
	public String forgotPassword(String email) {
		Optional<User> findByEmail = this.userRepository.findByEmail(email);
		if (!findByEmail.isPresent()) {
			return "Invalid email id.";
		}
		String sendOtp = sendEmail(email);
		
		
		
		User user = findByEmail.get();
		user.setToken(rendomtoken.generateToken());
		user.setTokancreationdate(LocalDateTime.now());
		user.setOtpverifier(sendOtp);
		user = userRepository.save(user);
		return user.getOtpverifier();
		//return user.getToken();

	}

	@Override
	public String resetPassword(String Otp, String password) {

		Optional<User> findByEmail = this.userRepository.findByOtpverifier(Otp);
		if (!findByEmail.isPresent()) {
			return "Invalid Otp";
		}

		LocalDateTime tokenCreationDate = findByEmail.get().getTokancreationdate();

		if (isTokenExpired(tokenCreationDate)) {
			return "Token expired.";

		}

		User user = findByEmail.get();
		String encode = encoder.encode(password);
		user.setPassword(encode);
		user.setToken(null);
		user.setTokancreationdate(null);
		user.setOtpverifier(null);
		userRepository.save(user);
		return "Your password successfully updated.";
	}
//	@Override
//	public String resetPassword(String token, String password) {
//
//		Optional<User> findByEmail = this.userRepository.findByToken(token);
//		if (!findByEmail.isPresent()) {
//			return "Invalid token.";
//		}
//
//		LocalDateTime tokenCreationDate = findByEmail.get().getTokancreationdate();
//
//		if (isTokenExpired(tokenCreationDate)) {
//			return "Token expired.";
//
//		}
//
//		User user = findByEmail.get();
//		String encode = encoder.encode(password);
//		user.setPassword(encode);
//		user.setToken(null);
//		user.setTokancreationdate(null);
//		userRepository.save(user);
//		return "Your password successfully updated.";
//	}

	private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

		LocalDateTime now = LocalDateTime.now();
		java.time.Duration between = java.time.Duration.between(tokenCreationDate, now);
		System.out.println("Time Difference is : " + between);
		return between.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
	}

	
	 
	
	private String sendEmail(String Email) {
		String randomnumber = "";
		randomnumber = RandomStringValue.getRandomNumber();
		details.setRecipient(this.userRepository.findByEmail(Email).get().getEmail());
		details.setMsgBody(randomnumber);
		details.setSubject("Reset Password Otp");
		
		String sendSimpleMail = emailService.sendSimpleMail(details);
		
		return randomnumber;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * public String resetPassword(String token, String password) {
	 * 
	 * Optional<User> userOptional = Optional
	 * .ofNullable(userRepository.findByToken(token));
	 * 
	 * if (!userOptional.isPresent()) { return "Invalid token."; }
	 * 
	 * LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();
	 * 
	 * if (isTokenExpired(tokenCreationDate)) { return "Token expired.";
	 * 
	 * }
	 * 
	 * User user = userOptional.get();
	 * 
	 * user.setPassword(password); user.setToken(null);
	 * user.setTokenCreationDate(null);
	 * 
	 * userRepository.save(user);
	 * 
	 * return "Your password successfully updated."; }
	 */

}
