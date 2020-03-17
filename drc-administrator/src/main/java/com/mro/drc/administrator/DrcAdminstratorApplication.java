package com.mro.drc.administrator;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DrcAdminstratorApplication {
	private static final Logger LOG = Logger.getLogger(DrcAdminstratorApplication.class.getName());

	public static void main(String[] args) {
		LOG.info("Started main class");
		SpringApplication.run(DrcAdminstratorApplication.class, args);
	}

}
