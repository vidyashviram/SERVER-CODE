package com.mro.drc.administrator.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.administrator.entity.LkupPlantConfiguration;
import com.mro.drc.administrator.service.PlantConfigurationService;

/**
 * @author 40008878 REST Controller to 1. Fetch records from database 2.
 *         save/update details to database 3. fetch details based on Id 4.
 *         active/ in-activate the plant
 */
@RestController
public class PlantConfigurationController {
	private static final Logger LOG = Logger.getLogger(PlantConfigurationController.class.getName());
	@Autowired
	private PlantConfigurationService plantConfigService;

	/**
	 * @return Plant Configuration List
	 * @throws Exception
	 */
	@RequestMapping("/admin/plantConfigListPage")
	public ResponseEntity<List<LkupPlantConfiguration>> getPlantConfigList() throws Exception {
		LOG.info("Inside getPlantConfigList");
		List<LkupPlantConfiguration> plantConfigList = plantConfigService.getPlantConfigList();
		LOG.info("The response received by getPlantConfigList is " + plantConfigList);
		return new ResponseEntity<>(plantConfigList, HttpStatus.OK);
	}

	/**
	 * @param plantConfigRequest : to set the request parameters in Object
	 * @return To set Add and Edit request plant Config details to Object
	 */
	public LkupPlantConfiguration setPlantConfigDetails(LkupPlantConfiguration plantConfigRequest) {
		LOG.info("Inside setPlantConfigDetails");
		if (plantConfigRequest.getPlantId() == null) {
			plantConfigRequest.setReceiveddate(new Date());
			plantConfigRequest.setModifiedDate(new Date());
			plantConfigRequest.setActive(true);
		} else {
			plantConfigRequest.setModifiedDate(new Date());
		}
		LOG.info("The response received by setPlantConfigDetails is " + plantConfigRequest);
		return plantConfigRequest;
	}

	/**
	 * @param plantConfigRequest : save request for plant configuration
	 * @return : Status update as Success or Failure
	 * @throws Exception
	 */
	@PostMapping("/admin/savePlantConfig")
	public ResponseEntity<List<Map<String, String>>> savePlantConfigRecord(
			@RequestBody LkupPlantConfiguration plantConfigRequest) throws Exception {
		LOG.info("Inside savePlantConfigRecord");
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		Map<String, String> resultMap = new HashMap<>();
		resultMap = plantConfigService.savePlantConfigRecord(setPlantConfigDetails(plantConfigRequest));
		result.add(resultMap);
		LOG.info("The response received by savePlantConfigRecord is " + result);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	/**
	 * @param plantId: Fetch record based on Plant id
	 * @return : return plant configuration list based on plant id
	 * @throws Exception
	 */
	@GetMapping("/admin/editPlantConfigForm")
	public ResponseEntity<Map<String, LkupPlantConfiguration>> getPlantConfigEditForm(@RequestParam Integer plantId)
			throws Exception {
		LOG.info("Inside getPlantConfigEditForm");
		Map<String, LkupPlantConfiguration> plantConfigMap = new HashMap<>();
		LkupPlantConfiguration plantConfig = plantConfigService.getPlantConfigRecordById(plantId);
		plantConfigMap.put("plantConfigRecord", plantConfig);
		LOG.info("The response received by getPlantConfigEditForm is " + plantConfigMap);
		return new ResponseEntity<>(plantConfigMap, HttpStatus.OK);
	}

	/**
	 * @param plantId  : Activate / in activate the record based on Plant id
	 * @param isActive : Status
	 * @return de-active / active the plant config
	 */
	@GetMapping("/admin/deactivePlantConfig")
	public ResponseEntity<List<Map<String, String>>> activeOrDeactivePlantConfig(@RequestParam Integer plantId,
			@RequestParam boolean isActive) throws Exception {
		LOG.info("Inside activeOrDeactivePlantConfig");
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		Map<String, String> resultMap = new HashMap<>();
		resultMap = plantConfigService.activeOrDeactivePlantConfig(plantId, isActive);
		result.add(resultMap);
		LOG.info("The response received by activeOrDeactivePlantConfig is " + result);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
