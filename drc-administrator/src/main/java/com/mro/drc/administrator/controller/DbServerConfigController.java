package com.mro.drc.administrator.controller;

import java.util.ArrayList;
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

import com.mro.drc.administrator.entity.DbServerConfig;
import com.mro.drc.administrator.service.DbServerConfigService;

/**
 * @author 40008878 REST Controller to 1. fetch List from DB Config 2. To
 *         save/update details to DB Config 3. To fetch record based on ID from
 *         DB Config
 */
@RestController
public class DbServerConfigController {
	private static final Logger LOG = Logger.getLogger(DbServerConfigController.class.getName());
	@Autowired
	private DbServerConfigService dbServerConfigService;

	/**
	 * @param dbDataRequest : Rest API to save the server details
	 * @return : Success or Failure
	 * @throws Exception
	 */
	@PostMapping("/admin/addDbServerDetails")
	public ResponseEntity<List<Map<String, String>>> addDbServerDetails(@RequestBody DbServerConfig dbDataRequest)
			throws Exception {
		LOG.info("Inside addDbServerDetails");
		List<Map<String, String>> dbListResponse = new ArrayList<>();
		Map<String, String> response = dbServerConfigService.addDbServerRecord(dbDataRequest);
		dbListResponse.add(response);
		LOG.info("The response received by addDbServerDetails is " + dbListResponse);
		return new ResponseEntity<>(dbListResponse, HttpStatus.OK);
	}

	/**
	 * @return List of DBserver
	 * @throws Exception
	 */
	@RequestMapping("/admin/getDBServerConfigList")
	public ResponseEntity<List<DbServerConfig>> getDBServerList() throws Exception {
		LOG.info("Inside getDBServerList");
		List<DbServerConfig> dbConfigList = dbServerConfigService.getDBServerList();
		LOG.info("The response received by getDBServerList is " + dbConfigList);
		return new ResponseEntity<>(dbConfigList, HttpStatus.OK);
	}

	/**
	 * @param id : Fetch DB Config details based on ID
	 * @return : DB Config details
	 * @throws Exception
	 */
	@GetMapping("/admin/getDbServerConfigById")
	public ResponseEntity<Map<String, DbServerConfig>> getDbServerConfigById(@RequestParam Integer id)
			throws Exception {
		LOG.info("Inside getDbServerConfigById");
		Map<String, DbServerConfig> dbConfigMap = new HashMap<>();
		DbServerConfig dbConfig = dbServerConfigService.getDbServerConfigById(id);
		dbConfigMap.put("dbConfig", dbConfig);
		LOG.info("The response received by getDbServerConfigById is " + dbConfigMap);
		return new ResponseEntity<>(dbConfigMap, HttpStatus.OK);
	}
}
