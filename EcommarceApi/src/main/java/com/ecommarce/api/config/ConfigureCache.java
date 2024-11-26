package com.ecommarce.api.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureCache {
	@Bean
	public CacheManager cacheManager() {
	    return new org.springframework.cache.concurrent.ConcurrentMapCacheManager();
	}
}
