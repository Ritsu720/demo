package com.example.demo.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;


@EnableCaching // spring framework中用來驅動緩存的註解
@Configuration // 跟spring boot說這是一個設定檔
public class CaffeineCacheConfig {

	@Bean
	public CacheManager chacheManager() {
		
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		
		cacheManager.setCaffeine(Caffeine.newBuilder()
				// 過期時間設定
				.expireAfterAccess(600, TimeUnit.SECONDS)
				// 初始的緩存空間大小
				.initialCapacity(100)
				// 緩存的最大筆數
				.maximumSize(500));
		
		return cacheManager;
	}
	
}
