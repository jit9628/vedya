package com.ecommarce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecommarce.api.payload.OrderDetailsPayload;

//import com.google.common.annotations.VisibleForTesting;
@SpringBootApplication
//@EnableSwagger2
@EnableAutoConfiguration
//@VisibleForTesting
//@EnableJpaRepositories
@EnableScheduling
@CrossOrigin(origins = "*")
@EnableCaching
//@org.springframework.context.annotation.Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EcommarceApiApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	private OrderDetailsPayload payload;
	

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	protected SpringApplicationBuilder createSpringApplicationBuilder(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(EcommarceApiApplication.class);
		// return new SpringApplicationBuilder();
	}

//	@Bean
//    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
//      webServerFactoryCustomizer() {
//        return factory -> factory.setContextPath("/EcommarceApi");
//}
//	

//	 @Override public void onStartup(ServletContext servletContext) throws
//	 ServletException { // TODO Auto-generated method stub //
//	 servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.SSL));
//	  HashSet<SessionTrackingMode> set = new HashSet<SessionTrackingMode>(); //
//	  set.add(SessionTrackingMode.COOKIE);
//	  servletContext.setSessionTrackingModes(set);
//	  
//	 super.onStartup(servletContext);
//	 }

	public static void main(String[] args) {

		// System.setProperty("server.servlet.context-path", "/");

		// System.setProperty("spring.mvc.servlet.path", "/");


		SpringApplication.run(EcommarceApiApplication.class, args);
		
		/*
		 * System.out.println("Random String Value Is ::"+RandomStringValue
		 * .getAlphaNumericString());
		 */

	}
//	@Override  
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
//	{  
//	return application.sources(SpringBootWarDeploymentExampleApplication.class);  
//	}

	@Override
	public void run(String... args) throws Exception {
		//boolean deleteImageFromFolder = new FileUploadHelper().deleteImageFromFolder("card-01.jpg");
	//System.out.println("Deleted Value s ::"+deleteImageFromFolder);
		// List<OrderDetailsPojo> specificUserBookingDetail =
		// this.payload.getSpecificUserBookingDetail();
		// Log.info("Booking Details is ::"+specificUserBookingDetail);
		// Log.info("Booking Details is
		// ::"+specificUserBookingDetail.get(0).getOrderaddress());

	}

//	@Override
//	public void run(String... args) throws Exception {
//		try {
//			log.info("Jdbc Template DataSource is ::)" + jdbcTemplate.getDataSource());
//			DataSource dataSource = jdbcTemplate.getDataSource();
//			Connection connection = dataSource.getConnection();
//			log.info("Jdbc Connection  is ::)" + connection);
//			TreeSet<String> set = new TreeSet<>();
//
//			this.jdbcTemplate.query("select * from product", new RowMapper<Product>() {
//				@Override
//				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
//					ProductDto p = new ProductDto();
//					p.setPid(rs.getRow());
//					p.setProductname(rs.getString("productname"));
//					// set.addAll(new
//					// ArrayList<String>(Arrays.asList(rs.getString("productsize").split(" "))));
////		      Blob blob = rs.getBlob("productsize");
////		      InputStream binaryStream = blob.getBinaryStream();
//					log.info("Row Data is :" + p);
//					return null;
//				}
//			});
//
////	List<Product> queryForList = this.jdbcTemplate.queryForList("select * from product", Product.class);
////	log.info("List Of Object is ::"+queryForList);
//
//		} catch (Exception e) {
//			log.info(e.getLocalizedMessage());
//		}
//	}
}
