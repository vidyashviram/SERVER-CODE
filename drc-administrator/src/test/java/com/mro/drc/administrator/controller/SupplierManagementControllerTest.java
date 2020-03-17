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
import com.mro.drc.administrator.controller.SupplierManagementController;
import com.mro.drc.administrator.dao.SupplierManagementDoa;
import com.mro.drc.administrator.dto.SupplierManagementFilter;
import com.mro.drc.administrator.entity.LkupSupplier;
import com.mro.drc.administrator.service.SupplierManagementService;

@SpringBootTest
public class SupplierManagementControllerTest {

	Date myDate = new Date(2014, 02, 11);
	@Mock
	private SupplierManagementService supplierManagementService;
	@Mock
	private SupplierManagementDoa supplierManagementDoa;

	@InjectMocks
	private SupplierManagementController supplierManagementController;

	private MockMvc mvc;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(supplierManagementController).dispatchOptions(true).build();
	}

	@Test
	public void getSupplierListTest() throws Exception {
		List<SupplierManagementFilter> json = new ArrayList<>();
		json.add(new SupplierManagementFilter("Rashmi", "appuuuuu@gmail.com", "IND", 3, "1112231111", myDate, myDate,
				true));
		Mockito.when(supplierManagementService.getSupplierList()).thenReturn(json);
		mvc.perform(get("/admin/supplierList")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].supplierName", is("Rashmi")));

	}

	@Test
	public void getSupplierEmptyListTest() throws Exception {
		Mockito.when(supplierManagementService.getSupplierList()).thenReturn(null);
		mvc.perform(get("/admin/supplierList")).andExpect(status().isBadRequest());
		verify(supplierManagementService, times(1)).getSupplierList();

	}

	@Test
	public void addSupplierRecordTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		LkupSupplier supplierAddRequest = new LkupSupplier();
		supplierAddRequest.setSupplierName("Apurva");
		supplierAddRequest.setSupplierAddress("IND");
		supplierAddRequest.setSupplierEmail("Apurva@gmail.com");
		supplierAddRequest.setSupplierPhone("12345678");
		// supplierAddRequest.setSupplierId(2);
		supplierAddRequest.setModifiedDate(new Date());
		supplierAddRequest.setCreatedDate(new Date());
		supplierAddRequest.setActive(true);
		List<Map<String, String>> customerResponse = new ArrayList();
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Success");
		customerResponse.add(response);
		Mockito.when(supplierManagementService.saveRecords(supplierAddRequest)).thenReturn(response);

		mvc.perform(post("/admin/addSupplierDetails").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(supplierAddRequest))).andExpect(status().isOk());

	}

	@Test
	public void updateSupplierRecordTest() throws Exception {
		ObjectMapper ObjectMapper = new ObjectMapper();
		LkupSupplier supplierAddRequest = new LkupSupplier();
		supplierAddRequest.setSupplierName("Apurva");
		supplierAddRequest.setSupplierAddress("IND");
		supplierAddRequest.setSupplierEmail("Apurva@gmail.com");
		supplierAddRequest.setSupplierPhone("12345678");
		// supplierAddRequest.setSupplierId(2);
		supplierAddRequest.setModifiedDate(new Date());
		supplierAddRequest.setCreatedDate(new Date());
		supplierAddRequest.setActive(true);
		List<Map<String, String>> customerResponse = new ArrayList();
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Success");
		customerResponse.add(response);
		Mockito.when(supplierManagementService.saveRecords(supplierAddRequest)).thenReturn(response);

		mvc.perform(post("/admin/updateSupplierDetails").contentType(MediaType.APPLICATION_JSON)
				.content(ObjectMapper.writeValueAsString(supplierAddRequest))).andExpect(status().isOk());

	}

	@Test
	public void editSupplierRecordTest() throws Exception {

		List<SupplierManagementFilter> json = new ArrayList<>();
		json.add(new SupplierManagementFilter("reja", "appuuuuu@gmail.com", "US", 4, "1112231111", myDate, myDate, true));

		Mockito.when(supplierManagementService.editSupplierManagementRecord(json.get(0).getSupplierId()))
				.thenReturn(json);

		mvc.perform(get("/admin/editSupplierDetails?supplierID=4")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].supplierId", is(4)));

	}

	@Test
	public void editSupplierNullRecordTest() throws Exception {
		List<SupplierManagementFilter> json = new ArrayList<>();
		json.add(new SupplierManagementFilter("reja", "appuuuuu@gmail.com", "US", 4, "1112231111", myDate, myDate, true));
		Mockito.when(supplierManagementService.editSupplierManagementRecord(json.get(0).getSupplierId()))
				.thenReturn(null);
		mvc.perform(get("/admin/editSupplierDetails?supplierID=4")).andExpect(status().isBadRequest());

	}

	@Test
	public void deleteSupplierRecordTest() throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		result.put("message", "Success");
		Mockito.when(supplierManagementService.deleteSupplierManagementRecord(4)).thenReturn(result);
		mvc.perform(get("/admin/deleteSupplierDetails?supplierID=4")).andExpect(status().isOk());

	}

}
