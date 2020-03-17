package com.mro.drc.workflow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.workflow.domain.GatesCount;
import com.mro.drc.workflow.domain.GatesProcess;
import com.mro.drc.workflow.domain.MroProcess;
import com.mro.drc.workflow.exception.CustomException;
/*import com.mro.drc.workflow.domain.GatesCount;
import com.mro.drc.workflow.domain.GatesProcess;*/
//import com.mro.drc.entities.*;
import com.mro.drc.workflow.service.WorkflowManagementService;

/**
 * @author 20126160 Controller class to provide Rest APIs to perform actions on
 *         User
 */
@RestController
public class WorkflowController implements ErrorController {

	private static final Logger LOG = Logger.getLogger(WorkflowController.class.getName());

	@Autowired
	private WorkflowManagementService workflowManagementService;

	private static final String PATH = "/error";

	/**
	 * @return To handle the error scenarios when there is bad request
	 */
	@RequestMapping(value = PATH)
	public String error() {
		// LOG.e("Inside saveGateCount");
		return "There is no mapping for this Rest end point";
	}

	/**
	 * To return then path for rest end point
	 */
	@Override
	public String getErrorPath() {
		return PATH;
	}

	// list
	/**
	 * @return
	 * @throws Exception Rest API to get process data
	 */
	@GetMapping(value = "/workflow/getProcessData")
	public ResponseEntity<List<MroProcess>> getProcessData() {
		LOG.info("Inside getProcessData");
		List<MroProcess> result = workflowManagementService.getProcessData();
		if (result.isEmpty()) {
			throw new CustomException("No Data", "Table is not having any records");
		}
		LOG.info("Exit from getProcessData" );
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping(value = "/workflow/saveGateCount")
	public ResponseEntity<List<Map<String, String>>> saveGateCount(@RequestBody GatesCount gateCount) {
		LOG.info("Inside saveGateCount");
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		if (gateCount.getGatesCount() == null) {
			LOG.info("Bad Request Please provide the GateCount value");
			throw new CustomException("Bad Request", "Please provide the GateCount value");
		}
		result.add(workflowManagementService.saveGateCount(gateCount));
		LOG.info("Exit from saveGateCount" );
		return new ResponseEntity<>(result, HttpStatus.OK);
	}  

	@PostMapping(value = "/workflow/saveGateProcess")
	public ResponseEntity<List<Map<String, String>>> saveGateProcess(@RequestBody List<GatesProcess> gateProcessList) {
		LOG.info("Inside saveGateProcess");
		for (int i = 0; i < gateProcessList.size(); i++) {
			if (gateProcessList.get(i).getId() == null) {
				throw new CustomException("Bad Request", "Please provide Id");
			}
		}
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		result.add(workflowManagementService.saveGateProcessData(gateProcessList));
		LOG.info("Exit from saveGateProcess" );
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
