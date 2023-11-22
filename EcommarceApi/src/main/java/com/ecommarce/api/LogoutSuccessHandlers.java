package com.ecommarce.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.ecommarce.api.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class LogoutSuccessHandlers implements LogoutSuccessHandler {
	@Autowired
	private UserRepository userRepository;

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {


//		authentication.setAuthenticated(false);
		HttpSession session = request.getSession();
		log.info("active session is " + session);

		if (session != null) {
			SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
			SecurityContextHolder.getContextHolderStrategy().clearContext();
			session.invalidate();
			log.info("You Are Logger Out !Can't Access Any Operation ");
		}

//		//authentication.equals(authUser);
//	//	String userName = authUser.getUsername();
//	//	log.info("principal username ::" + userName);
//	//	Optional<User> findByUsername = this.userRepository.findByUsername(userName);
//		//log.info("findByUsername username ::" + findByUsername);

	}

}