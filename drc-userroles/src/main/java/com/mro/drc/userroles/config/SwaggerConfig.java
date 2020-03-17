package com.mro.drc.userroles.config;

import java.util.Collections;
import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mro.drc.userroles.constants.Constants;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

	private static final Logger LOG = Logger.getLogger(SwaggerConfig.class.getName());

	@Bean   
	public Docket apiDocket() {           
		LOG.entering(Constants.SWAGGER_CONFIG, Constants.APIDOCKET);
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(Constants.CONTROLLER_PACKAGE)).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
		LOG.exiting(Constants.SWAGGER_CONFIG, Constants.APIDOCKET);
		return docket;
	}

	@Override              
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		LOG.entering(Constants.SWAGGER_CONFIG, Constants.ADDRESOURCEHANDLERS);
		registry.addResourceHandler(Constants.SWAGGER_UI_HTML).addResourceLocations(Constants.CLASSPATH);
		registry.addResourceHandler(Constants.WEBJARS).addResourceLocations(Constants.CLASSPATH_WEBJARS);
		LOG.exiting(Constants.SWAGGER_CONFIG, Constants.ADDRESOURCEHANDLERS);
	}

	private ApiInfo apiInfo() {
		LOG.entering(Constants.SWAGGER_CONFIG, Constants.APIINFO);
		return new ApiInfo(Constants.REST_API_NAME, Constants.API_DESC, Constants.API_TOS, Constants.TOS,
				new Contact(Constants.CREATER_NAME, Constants.WEBSITE, Constants.MAILID), Constants.LICENSE,
				Constants.LICENCE_URL, Collections.emptyList());
	}
}