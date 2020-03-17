package com.mro.drc.administrator.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.administrator.entity.EmailTemplateConfig;

/**
 * @author 40008878
 *
 */
public interface EmailTemplateConfigService {

	List<EmailTemplateConfig> getEmailTemplateList() throws Exception;

	Map<String, String> saveEmailTemplate(EmailTemplateConfig setEmailTemplateDetails) throws Exception;

	EmailTemplateConfig getEmailTemplateById(Integer templateId) throws Exception;

}
