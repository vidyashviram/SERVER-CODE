package com.mro.drc.administrator.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mro.drc.administrator.dao.EmailTemplateConfigDao;
import com.mro.drc.administrator.entity.EmailTemplateConfig;

public class EmailTemplateConfigServiceImplTest {

	@Mock
	private EmailTemplateConfigDao emailTemplateDao;

	@InjectMocks
	private EmailTemplateConfigServiceImpl emailTemplateService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	public List<EmailTemplateConfig> emailTemplateConfig() {
		List<EmailTemplateConfig> emailTemplateList = new ArrayList<>();
		EmailTemplateConfig emailTemplateConfig = new EmailTemplateConfig();
		emailTemplateConfig.setTemplateId(1);
		emailTemplateConfig.setCategory("Invoice");
		emailTemplateConfig.setCreatedDate(new Date());
		emailTemplateConfig.setEmailBody("Test approval mail");
		emailTemplateConfig.setFromAddress("admin@test.com");
		emailTemplateConfig.setToAddress("mro@test.com");
		emailTemplateConfig.setSubject("Approval");
		emailTemplateConfig.setTemplateName("Approval template");
		emailTemplateList.add(emailTemplateConfig);
		return emailTemplateList;
	}

	@Test
	public void getEmailTemplateListTest() throws Exception {

		Mockito.when(emailTemplateDao.getEmailTemplateList()).thenReturn(emailTemplateConfig());
		List<EmailTemplateConfig> emailTemplateResult = emailTemplateService.getEmailTemplateList();
		assertEquals("Invoice", emailTemplateResult.get(0).getCategory());
	}

	@Test
	public void saveEmailTemplateTest() throws Exception {
		EmailTemplateConfig emailTemplate = emailTemplateConfig().get(0);
		Mockito.when(emailTemplateDao.saveAndFlush(emailTemplate)).thenReturn(emailTemplate);
		Map<String, String> result1 = emailTemplateService.saveEmailTemplate(emailTemplate);
		assertEquals("Success", result1.get("message"));
	}

	@Test
	public void saveEmailTemplateNullRecordTest() throws Exception {

		Mockito.when(emailTemplateDao.saveAndFlush(emailTemplateConfig().get(0))).thenReturn(null);
		Map<String, String> response = emailTemplateService.saveEmailTemplate(null);
		assertEquals("Bad Request", response.get("message"));

	}

	@Test
	public void getEmailTemplateByIdTest() throws Exception {

		Mockito.when(emailTemplateDao.getEmailTemplateById(emailTemplateConfig().get(0).getTemplateId()))
				.thenReturn(emailTemplateConfig().get(0));
		EmailTemplateConfig emailTemplate = emailTemplateService
				.getEmailTemplateById(emailTemplateConfig().get(0).getTemplateId());
		assertEquals(1, emailTemplate.getTemplateId());
	}

}
