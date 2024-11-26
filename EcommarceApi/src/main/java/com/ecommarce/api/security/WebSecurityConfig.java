package com.ecommarce.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ecommarce.api.security.jwt.AuthEntryPointJwt;
import com.ecommarce.api.security.jwt.AuthTokenFilter;
import com.ecommarce.api.security.jwt.CacheControlFilter;
import com.ecommarce.api.service.UserDetailsServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Configuration
//@EnableGlobalMethodSecurity(
//		// securedEnabled = true,
//		// jsr250Enabled = true,
//		prePostEnabled = true)
@EnableMethodSecurity(prePostEnabled = true)
@EnableWebSecurity

public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	CacheControlFilter cachecontrolfilter;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	 AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

//  @Override
//  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//  }
	@Bean
	 DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

//  @Bean
//  @Override
//  public AuthenticationManager authenticationManagerBean() throws Exception {
//    return super.authenticationManagerBean();
//  }

	@Bean
	 AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	 PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.cors().and().csrf().disable()
//      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//      .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//      .antMatchers("/api/test/**").permitAll()
//      .anyRequest().authenticated();
//
//    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//  }

	@Bean
	 SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/details").access("hasRole('ROLE_USER')")
//		.and()
//			.formLogin().loginPage("/")
//			.defaultSuccessUrl("/details")
//			.failureUrl("/loginPage?error")
//			.usernameParameter("username").passwordParameter("password")				
//		.and()
//			.logout().logoutUrl("/logout").logoutSuccessUrl("/api/page/LogIn"); 
//		"/api/test/**",
//		return http.build();
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and().authorizeRequests()
				.antMatchers("api/admin/Add-New-Category").permitAll()
				// .antMatchers("/EcommarceApi").permitAll()
				.antMatchers("/api/auth/signin", "/api/test/reset-password","/api/auth/login","/api/page/userindex", "/api/auth/logout", "/api/auth/ad","/api/user/deleteAddress/**","/api/page/specificProduct/**","/api/page/order-delivered-details","/api/page/order-dispatch-details","/api/page/testfile","/api/test/allOrderLists/**","/api/test/dispatchDetails/**","/api/page/orderdetails","/api/page/updateAddress/**","/api/test/orderstatus/**","/api/test/getFilterDatas/**").permitAll()
				.antMatchers("/api/auth/signup").permitAll().antMatchers("/api/group/FindAllOptions").permitAll()
				.antMatchers("/").permitAll().antMatchers("/api/auth/admindashboard").permitAll()
				.antMatchers("/api/auth/userdashboard").permitAll().antMatchers("/api/booking/text").permitAll()
				.antMatchers("/api/page/ProductPage","/api/test/categorypage/**").permitAll()
				.antMatchers("/api/test/category/list", "/api/test/add/category", "/api/test/categoryRemoveById/**","/api/test/editAddress/**","/api/test/verifiy-otp/**","/api/test/categoryupdate/**",
						"/api/test//deleteproduct/**", "/api/test/deleteproduct/**", "/api/test/update-product/**",
						"/api/test/update-product/**", "/api/page/All-Products","/api/page/contacts", "/api/test/product/**","/api/test/product/excel","/api/test/getProductByCategorId/**","/api/page/Product-dtls","/api/page/searchdata","/api/page/Product-dtl-usr","/api/user/cancelorder/**","/api/usr/filterPrice/**"
						,"/api/test/ProductUpdate", "/api/test/remodeproductfromcart/**", "/api/test/jitu",
						"/api/test/check-out", "/api/test/categoryLists", "/api/test/search-product/**", "/api/user/bookproduct/**","/api/user/getintouch","/api/user/touch","/api/test/addtocartproducts/**","/api/page/indexpage-Product-dtls","/api/page/exportToExcel")
				.permitAll()
				// .hasRole("ADMIN")
				.antMatchers("/api/admin/order-listdata").permitAll()
				// .antMatchers("/EcommarceApi/**").permitAll()
				.antMatchers("/api/user/my-order","/api/admin/aboutbrand","/api/admin/invoices-logs","/api/admin/add/aboutbrand").permitAll()
				.antMatchers("/api/test/shoping-cart", "/api/test/addtocartproduct/**","/api/test/upload/userimage",
						"/api/test/categoryRemoveByIds/**", "/api/test/GetAllProducts")
				.permitAll().antMatchers("/api/user/forgote-password").permitAll()
				// .hasRole("USER")
				.antMatchers("/api/user/bookproduct").hasRole("USER").antMatchers("/api/user/addtocartproduct")
				.permitAll().antMatchers("/api/filter/filterdprice/{price}").permitAll()
				.antMatchers("product/page", "/api/test/sendemail", "/api/admin/order-list", "/api/admin/getString",
						"/api/test/saveAdderess", "/api/test/getCartDetailsBasedonUsser", "/api/test/bookproduct",
						"/api/test/shoping-carts", "/api/test/getAdderess", "/api/test/getAddressForOrder",
						"/api/test/js/**","/api/admin/all-brands")
				.permitAll()
				.antMatchers("/resources/js/**", "/resources/fonts/**", "/resources/css/**", "/resources/csss/**",
						"/recources/jss/**", "/static/**", "/resources/**")
				.permitAll().antMatchers("/api/user/**", "/ecommarce/").permitAll()
				// .antMatchers("/actuator/**").permitAll()
				.antMatchers("/api/test/add/product").permitAll()
				// .hasRole("ADMIN")
				.antMatchers("/api/page/**", "/api/page/LogIn", "/api/page/ProductPage",
						"/api/page/getProductByCategory/","/api/page/All-Category-list")
				.permitAll()
				// .antMatchers("/api/test/shoping-cart").access("hasRole('ROLE_USER')")

				.anyRequest().authenticated();
//				.and().logout().clearAuthentication(false).invalidateHttpSession(true)
//				.deleteCookies("JSESSIONID").logoutUrl("/logout").logoutSuccessUrl("/api/page/LogIn");
		http.authenticationProvider(authenticationProvider());
		http.addFilterAfter(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	/* ignore the static contentg */

//	@Bean
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/UploadFiles/**");
//	}

}