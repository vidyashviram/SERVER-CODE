package com.mro.drc.lkupservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.lkupservice.dto.PlantConfigurationNumDto;
import com.mro.drc.lkupservice.service.LkupPlantConfigurationService;

/**
 * @author 20126161
 *
 */
@RestController
public class LkupPlantConfigurationController {

	@Autowired
	private LkupPlantConfigurationService lkupPlantConfigurationService;

	/**
	 * @return : PlantConfiguration drop down list
	 */
	@RequestMapping("/getLkupPlantConfig")
	public ResponseEntity<Map<String, List<PlantConfigurationNumDto>>> getLkupPlantConfig() {
		return new ResponseEntity<>(lkupPlantConfigurationService.getLkupPlantConfig(), HttpStatus.OK);
	}

}
