//package com.ecommarce.api.security.jwt;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.GenericFilterBean;
////@Configuration
////public class CustomFilter  extends GenericFilterBean {
////
////	@Override
////	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
////			throws IOException, ServletException {
////		try {
////			HttpServletRequest req=(HttpServletRequest)request;
////			HttpServletResponse res=(HttpServletResponse)response;
////			Object attribute = req.getSession().getAttribute("userid");
////			
////			
////			
////		} catch (Exception e) {
////			
////		}
////		chain.doFilter(request, response);
////		
////	}
////}
