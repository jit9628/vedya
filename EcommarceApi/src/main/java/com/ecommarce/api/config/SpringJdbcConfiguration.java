package com.ecommarce.api.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringJdbcConfiguration {
	@Autowired
	Environment environment;
	@Value("${spring.datasource.url}")
	private String URL;
	@Value("${spring.datasource.username}")
	private String USER;
	private String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	@Value("${spring.datasource.password}")
	private String PASSWORD;


	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(URL);
		driverManagerDataSource.setUsername(USER);
		driverManagerDataSource.setPassword(PASSWORD);
		driverManagerDataSource.setDriverClassName(DRIVER);
		return driverManagerDataSource;
	}



}
