package com.kai.redis_cache_h2_practice.schedulers;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheEvictScheduler {

    @Scheduled(fixedRate = 10000)
    @CacheEvict(value = "users", allEntries = true)
    public void clearUserCache() {
        System.out.println("Cache cleared");
    }
}
