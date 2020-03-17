package com.mro.drc.search.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mro.drc.search.dto.WordOrderFilterResponse;
import com.mro.drc.search.dto.WorkOrderFilter;
import com.mro.drc.search.dto.WorkOrderFilterCriteria;
import com.mro.drc.search.dto.WorkOrdersListDto;
import com.mro.drc.search.service.SearchService;

@SpringBootTest
public class SearchControllerTest {

	@Mock
	private SearchService searchService;

	@InjectMocks
	private SearchController searchController;

	private MockMvc mvc;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(searchController).dispatchOptions(true).build();
	}

	@Test
	public void getWorkOrderListTest() throws Exception {

		Mockito.when(searchService.getWorkOrderList()).thenReturn(getFilterDropdowns());
		mvc.perform(get("/getWorkOrderSearchList")).andExpect(status().isOk());

		int size = searchController.getWorkOrderList().getBody().get("workorder").size();
		assertEquals(2, size);
	}

	public Map<String, List<WorkOrdersListDto>> getFilterDropdowns() {
		Map<String, List<WorkOrdersListDto>> filter = new HashMap<>();

		List<WorkOrdersListDto> workorder = new ArrayList<>();
		workorder.add(new WorkOrdersListDto(100, 100));
		workorder.add(new WorkOrdersListDto(200, 200));

		filter.put("workorder", workorder);

		return filter;
	}

	@Test
	public void getSearchResponseTest() throws Exception {
		Date date1 = new Date(11, 02, 2020);
		Date date2 = new Date(12, 02, 2020);
		WorkOrderFilterCriteria filterCriteria = new WorkOrderFilterCriteria();
		WorkOrderFilter workOrderFilter = new WorkOrderFilter();
		workOrderFilter.setCustName("British Airlines");
		workOrderFilter.setDistributionChannelId(1);
		workOrderFilter.setFromDate(date1);
		workOrderFilter.setGateStatus(1);
		workOrderFilter.setMaterial("Iron");
		workOrderFilter.setPartName(1);
		workOrderFilter.setPartNum(1);
		workOrderFilter.setToDate(date2);
		workOrderFilter.setWorkOrderId(100);
		filterCriteria.setWorkOrderFilter(workOrderFilter);

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/getSearchResponse")
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(filterCriteria));

		List<WordOrderFilterResponse> response = new ArrayList<WordOrderFilterResponse>();
		response.add(new WordOrderFilterResponse(100, date1, "tier", "High", "Normal Repair", "jahnavi", "part_01",
				"Iron", "Commercial / Aerospace"));
		Mockito.when(searchService.getSearchResponse(filterCriteria)).thenReturn(response);

		System.out.println("Search Controller"
				+ searchController.getSearchResponse(filterCriteria).getBody().get(0).getCustomerName());
//
//		assertEquals("jahna",
//				searchController.getWorkOrdersBasedOnFilter(filterCriteria).getBody().get(0).getClassification());

		this.mvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
}
