package com.mro.drc.workflow.controller;

import java.util.logging.Logger;

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
	
	private static final Logger LOG = Logger.getLogger(WebConfig.class.getName());
	
    /**
     *To configure Cross Origin requests
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	LOG.entering("WebConfig", "addCorsMappings");
    	registry.addMapping("/**")
    	 .allowedOrigins("*")
         .allowedMethods("POST", "GET", "PUT", "DELETE")
         .allowedHeaders("Content-Type", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers")
         .exposedHeaders("Access-Control-Expose-Headers")
         .allowCredentials(true).maxAge(3600);
    	LOG.exiting("WebConfig", "addCorsMappings");
    }
}    