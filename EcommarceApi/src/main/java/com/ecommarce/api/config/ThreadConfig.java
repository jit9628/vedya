package com.ecommarce.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

//NEW  CONFIGURATION FOR THREAD SAFETY

@Configuration
public class ThreadConfig {
    @Bean
    public ThreadPoolTaskExecutor taskExecutor(){
    ThreadPoolTaskExecutor executorPool = new ThreadPoolTaskExecutor();
    executorPool.setCorePoolSize(10);
    executorPool.setMaxPoolSize(20);
    executorPool.setQueueCapacity(10);
    executorPool.setWaitForTasksToCompleteOnShutdown(true);
    executorPool.setAwaitTerminationSeconds(60);
    executorPool.initialize();
    return executorPool;
}
}
