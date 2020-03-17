package com.mro.drc.administrator.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.administrator.dao.EmailTemplateConfigDao;
import com.mro.drc.administrator.entity.EmailTemplateConfig;
import com.mro.drc.administrator.service.EmailTemplateConfigService;

/**
 * @author 40008878 Service implemented to fetch details from emailTemplateDao
 *         and store data to EmailTemplateConfig table
 */
@Service
public class EmailTemplateConfigServiceImpl implements EmailTemplateConfigService {
	private static final Logger LOG = Logger.getLogger(EmailTemplateConfigServiceImpl.class.getName());
	@Autowired
	private EmailTemplateConfigDao emailTemplateDao;

	/**
	 * Service to fetch all records from EmailTemplateConfig table
	 */
	@Override
	public List<EmailTemplateConfig> getEmailTemplateList() throws Exception {
		LOG.info("Inside getEmailTemplateList");
		List<EmailTemplateConfig> emailTemplateList = new ArrayList<>();
		try {
			emailTemplateList = emailTemplateDao.getEmailTemplateList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("The response received by getEmailTemplateList is " + emailTemplateList);
		return emailTemplateList;
	}

	/**
	 * Service to save / update email template details to EmailTemplateConfig table
	 */
	@Override
	public Map<String, String> saveEmailTemplate(EmailTemplateConfig emailTemplate) throws Exception {
		LOG.info("Inside saveEmailTemplate");
		Map<String, String> result = new HashMap<String, String>();
		try {
			if (emailTemplate != null) {
				emailTemplateDao.saveAndFlush(emailTemplate);
				result.put("message", "Success");
			} else {
				result.put("message", "Bad Request");
			}
		} catch (Exception e) {
			result.put("message", "Failure");
			e.printStackTrace();
		}
		LOG.info("The response received by saveEmailTemplate is " + result);
		return result;
	}

	/**
	 * Service to fetch Email template record based on templateId from
	 * EmailTemplateConfig table
	 */
	@Override
	public EmailTemplateConfig getEmailTemplateById(Integer templateId) throws Exception {
		LOG.info("Inside getEmailTemplateById");
		EmailTemplateConfig emailTemplate = new EmailTemplateConfig();
		try {
			emailTemplate = emailTemplateDao.getEmailTemplateById(templateId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("The response received by getEmailTemplateById is " + emailTemplate);
		return emailTemplate;
	}

}
