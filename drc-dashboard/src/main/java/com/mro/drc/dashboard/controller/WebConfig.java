package com.mro.drc.dashboard.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 20126160
 * This class will provide all the configuration details for client to access the server APIs.
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig implements WebMvcConfigurer {
 
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