package com.mro.drc.domainservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.domainservice.dto.WorkStatusListDto;
import com.mro.drc.domainservice.service.WorkOrderStatusService;

/**
 * @author 40008878
 *
 */
@RestController
public class WorkOrderStatusController {
	@Autowired
	private WorkOrderStatusService workOrderServ;

	/**
	 * @return : Fetch all the work order status for drop down
	 * @throws Exception
	 */
	@RequestMapping("/getWorkStatusList")
	public ResponseEntity<Map<String, List<WorkStatusListDto>>> getWorkStatusList() throws Exception{
		return new ResponseEntity<>(workOrderServ.getWorkStatusList(), HttpStatus.OK);
	}
}
