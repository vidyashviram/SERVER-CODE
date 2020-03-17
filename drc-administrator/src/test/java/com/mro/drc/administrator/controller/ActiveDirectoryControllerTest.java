package com.mro.drc.administrator.controller;

import static org.hamcrest.CoreMatchers.is;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mro.drc.administrator.controller.ActiveDirectoryController;
import com.mro.drc.administrator.entity.LdapServerConfig;
import com.mro.drc.administrator.service.ActiveDirectoryService;

@SpringBootTest
public class ActiveDirectoryControllerTest {

	private MockMvc mvc;
	@Mock
	private ActiveDirectoryService activeDirectoryService;

	@InjectMocks
	private ActiveDirectoryController ldapController;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(ldapController).dispatchOptions(true).build();
	}

	public LdapServerConfig ldapServer() {
		LdapServerConfig ldapServerConfig = new LdapServerConfig();
		ldapServerConfig.setDomain("domain1");
		ldapServerConfig.setDomaIndir("domainIndir1");
		ldapServerConfig.setDomaIndirGroup("domainIndirGroup1");
		ldapServerConfig.setDomaiNext("domainIndir2");
		ldapServerConfig.setHost("localhost");
		ldapServerConfig.setId(1);
		ldapServerConfig.setProtocol("TCP");
		ldapServerConfig.setServicePassword("test");
		ldapServerConfig.setServiceUserName("admin");
		return ldapServerConfig;
	}

	@Test
	public void addCustomerRecordTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		List<Map<String, String>> customerResponse = new ArrayList<>();
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Success");
		customerResponse.add(response);
		Mockito.when(activeDirectoryService.addLdapServerRecord(ldapServer())).thenReturn(response);
		mvc.perform(post("/admin/addLdapServerDetails").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(ldapServer()))).andExpect(status().isCreated());

	}

	@Test
	public void getLdapListTest() throws Exception {
		List<LdapServerConfig> ldapList = new ArrayList<LdapServerConfig>();
		ldapList.add(ldapServer());
		Mockito.when(activeDirectoryService.getLdapList()).thenReturn(ldapList);
		mvc.perform(get("/admin/getLdapList")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].protocol", is("TCP")));
	}

	@Test
	public void getLdapDetailsByIdTest() throws Exception {
		Mockito.when(activeDirectoryService.getLdapDetailsById(ldapServer().getId())).thenReturn(ldapServer());
		mvc.perform(get("/admin/getLdapDetailsbyId?id=1")).andExpect(status().isOk());
	}
}
