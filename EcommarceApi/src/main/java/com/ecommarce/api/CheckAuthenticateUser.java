package com.ecommarce.api;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CheckAuthenticateUser {
	private SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
	private SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder
			.getContextHolderStrategy();

	
//	user is authenticated or not 
	public int checkAuthenticatedIsTrue() {
		//log.isDebugEnabled();
		SecurityContext context = securityContextHolderStrategy.getContext();
		log.info("Security context Holder is :>"+context);
		Authentication authentication = context.getAuthentication();
	
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//
//		log.debug("authority is ::" + authorities);
//		boolean anyMatch = authentication.getAuthorities().stream().anyMatch(x->x.getAuthority().equals("ROLE_ADMIN"));
//		log.debug("Matches Value is  ::" + anyMatch);
//		boolean anyMatch1 = authentication.getAuthorities().stream().anyMatch(x->x.getAuthority().equals("ROLE_USER"));
//		log.debug("Matches1 Value is  ::" + anyMatch1);
		
//		if (authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
//		  log.info("You Aree Acceess All Modules");
//		}
//		
//		if (authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))) {
//			  log.info("You Aree Acceess User Modules");
//			}
		
		
		int checkAuthority = checkAuthority();
		log.debug(" CheckAuthority Value Is {}", checkAuthority);
		// return (authentication instanceof AnonymousAuthenticationToken) ?true: false;
		 return (authentication instanceof AnonymousAuthenticationToken) ?-1: checkAuthority;
	}

	
	
	
	
	
	
	
	/*====================== SET AUTHENTICATION SECURITY CONTEXT=======================*/
	public void setAuthenticationSecurityContext(Authentication authentication, HttpServletRequest request,
			HttpServletResponse response) {
		org.springframework.security.core.context.SecurityContext createEmptyContext = securityContextHolderStrategy
				.createEmptyContext();

		log.debug("Empty Context  is ::" + createEmptyContext);
		securityContextHolderStrategy.setContext(createEmptyContext);
		// set authentication instance 
		
		createEmptyContext.setAuthentication(authentication);
		
		log.debug("After Set Authentication ::" + createEmptyContext.getAuthentication());
		
		log.debug("Authenticate user1 is ::" + createEmptyContext.getAuthentication().getPrincipal());
		Authentication authentication2 = securityContextHolderStrategy.getContext().getAuthentication();
		log.debug("Authenticate user2 is ::" + authentication2.getPrincipal());
		securityContextRepository.saveContext(createEmptyContext, request, response);

	}
	

	// check authority 
	public int checkAuthority() {
		SecurityContext context = securityContextHolderStrategy.getContext();
		Authentication authentication = context.getAuthentication();
		boolean anyMatch = authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER") || a.getAuthority().equals("ROLE_ADMIN"));
		log.debug("Check Authority Is :: "+ anyMatch);
		return (anyMatch)?1:0;
	}
	
	
	public String chekRole() {
		SecurityContext context = securityContextHolderStrategy.getContext();
		Authentication authentication = context.getAuthentication();
		List<String> map = authentication.getAuthorities().stream().map(item->item.getAuthority()).toList();
		//List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority());
	
if(map.get(0)== "ROLE_ADMIN") {
	return "admin";
}
		if(map.get(0) == "ROLE_USER") {
			return "user";
		}
		return null;
	}
	
	
	
//	public boolean checkAuthorities() {
//		SecurityContext context = securityContextHolderStrategy.getContext();
//		Authentication authentication = context.getAuthentication();
//		boolean anyMatch = authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER") || a.getAuthority().equals("ROLE_ADMIN"));
//		log.debug("%s", anyMatch);
//		return anyMatch;
//	}
	
	
	
}
