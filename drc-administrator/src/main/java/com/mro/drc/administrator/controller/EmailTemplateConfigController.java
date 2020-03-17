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

import com.mro.drc.administrator.entity.EmailTemplateConfig;
import com.mro.drc.administrator.service.EmailTemplateConfigService;

/**
 * @author 40008878 REST Controller for 1. Email template list 2. Save/update
 *         Email template
 */
@RestController
public class EmailTemplateConfigController {
	private static final Logger LOG = Logger.getLogger(EmailTemplateConfigController.class.getName());
	@Autowired
	private EmailTemplateConfigService emailTempService;

	/**
	 * @return : Complete template List
	 * @throws Exception
	 */
	@RequestMapping("/admin/emailTemplateList")
	public ResponseEntity<List<EmailTemplateConfig>> getEmailTemplateList() throws Exception {
		LOG.info("Inside getEmailTemplateList");
		List<EmailTemplateConfig> emailTemplateList = emailTempService.getEmailTemplateList();
		LOG.info("The response received by getEmailTemplateList is " + emailTemplateList);
		return new ResponseEntity<>(emailTemplateList, HttpStatus.OK);
	}

	/**
	 * @param emailTemplate: Request object to set the values to EmailTemplateConfig
	 *                       for save / update
	 * @return : EmailTemplateConfig object after setting the request parameters
	 */
	public EmailTemplateConfig setEmailTemplateDetails(EmailTemplateConfig emailTemplate) {
		LOG.info("Inside setEmailTemplateDetails");
		if (emailTemplate.getTemplateId() == null) {
			emailTemplate.setCreatedDate(new Date());
			emailTemplate.setModifiedDate(new Date());
		} else {
			emailTemplate.setModifiedDate(new Date());
		}
		LOG.info("The response received by setEmailTemplateDetails is " + emailTemplate);
		return emailTemplate;
	}

	/**
	 * @param emailTemplate: Request object to set the values to EmailTemplateConfig
	 *                       for save / update
	 * @return : Status as Success or Failure
	 * @throws Exception
	 */
	@PostMapping("/admin/saveEmailTemplate")
	public ResponseEntity<List<Map<String, String>>> saveEmailTemplate(@RequestBody EmailTemplateConfig emailTemplate)
			throws Exception {
		LOG.info("Inside saveEmailTemplate");
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		Map<String, String> resultMap = new HashMap<>();
		resultMap = emailTempService.saveEmailTemplate(setEmailTemplateDetails(emailTemplate));
		result.add(resultMap);
		LOG.info("The response received by saveEmailTemplate is " + result);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	/**
	 * @param templateId: Fetch Email template details based on ID
	 * @return : Email Template Record
	 * @throws Exception
	 */
	@GetMapping("/admin/editEmailTemplate")
	public ResponseEntity<Map<String, EmailTemplateConfig>> getEmailTemplateById(@RequestParam Integer templateId)
			throws Exception {
		LOG.info("Inside getEmailTemplateById");
		Map<String, EmailTemplateConfig> emailTemplateMap = new HashMap<>();
		EmailTemplateConfig emailTemplate = emailTempService.getEmailTemplateById(templateId);
		emailTemplateMap.put("emailTemplate", emailTemplate);
		LOG.info("The response received by getEmailTemplateById is " + emailTemplateMap);
		return new ResponseEntity<>(emailTemplateMap, HttpStatus.OK);
	}
}
