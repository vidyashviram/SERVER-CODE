
package com.mro.drc.dashboard.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mro.drc.dashboard.dto.WordOrderFilterResponse;
import com.mro.drc.dashboard.service.DashboardService;

@SpringBootTest
class DashboardControllerTest {

	private MockMvc mvc;

	@Mock
	private DashboardService dashBoardService;

	@InjectMocks
	private DashboardController dashboardController;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(dashboardController).dispatchOptions(true).build();
	}

	public List<WordOrderFilterResponse> workOrderFilterResponse() {
		List<WordOrderFilterResponse> response = new ArrayList<>();
		Date myDate = new Date(2014, 02, 11);
		response.add(new WordOrderFilterResponse(101, myDate, "Normal Repair", "tier", "High", "British Airlines",
				"part_01"));
		response.add(new WordOrderFilterResponse(100, myDate, "Normal Repair", "tier", "Low", "British Airlines",
				"part_02"));
		return response;
	}

	@Test
	public void repairCount() throws Exception {
		Map<String, Integer> dashboard = new HashMap<>();
		Mockito.when(dashBoardService.getCountOfRepairRecords()).thenReturn(7);
		dashboard.put("repairCount", dashBoardService.getCountOfRepairRecords());
		Mockito.when(dashBoardService.getCountOfHighPriorityRecords()).thenReturn(6);
		dashboard.put("highPriority", dashBoardService.getCountOfHighPriorityRecords());
		Mockito.when(dashBoardService.getCountOfOpenWorkOrderRecords()).thenReturn(10);
		Mockito.when(dashBoardService.getCountOfCustomerCountRecords()).thenReturn(5);
		mvc.perform(get("/dashboardCount")).andExpect(status().isOk());
		assertEquals(6, dashboardController.getDashboardCount().getBody().get("highPriority"));
		assertEquals(7, dashboardController.getDashboardCount().getBody().get("repairCount"));
	}

	@Test
	public void highPriorityData() throws Exception {
		Mockito.when(dashBoardService.getHighPriorityRecords()).thenReturn(workOrderFilterResponse());
		mvc.perform(get("/highPriorityData")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].priority", is("High")));
		verify(dashBoardService, times(1)).getHighPriorityRecords();
		assertTrue(dashboardController.getHighPriorityData().getBody().get(0).getCustomerName()
				.equalsIgnoreCase("British Airlines"));
	}

	@Test
	public void repairData() throws Exception {
		Mockito.when(dashBoardService.getRepairRecords()).thenReturn(workOrderFilterResponse());
		mvc.perform(get("/repairData")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].gateStatus", is("Normal Repair")));
		verify(dashBoardService, times(1)).getRepairRecords();
	}

	@Test
	public void repairCount1() throws Exception {
		Mockito.when(dashBoardService.getCountOfRepairRecords()).thenReturn(7);
		Mockito.when(dashBoardService.getCountOfHighPriorityRecords()).thenReturn(6);
		Mockito.when(dashBoardService.getCountOfOpenWorkOrderRecords()).thenReturn(10);
		Mockito.when(dashBoardService.getCountOfCustomerCountRecords()).thenReturn(5);
		mvc.perform(get("/dashboardCount")).andExpect(status().isOk());
	}

	@Test
	public void openWrokOrderDetailsTest() throws Exception {
		Mockito.when(dashBoardService.getOpenWorkOrderRecords()).thenReturn(workOrderFilterResponse());
		mvc.perform(get("/openWorkOrdersData")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].workOrderId", is(101))).andExpect(jsonPath("$[1].workOrderId", is(100)));
		verify(dashBoardService, times(1)).getOpenWorkOrderRecords();
	}

	@Test
	public void openWrokOrderDetailsStatus() throws Exception {
		mvc.perform(get("/openWorkOrdersData")).andExpect(status().is(200));
	}

	@Test
	public void customerDataTest() throws Exception {
		Mockito.when(dashBoardService.getCustomerRecords()).thenReturn(workOrderFilterResponse());
		mvc.perform(get("/customerData")).andExpect(status().isOk()).andExpect(jsonPath("$[0].workOrderId", is(101)));
		verify(dashBoardService, times(1)).getCustomerRecords();
	}
}
