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
import com.mro.drc.administrator.controller.DbServerConfigController;
import com.mro.drc.administrator.dao.DbServerConfigDao;
import com.mro.drc.administrator.entity.DbServerConfig;
import com.mro.drc.administrator.service.DbServerConfigService;

@SpringBootTest
public class DbServerConfigControllerTest {

	private MockMvc mvc;
	@Mock
	private DbServerConfigService dbServerConfigService;
	@Mock
	private DbServerConfigDao dbServerConfigDao;
	@InjectMocks
	private DbServerConfigController dbServerConfigController;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(dbServerConfigController).dispatchOptions(true).build();
	}

	public DbServerConfig dbServerConfigData() {
		DbServerConfig dbServerConfigData = new DbServerConfig();
		dbServerConfigData.setId(1);
		dbServerConfigData.setDataBaseName("mySql");
		dbServerConfigData.setDbUrl("www.test.com");
		dbServerConfigData.setPassword("xyz");
		dbServerConfigData.setUserName("User1");
		return dbServerConfigData;
	}

	@Test
	public void addDbServerDetailsTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, String>> customerResponse = new ArrayList<>();
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Success");
		customerResponse.add(response);
		Mockito.when(dbServerConfigService.addDbServerRecord(dbServerConfigData())).thenReturn(response);
		mvc.perform(post("/admin/addDbServerDetails").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(dbServerConfigData()))).andExpect(status().isOk());
	}

	@Test
	public void getDBServerListTest() throws Exception {
		List<DbServerConfig> dbConfigList = new ArrayList<DbServerConfig>();
		dbConfigList.add(dbServerConfigData());
		Mockito.when(dbServerConfigService.getDBServerList()).thenReturn(dbConfigList);
		mvc.perform(get("/admin/getDBServerConfigList")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].dataBaseName", is("mySql")));
	}

	@Test
	public void getDbServerConfigById() throws Exception {
		Mockito.when(dbServerConfigService.getDbServerConfigById(dbServerConfigData().getId()))
				.thenReturn(dbServerConfigData());
		String result = mvc.perform(get("/admin/getDbServerConfigById?id=1")).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		ResponseEntity<Map<String, DbServerConfig>> response = dbServerConfigController.getDbServerConfigById(1);
		assertTrue(result.contains("mySql"));
		assertEquals("User1", response.getBody().get("dbConfig").getUserName());
		
	}

}
