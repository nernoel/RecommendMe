package com.me.recommend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /*
    Injecting model mapper bean into the spring configuration
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}