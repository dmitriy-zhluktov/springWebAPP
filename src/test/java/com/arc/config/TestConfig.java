package com.arc.config;

import com.arc.model.dao.service.UserDao;
import com.arc.model.dao.service.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    UserDao userDao() {
        return new UserDaoImpl();
    }
}
