package com.ecommarce.api.scheduledtask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class ScheduledTasks {
	
	@Autowired 
    private CacheManager cacheManager;     
	//@Scheduled(cron = "*/10 * * * * * ")
    public void clearAllCaches(){
        for(String name:cacheManager.getCacheNames()){
           // cacheManager.getCache(name).clear();    
        	System.out.println("cache name is "+name);
        }
    }
	
//String c="*/5 * * * * *";
	
	//private static final org.jboss.logging.Logger log = LoggerFactory.logger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	//  @Scheduled(cron = "30 * 2 * * ?")
	//@Scheduled(fixedRate = 5000)
	//String cc="*/10 * * * * *";
	//@Scheduled(cron = "*/10 * * * * * ") // Every 10 seconds 
	//@Scheduled(cron ="${c}" ) // Every 10 seconds 
	public void reportCurrentTime() {
		System.out.println("cache name is "+cacheManager.getCacheNames());
		log.info("The time is now {}"+ dateFormat.format(new Date()));
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		 System.out.println("Scheduler task with duration : " + sdf.format(new Date()));
	
	  }
}