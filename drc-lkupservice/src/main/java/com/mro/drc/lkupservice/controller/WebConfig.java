package com.mro.drc.lkupservice.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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