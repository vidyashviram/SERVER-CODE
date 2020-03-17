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

import com.mro.drc.administrator.entity.LdapServerConfig;
import com.mro.drc.administrator.service.ActiveDirectoryService;

/**
 * @author 40008878 REST controller exposes APIs for 1. Fetch All Active
 *         Directory List 2. Save/update the Active Directory details 3. Fetch
 *         Active directory details based on Id
 *
 */
@RestController
public class ActiveDirectoryController {
	private static final Logger LOG = Logger.getLogger(ActiveDirectoryController.class.getName());
	@Autowired

	private ActiveDirectoryService activeDirectoryService;

	/**
	 * @param ldapDataRequest : Request JSON object to store in DB
	 * @return : Response object with status message and status code
	 * @throws Exception
	 */
	@PostMapping("/admin/addLdapServerDetails")
	public ResponseEntity<List<Map<String, String>>> addLdapServerDetails(@RequestBody LdapServerConfig ldapDataRequest)
			throws Exception {
		LOG.info("Inside addLdapServerDetails");
		List<Map<String, String>> dbListResponse = new ArrayList<>();
		Map<String, String> response = activeDirectoryService.addLdapServerRecord(ldapDataRequest);
		dbListResponse.add(response);
		LOG.info("The response received by addLdapServerDetails is " + dbListResponse);
		return new ResponseEntity<>(dbListResponse, HttpStatus.CREATED);
	}

	/**
	 * @return : Active directory List
	 * @throws Exception
	 */
	@RequestMapping("/admin/getLdapList")
	public ResponseEntity<List<LdapServerConfig>> getLdapList() throws Exception {
		LOG.info("Inside getLdapList");
		List<LdapServerConfig> ldapList = activeDirectoryService.getLdapList();
		LOG.info("The response received by getLdapList is " + ldapList);
		return new ResponseEntity<>(ldapList, HttpStatus.OK);
	}

	/**
	 * @param id : Get the Active directory record by ID in-order to edit the
	 *           details
	 * @return : Active directory record based on ID
	 * @throws Exception
	 */
	@GetMapping("/admin/getLdapDetailsbyId")
	public ResponseEntity<Map<String, LdapServerConfig>> getLdapDetailsById(@RequestParam Integer id) throws Exception {
		LOG.info("Inside getLdapDetailsById");
		Map<String, LdapServerConfig> ldapMap = new HashMap<>();
		LdapServerConfig ldapDetails = activeDirectoryService.getLdapDetailsById(id);
		ldapMap.put("ldapDetails", ldapDetails);
		LOG.info("The response received by getLdapDetailsById is " + ldapMap);
		return new ResponseEntity<>(ldapMap, HttpStatus.OK);
	}
}
