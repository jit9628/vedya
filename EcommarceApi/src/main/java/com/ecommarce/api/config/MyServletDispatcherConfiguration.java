/*
 * package com.ecommarce.api.config; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.multipart.MultipartResolver; import
 * org.springframework.web.multipart.support.StandardServletMultipartResolver;
 * import org.springframework.web.servlet.ViewResolver; import
 * org.springframework.web.servlet.config.annotation.EnableWebMvc; import
 * org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
 * import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 * import org.springframework.web.servlet.view.InternalResourceViewResolver;
 * 
 * @Configuration
 * 
 * @EnableWebMvc
 * 
 * @ComponentScan(basePackages = "com.ecommarce.api") public class
 * MyServletDispatcherConfiguration implements WebMvcConfigurer
 * 
 * {
 * 
 * @Bean public ViewResolver configureViewResolver() {
 * InternalResourceViewResolver viewResolve = new
 * InternalResourceViewResolver();
 * System.out.println("Internal ViewResolver "+viewResolve);
 * viewResolve.setPrefix("/WEB-INF/view/"); //
 * viewResolve.setPrefix("/WEB-INF/classes/"); viewResolve.setSuffix(".jsp");
 * return viewResolve; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @Bean public ViewResolver viewResolver() { InternalResourceViewResolver
 * resolver = new InternalResourceViewResolver();
 * resolver.setPrefix("/WEB-INF/view/"); resolver.setSuffix(".jsp");
 * 
 * resolver.setExposeContextBeansAsAttributes(true); return resolver;
 * 
 * }
 * 
 * 
 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
 * registry.addResourceHandler("/resources/**").addResourceLocations(
 * "/resources/"); }
 * 
 * @Bean public MultipartResolver multipartResolver() { return new
 * StandardServletMultipartResolver(); }
 * 
 * 
 * 
 * @Bean public MultipartConfigElement multipartConfigElement() { return new
 * MultipartConfigElement(""); }
 * 
 * 
 * // @Bean // @ConditionalOnMissingBean // public CommonsMultipartResolver
 * multipartResolver(){ // CommonsMultipartResolver commonsMultipartResolver =
 * new CommonsMultipartResolver(); //
 * commonsMultipartResolver.setDefaultEncoding("utf-8"); //
 * commonsMultipartResolver.setMaxUploadSize(50000000); // return
 * commonsMultipartResolver; // }
 * 
 * 
 * 
 * 
 * // context loader listener
 * 
 * 
 * @Bean public ServletContextInitializer servletContextInitializer() { return
 * servletContext -> { // Create and configure your custom ContextLoaderListener
 * here ContextLoaderListener contextLoaderListener = new
 * ContextLoaderListener(); // Customize the contextLoaderListener if needed
 * System.out.println("ContextLoaderListener Is :"+contextLoaderListener);
 * servletContext.addListener(contextLoaderListener); }; }
 * 
 * 
 * 
 * 
 * }
 * 
 * 
 */