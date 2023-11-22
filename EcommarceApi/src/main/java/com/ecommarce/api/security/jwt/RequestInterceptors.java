/*
 * package com.ecommarce.api.security.jwt;
 * 
 * import org.springframework.stereotype.Component; import
 * org.springframework.web.context.request.RequestContextHolder; import
 * org.springframework.web.context.request.ServletRequestAttributes; import
 * org.springframework.web.servlet.HandlerInterceptor;
 * 
 * @Component public class RequestInterceptors implements HandlerInterceptor {
 * 
 * private static final String AUTHORIZATION_HEADER = "Authorization";
 * 
 * public static String getBearerTokenHeader() { return
 * ((ServletRequestAttributes)
 * RequestContextHolder.getRequestAttributes()).getRequest().getHeader(
 * "Authorization"); }
 * 
 * @Override public void apply(RequestTemplate requestTemplate) {
 * 
 * requestTemplate.header(AUTHORIZATION_HEADER, getBearerTokenHeader());
 * 
 * } }
 */