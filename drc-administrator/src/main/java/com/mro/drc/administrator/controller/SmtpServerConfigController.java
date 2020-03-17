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

import com.mro.drc.administrator.entity.SmtpServerConfig;
import com.mro.drc.administrator.service.SmtpServerConfigService;

/**
 * @author 40008878 REST Controller to 1. fetch the details from Repository 2.
 *         Save/update details to repository
 */
@RestController
public class SmtpServerConfigController {
	private static final Logger LOG = Logger.getLogger(SmtpServerConfigController.class.getName());
	@Autowired
	private SmtpServerConfigService smtpServerConfigService;

	/**
	 * @param smtpDataRequest : SMTP Form Request for Save
	 * @return Success or Failure
	 * @throws Exception
	 */
	@PostMapping("/admin/addSmtpServerDetails")
	public ResponseEntity<List<Map<String, String>>> addSMTPServerDetails(@RequestBody SmtpServerConfig smtpDataRequest)
			throws Exception {
		LOG.info("Inside addSMTPServerDetails");
		List<Map<String, String>> smtpListResponse = new ArrayList<>();
		Map<String, String> response = smtpServerConfigService.addSmtpServerRecord(smtpDataRequest);
		smtpListResponse.add(response);
		LOG.info("The response received by addSMTPServerDetails is " + smtpListResponse);
		return new ResponseEntity<>(smtpListResponse, HttpStatus.OK);

	}

	/**
	 * @return SMTP Configuration List
	 * @throws Exception
	 */
	@RequestMapping("/admin/getSMTPServerList")
	public ResponseEntity<List<SmtpServerConfig>> getSMTPServerList() throws Exception {
		LOG.info("Inside getSMTPServerList");

		return new ResponseEntity<>(smtpServerConfigService.getSMTPServerList(), HttpStatus.OK);
	}

	/**
	 * @param id : fetch record based on ID
	 * @return : return SMTP record based on ID
	 * @throws Exception
	 */
	@GetMapping("/admin/getSMTPServerById")
	public ResponseEntity<Map<String, SmtpServerConfig>> getSMTPserverById(@RequestParam Integer id) throws Exception {
		LOG.info("Inside getSMTPserverById");
		Map<String, SmtpServerConfig> smtpMap = new HashMap<>();
		SmtpServerConfig smtpConfig = smtpServerConfigService.getSMTPserverById(id);
		smtpMap.put("plantConfigRecord", smtpConfig);
		LOG.info("The response received by getSMTPserverById is " + smtpMap);
		return new ResponseEntity<>(smtpMap, HttpStatus.OK);
	}

}
