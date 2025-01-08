package com.kai.redis_cache_h2_practice.services;


import com.kai.redis_cache_h2_practice.models.User;
import com.kai.redis_cache_h2_practice.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(value = "users", key = "#id")
    public User getUserById(Long id) {
        try {
            Thread.sleep(3000);  // 模擬延遲
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
