package com.mro.drc.administrator.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mro.drc.administrator.controller.SmtpServerConfigController;
import com.mro.drc.administrator.dao.SmtpServerConfigDao;
import com.mro.drc.administrator.entity.SmtpServerConfig;
import com.mro.drc.administrator.service.SmtpServerConfigService;

@SpringBootTest
public class SmtpServerConfigControllerTest {

	private MockMvc mvc;
	@Mock
	private SmtpServerConfigService smtpServerConfigService;
	@Mock
	private SmtpServerConfigDao smtpServerConfigDao;
	@InjectMocks
	private SmtpServerConfigController smtpServerConfigController;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(smtpServerConfigController).dispatchOptions(true).build();
	}

	public SmtpServerConfig smtpServerConfigDate() {
		SmtpServerConfig smtpServerConfigData = new SmtpServerConfig();
		smtpServerConfigData.setId(1);
		smtpServerConfigData.setSmtpServer("mySql");
		smtpServerConfigData.setPort("8080");
		smtpServerConfigData.setPassword("xyz");
		smtpServerConfigData.setUserName("User1");
		return smtpServerConfigData;
	}

	@Test
	public void addSMTPServerDetailsTest() throws Exception {
		ObjectMapper ObjectMapper = new ObjectMapper();
		List<Map<String, String>> customerResponse = new ArrayList<>();
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Success");
		customerResponse.add(response);
		Mockito.when(smtpServerConfigService.addSmtpServerRecord(smtpServerConfigDate())).thenReturn(response);
		mvc.perform(post("/admin/addSmtpServerDetails").contentType(MediaType.APPLICATION_JSON)
				.content(ObjectMapper.writeValueAsString(smtpServerConfigDate()))).andExpect(status().isOk());
	}

	@Test
	public void getSMTPServerListTest() throws Exception {
		List<SmtpServerConfig> list = new ArrayList<SmtpServerConfig>();
		list.add(smtpServerConfigDate());
		Mockito.when(smtpServerConfigService.getSMTPServerList()).thenReturn(list);
		mvc.perform(get("/admin/getSMTPServerList")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].userName", is("User1")));
	}

	@Test
	public void getSMTPserverByIdTest() throws Exception {

		Mockito.when(smtpServerConfigService.getSMTPserverById(smtpServerConfigDate().getId()))
				.thenReturn(smtpServerConfigDate());
		String result = mvc.perform(get("/admin/getSMTPServerById?id=1")).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();
		ResponseEntity<Map<String, SmtpServerConfig>> response = smtpServerConfigController.getSMTPserverById(1);
		assertTrue(result.contains("mySql"));
		assertEquals("User1", response.getBody().get("plantConfigRecord").getUserName());
	}
}
