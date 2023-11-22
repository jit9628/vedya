package com.ecommarce.api.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j

public class CustomHandler {


	public void logout(HttpServletRequest request, HttpServletResponse response,
	        Authentication authentication) {
	    Assert.notNull(request, "HttpServletRequest required");
	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            //logger.debug("Invalidating session: " + session.getId());
	            session.invalidate();
	        }

//
//	    if (clearAuthentication) {
//	        SecurityContext context = SecurityContextHolder.getContext();
//	        context.setAuthentication(null);
//	    }

	    //SecurityContextHolder.clearContext();
	}

}
