package com.mro.drc.administrator.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mro.drc.administrator.entity.EmailTemplateConfig;
import com.mro.drc.administrator.service.EmailTemplateConfigService;

@SpringBootTest
public class EmailTemplateConfigControllerTest {

	private MockMvc mvc;

	@Mock
	private EmailTemplateConfigService emailTempService;

	@InjectMocks
	private EmailTemplateConfigController emailTemplateController;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(emailTemplateController).dispatchOptions(true).build();
	}

	public EmailTemplateConfig emailTemplateConfig() {
		EmailTemplateConfig emailTemplateConfig = new EmailTemplateConfig();
		emailTemplateConfig.setTemplateId(1);
		emailTemplateConfig.setCategory("Invoice");
		emailTemplateConfig.setCreatedDate(new Date());
		emailTemplateConfig.setEmailBody("Test approval mail");
		emailTemplateConfig.setFromAddress("admin@test.com");
		emailTemplateConfig.setToAddress("mro@test.com");
		emailTemplateConfig.setSubject("Approval");
		emailTemplateConfig.setTemplateName("Approval template");
		return emailTemplateConfig;
	}

	@Test
	public void getEmailTemplateListTest() throws Exception {
		List<EmailTemplateConfig> emailTemplateList = new ArrayList<EmailTemplateConfig>();
		emailTemplateList.add(emailTemplateConfig());

		Mockito.when(emailTempService.getEmailTemplateList()).thenReturn(emailTemplateList);
		mvc.perform(get("/admin/emailTemplateList")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].subject", is("Approval")));
	}

	@Test
	public void saveEmailTemplateTest() throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("message", "Success");
		result.add(resultMap);

		Mockito.when(emailTempService.saveEmailTemplate(emailTemplateConfig())).thenReturn(resultMap);
		mvc.perform(post("/admin/saveEmailTemplate").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(emailTemplateConfig()))).andExpect(status().isCreated());
	}

	@Test
	public void getEmailTemplateByIdTest() throws Exception {
		Mockito.when(emailTempService.getEmailTemplateById(emailTemplateConfig().getTemplateId()))
				.thenReturn(emailTemplateConfig());
		mvc.perform(get("/admin/editEmailTemplate?templateId=1")).andExpect(status().isOk());
	}
}
