
package com.mro.drc.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 20126160
 *         This DrcDashboardApplication class provides the dashboard
 *         services for getting Open workorder, repair ,high priority and
 *         Customer details.
 */
@SpringBootApplication
public class DrcDashboardApplication {

	/**
	 * @param args
	 * Main class to start the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(DrcDashboardApplication.class, args);
	}

}
