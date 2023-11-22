/*
 * 
 * package com.ecommarce.api.config;
 * 
 * 
 * import javax.servlet.ServletContext; import javax.servlet.ServletException;
 * import javax.servlet.ServletRegistration;
 * 
 * import org.springframework.web.WebApplicationInitializer; import
 * org.springframework.web.context.support.
 * AnnotationConfigWebApplicationContext; import
 * org.springframework.web.servlet.DispatcherServlet;
 * 
 * import lombok.extern.slf4j.Slf4j;
 * 
 * @Slf4j
 * 
 * public class WebInitializer implements WebApplicationInitializer {
 * 
 * @Override public void onStartup(ServletContext servletContext) throws
 * ServletException { System.out.println("Jitendra Shuka"); //java Based
 * Configuration AnnotationConfigWebApplicationContext ctx = new
 * AnnotationConfigWebApplicationContext();
 * ctx.register(MyServletDispatcherConfiguration.class);
 * ctx.setServletContext(servletContext);
 * 
 * DispatcherServlet dispatcherServlet=new DispatcherServlet(ctx);
 * 
 * ServletRegistration.Dynamic servlet =
 * servletContext.addServlet("Jitendra_Shukla_Created_Dispatcher_servlet",
 * dispatcherServlet); servlet.setLoadOnStartup(1);
 * servlet.addMapping("/ecommarce/");
 * 
 * log.info(" servlet dispatcher is :: "+servlet); // WebApplicationContext
 * currentWebApplicationContext =
 * ContextLoaderListener.getCurrentWebApplicationContext(); //Xml Based
 * configuration
 * 
 * //
 * log.info(" currentWebApplicationContext is :: "+currentWebApplicationContext)
 * ; //XmlWebApplicationContext webApplicationContext = new
 * XmlWebApplicationContext();
 * //webApplicationContext.setConfigLocation("classpath:application-config.xml")
 * ;
 * 
 * // Creating a dispatcher servlet object // DispatcherServlet
 * dispatcherServlet = new DispatcherServlet(webApplicationContext);
 * 
 * // Registering Dispatcher Servlet with Servlet // Context
 * //ServletRegistration.Dynamic myCustomDispatcherServlet =
 * servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
 * 
 * // Setting load on startup //myCustomDispatcherServlet.setLoadOnStartup(1);
 * 
 * // Adding mapping url
 * //myCustomDispatcherServlet.addMapping("/EcommarceApi/");
 * 
 * 
 * 
 * }
 * 
 * 
 * }
 * 
 * 
 * 
 */