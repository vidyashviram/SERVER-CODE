package com.mro.drc.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.dashboard.domain.WorkOrderEntry;
import com.mro.drc.dashboard.dto.WordOrderFilterResponse;
import com.mro.drc.dashboard.service.DashboardService;

/**
 * @author 20126160
 * This controller class will provide Rest APIs.
 */
@RestController
public class DashboardController implements ErrorController {

	@Autowired
	private DashboardService dashboardService;

	private static final String PATH = "/error";

	/**
	 * @return
	 * Handles the error when there is no mapping for the client request
	 */
	@RequestMapping(value = PATH)
	public String error() {
		return "There is no mapping for this Rest end point";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

	/**
	 * @return
	 * @throws Exception
	 * Rest API to get the count of high priority, repair,open workorder ans customer counts
	 */
	@RequestMapping(value = "/dashboardCount")
	public ResponseEntity<Map<String, Integer>> getDashboardCount() throws Exception {
		Map<String, Integer> dashboard = new HashMap<>();

		Integer highPriorityCount = dashboardService.getCountOfHighPriorityRecords();
		dashboard.put("highPriority", highPriorityCount);   

		Integer repairCount = dashboardService.getCountOfRepairRecords();
		dashboard.put("repairCount", repairCount);

		Integer openWordorderCount = dashboardService.getCountOfOpenWorkOrderRecords();
		dashboard.put("openWordorderCount", openWordorderCount);

		Integer customerCount = dashboardService.getCountOfCustomerCountRecords();
		dashboard.put("customerCount", customerCount);

		return new ResponseEntity<>(dashboard, HttpStatus.OK);
	}
    
	/**
	 * @return
	 * @throws Exception
	 * Rest API to get WorkOrder data which is having high priority
	 */
	@RequestMapping(value = "/highPriorityData", method = RequestMethod.GET)
	public ResponseEntity<List<WordOrderFilterResponse>> getHighPriorityData() throws Exception {
		List<WordOrderFilterResponse> result = dashboardService.getHighPriorityRecords();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * @return
	 * @throws Exception
	 * Rest API to get the repair workOrder data.
	 */
	@RequestMapping(value = "/repairData", method = RequestMethod.GET)
	public ResponseEntity<List<WordOrderFilterResponse>> getRepairData() throws Exception {
		List<WordOrderFilterResponse> result = dashboardService.getRepairRecords();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * @return
	 * @throws Exception
	 * Rest API to get the Open work order Details
	 */
	@RequestMapping(value = "/openWorkOrdersData")
	public ResponseEntity<List<WordOrderFilterResponse>> getOpenWorkOrdersData() throws Exception {
		List<WordOrderFilterResponse> result = dashboardService.getOpenWorkOrderRecords();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * @return
	 * @throws Exception
	 * Rest API to get the customer Details
	 */
	@RequestMapping(value = "/customerData")
	public ResponseEntity<List<WordOrderFilterResponse>> getCustomerData() throws Exception {
		List<WordOrderFilterResponse> result = dashboardService.getCustomerRecords();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
