package com.mro.drc.administrator.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import com.mro.drc.administrator.controller.CustomerManagementController;
import com.mro.drc.administrator.dao.CustomerManagementDao;
import com.mro.drc.administrator.dto.CustomerManagementFilter;
import com.mro.drc.administrator.entity.LkupCustomer;
import com.mro.drc.administrator.service.CustomerManagementService;

@SpringBootTest
class CustomerManagementControllerTest {
	Date myDate = new Date(2014, 02, 11);
	private MockMvc mvc;
	@Mock
	private CustomerManagementService customerManagementService;
	@Mock
	private CustomerManagementDao customerManagementDoa;
	@InjectMocks
	private CustomerManagementController customerManagementController;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(customerManagementController).dispatchOptions(true).build();
	}

	@Test
	public void getCustumerListTest() throws Exception {

		List<CustomerManagementFilter> json = new ArrayList<>();
		json.add(new CustomerManagementFilter("Rashmi", "appuuuuu@gmail.com", "IND", 3, "1112231111", "1001", myDate,
				myDate, "lnt", "hebbal", true));
		Mockito.when(customerManagementService.getCustumerList()).thenReturn(json);
		mvc.perform(get("/admin/customerList")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].custName", is("Rashmi")));
		// assertEquals(3, json.get(0).getCustid());
		// verify(customerManagementService, times(1)).getCustumerList();
	}

	@Test
	public void getCustumerEmptyListTest() throws Exception {

		Mockito.when(customerManagementService.getCustumerList()).thenReturn(null);
		mvc.perform(get("/admin/customerList")).andExpect(status().isBadRequest());
		verify(customerManagementService, times(1)).getCustumerList();
	}

	@Test
	public void addCustomerRecordTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		LkupCustomer customerAddRequest = new LkupCustomer();
		customerAddRequest.setCustName("Apurva");
		customerAddRequest.setCustEmail("apurva.reja2gmail.com");
		// customerAddRequest.setCustid(4);
		customerAddRequest.setCustPhone("11212548");
		customerAddRequest.setCustAddress("IND");
		customerAddRequest.setCustNum("1011");
		customerAddRequest.setModifiedDate(myDate);
		customerAddRequest.setCreatedDate(myDate);
		customerAddRequest.setActive(false);
		customerAddRequest.setBillTo("LNT");
		customerAddRequest.setShipTo("Delta");
		List<Map<String, String>> customerResponse = new ArrayList();
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Success");
		customerResponse.add(response);
		Mockito.when(customerManagementService.saveRecords(customerAddRequest)).thenReturn(response);
		mvc.perform(post("/admin/addCustomerDetails").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(customerAddRequest))).andExpect(status().isOk());
		// assertEquals("Success", result.get("message"));
//		verify(customerManagementService, times(1)).addCustomerManagementService(customerAddRequest);
	}

	@Test
	public void updateCustomerRecordTest() throws Exception {
		ObjectMapper ObjectMapper = new ObjectMapper();
		LkupCustomer customerAddRequest = new LkupCustomer();
		customerAddRequest.setCustName("Apurva1");
		customerAddRequest.setCustEmail("apurva.reja2gmail.com");
		customerAddRequest.setCustid(4);
		customerAddRequest.setCustPhone("11212548");
		customerAddRequest.setCustAddress("IND");
		customerAddRequest.setCustNum("1011");
		customerAddRequest.setModifiedDate(myDate);
		customerAddRequest.setCreatedDate(myDate);
		customerAddRequest.setActive(false);
		customerAddRequest.setBillTo("LNT");
		customerAddRequest.setShipTo("Delta");

		List<Map<String, String>> customerResponse = new ArrayList();
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Success");
		customerResponse.add(response);
		Mockito.when(customerManagementService.saveRecords(customerAddRequest)).thenReturn(response);

		mvc.perform(post("/admin/updateCustomerDetails").contentType(MediaType.APPLICATION_JSON)
				.content(ObjectMapper.writeValueAsString(customerAddRequest))).andExpect(status().isOk());
		// assertEquals("Success", result.get("message"));
//		verify(customerManagementService, times(1)).addCustomerManagementService(customerAddRequest);
	}

	@Test
	public void editCustomerRecordTest() throws Exception {

		List<CustomerManagementFilter> json = new ArrayList<>();
		json.add(new CustomerManagementFilter("reja", "appuuuuu@gmail.com", "US", 4, "1112231111", "1002", myDate,
				myDate, "delta", "lnt", true));

		Mockito.when(customerManagementService.editCustomerManagementRecord(json.get(0).getCustid())).thenReturn(json);

		mvc.perform(get("/admin/editCustomerDetails?customerID=4")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].custid", is(4)));
		// assertEquals(4, json.get(0).getCustid());
//		verify(customerManagementService, times(1)).addCustomerManagementService(customerAddRequest);
	}

	@Test
	public void editCustomerNullRecordTest() throws Exception {
		List<CustomerManagementFilter> json = new ArrayList<>();
		json.add(new CustomerManagementFilter("reja", "appuuuuu@gmail.com", "US", 4, "1112231111", "1002", myDate,
				myDate, "delta", "lnt", true));

		Mockito.when(customerManagementService.editCustomerManagementRecord(json.get(0).getCustid())).thenReturn(null);
		mvc.perform(get("/admin/editCustomerDetails?customerID=4")).andExpect(status().isBadRequest());

	}

	@Test
	public void deleteCustomerRecordTest() throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		result.put("message", "Success");
		Mockito.when(customerManagementService.deleteCustomerManagementRecord(4)).thenReturn(result);
		mvc.perform(get("/admin/deleteCustomerDetails?customerID=4")).andExpect(status().isOk());
		// .andExpect(jsonPath("$.message", is("Success")));
	}

}
