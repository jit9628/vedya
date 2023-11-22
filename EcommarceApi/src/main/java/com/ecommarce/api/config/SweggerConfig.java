//package com.ecommarce.api.config;
//
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.google.common.base.Predicates;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SweggerConfig {
//
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfo("RecentTransaction REST API", "RecentTransaction using spring boot", "1.0",
//				"Terms of service",
//				new Contact("Jitendra Shukla", "http://www.androjavatech4u.com", "raypritam49000@gmail.com"),
//				"License of API", "API license URL", Collections.emptyList());
//	}
//}