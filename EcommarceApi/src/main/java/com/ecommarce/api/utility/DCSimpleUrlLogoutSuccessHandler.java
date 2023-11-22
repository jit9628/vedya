//package com.ecommarce.api.utility;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
//
//import com.dc.api.model.Users;
//import com.ecommarce.api.entity.User;
//
//public class DCSimpleUrlLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{
//
//    public void onLogoutSuccess(javax.servlet.http.HttpServletRequest request, 
//            javax.servlet.http.HttpServletResponse response,
//            Authentication authentication)
//     throws java.io.IOException,
//            javax.servlet.ServletException{
//    	User user=null;
//            Object principal = authentication.getPrincipal();
//            if (principal instanceof User) {
//            	
//            
//            }
//                user = (User) principal;
////                if(user.){
////                    response.sendRedirect("LogoutServlet");
////                }
////            }
//            response.sendRedirect("login.html");
//
////}