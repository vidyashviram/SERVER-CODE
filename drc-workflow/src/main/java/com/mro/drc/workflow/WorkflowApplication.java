package com.mro.drc.workflow;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*    
 * @ComponentScan(basePackages = { "com.mro.drc.entities.*" })
 * 
 * @ComponentScan(basePackages = { "com.mro.drc.workflow.domain.*" })
 * 
 * @EntityScan(basePackages = { "com.mro.drc.entities.*" })
 */
                    
public class WorkflowApplication {

	private static final Logger LOG = Logger.getLogger(WorkflowApplication.class.getName());

	public static void main(String[] args) {
		LOG.info("Started main class");
		SpringApplication.run(WorkflowApplication.class, args);
	}
}
