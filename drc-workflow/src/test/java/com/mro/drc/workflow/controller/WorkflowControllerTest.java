package com.mro.drc.workflow.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.mro.drc.workflow.domain.GatesCount;
import com.mro.drc.workflow.domain.GatesProcess;
import com.mro.drc.workflow.domain.MroProcess;
import com.mro.drc.workflow.service.WorkflowManagementService;

@SpringBootTest
class WorkflowControllerTest {

	private MockMvc mvc;

	@Mock
	private WorkflowManagementService workflowManagementService;

	@InjectMocks
	private WorkflowController workflowController;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(workflowController).dispatchOptions(true).build();
	}

	@Test
	public void getProcessData() throws Exception {
		List<MroProcess> result = new ArrayList<MroProcess>();
		MroProcess process1 = new MroProcess();
		process1.setProcessId(1);
		process1.setProcessName("Warrenty");
		MroProcess process2 = new MroProcess();
		process2.setProcessId(1);
		process2.setProcessName("Warrenty");
		result.add(process1);
		result.add(process2);
		Mockito.when(workflowManagementService.getProcessData()).thenReturn(result);
		mvc.perform(get("/workflow/getProcessData")).andExpect(status().isOk());
	}

	@Test
	public void saveGateCount() throws Exception {
		GatesCount gatesCount = new GatesCount();
		gatesCount.setGatesCount(2);
		Map<String, String> res = new HashMap<String, String>();
		res.put("message", "Success");
		Mockito.when(workflowManagementService.saveGateCount(gatesCount)).thenReturn(res);
		mvc.perform(post("/workflow/saveGateCount").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(gatesCount))).andExpect(status().isOk());
	}

	@Test
	public void saveGateProcess() throws Exception {
		List<GatesProcess> result = new ArrayList<GatesProcess>();
   
		GatesProcess gatesProcess1 = new GatesProcess();
		gatesProcess1.setGatesName("Gate 0");
		gatesProcess1.setId(1);
		gatesProcess1.setProcessName("Warranty,Workorders");

		GatesProcess gatesProcess2 = new GatesProcess();
		gatesProcess2.setGatesName("Gate 1");
		gatesProcess2.setId(2);
		gatesProcess2.setProcessName("CMM,Repairs");

		result.add(gatesProcess1);
		result.add(gatesProcess2);

		Map<String, String> res = new HashMap<String, String>();
		res.put("message", "Success");
		Mockito.when(workflowManagementService.saveGateProcessData(result)).thenReturn(res);
		mvc.perform(post("/workflow/saveGateProcess").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(result))).andExpect(status().isOk());
	}
}
