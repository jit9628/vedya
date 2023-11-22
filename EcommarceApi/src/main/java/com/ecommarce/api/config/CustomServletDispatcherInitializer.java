/*
 * package com.ecommarce.api.config;
 * 
 * import org.springframework.web.servlet.support.
 * AbstractAnnotationConfigDispatcherServletInitializer;
 * 
 * 
 * public class CustomServletDispatcherInitializer extends
 * AbstractAnnotationConfigDispatcherServletInitializer{
 * 
 * @Override protected Class<?>[] getRootConfigClasses() {
 * 
 * return new Class[] {WebInitializer.class}; }
 * 
 * @Override protected Class<?>[] getServletConfigClasses() { // TODO
 * Auto-generated method stub return new Class[]
 * {MyServletDispatcherConfiguration.class}; }
 * 
 * @Override protected String[] getServletMappings() { // TODO Auto-generated
 * method stub return new String[] {"/ecommarce/*"}; }
 * 
 * // Adding mapping URL
 * 
 * @Override protected String[] getServletMappings() { String arr[] = {
 * "/ecommarce/*" }; return arr; }
 * 
 * 
 * 
 * }
 */