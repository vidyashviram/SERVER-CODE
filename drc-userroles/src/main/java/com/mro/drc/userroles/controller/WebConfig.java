package com.mro.drc.userroles.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 20126160
 *Config file to connect to Client
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig implements WebMvcConfigurer {
 
    /**
     *To configure Cross Origin requests
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**")
    	 .allowedOrigins("*")
         .allowedMethods("POST", "GET", "PUT", "DELETE")
         .allowedHeaders("Content-Type", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers")
         .exposedHeaders("Access-Control-Expose-Headers")
         .allowCredentials(true).maxAge(3600);
    }
}