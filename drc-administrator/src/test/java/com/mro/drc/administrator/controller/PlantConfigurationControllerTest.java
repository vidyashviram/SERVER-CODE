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
import com.mro.drc.administrator.controller.PlantConfigurationController;
import com.mro.drc.administrator.entity.LkupPlantConfiguration;
import com.mro.drc.administrator.service.PlantConfigurationService;

@SpringBootTest
public class PlantConfigurationControllerTest {

	private MockMvc mvc;
	Date date = new Date(2014, 02, 11);

	@Mock
	private PlantConfigurationService plantConfigService;

	@InjectMocks
	private PlantConfigurationController plantController;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(plantController).dispatchOptions(true).build();
	}

	public List<LkupPlantConfiguration> setPlantConfigDetails() {
		List<LkupPlantConfiguration> plantConfigList = new ArrayList<LkupPlantConfiguration>();
		LkupPlantConfiguration pc1 = new LkupPlantConfiguration();
		pc1.setPlantId(1);
		pc1.setPlantName("MRO Solution UK");
		pc1.setPlantNum("MRO258963");
		pc1.setDistributionchannel("Non Aerospace");
		pc1.setDivision("Main Unit");
		pc1.setLocation("UK");
		pc1.setModifiedDate(date);
		pc1.setReceiveddate(date);
		pc1.setSalesorg("0001111");
		pc1.setTemplate("Repair");
		pc1.setType("Repair Process");

		LkupPlantConfiguration pc2 = new LkupPlantConfiguration();
		pc2.setPlantId(2);
		pc2.setPlantName("MRO Solution Us");
		pc2.setPlantNum("MRO1111");
		pc2.setDistributionchannel("Commercial");
		pc2.setDivision("Tier Unit");
		pc2.setLocation("US");
		pc2.setModifiedDate(date);
		pc2.setReceiveddate(date);
		pc2.setSalesorg("0002222");
		pc2.setTemplate("Repair Create");
		pc2.setType("Repair Process");

		plantConfigList.add(pc1);
		plantConfigList.add(pc2);
		return plantConfigList;
	}

	@Test
	public void getPlantConfigListTest() throws Exception {

		Mockito.when(plantConfigService.getPlantConfigList()).thenReturn(setPlantConfigDetails());
		mvc.perform(get("/admin/plantConfigListPage")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].plantName", is("MRO Solution UK")));
		mvc.perform(get("/admin/plantConfigListPage")).andExpect(status().isOk())
				.andExpect(jsonPath("$[1].template", is("Repair Create")));
		mvc.perform(get("/admin/plantConfigListPage")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].division", is("Main Unit")));
	}

	@Test
	public void savePlantConfigRecordTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, String>> customerResponse = new ArrayList<>();
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Success");
		customerResponse.add(response);
		Mockito.when(plantConfigService.savePlantConfigRecord(setPlantConfigDetails().get(0))).thenReturn(response);
		mvc.perform(post("/admin/savePlantConfig").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(setPlantConfigDetails().get(0)))).andExpect(status().isCreated());
	}

	@Test
	public void getPlantConfigEditFormTest() throws Exception {

		Mockito.when(plantConfigService.getPlantConfigRecordById(setPlantConfigDetails().get(0).getPlantId())).thenReturn(setPlantConfigDetails().get(0));
		mvc.perform(get("/admin/editPlantConfigForm?plantId=1")).andExpect(status().isOk());
	}

	@Test
	public void activeOrDeactivePlantConfigTest() throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		result.put("message", "Success");
		Mockito.when(plantConfigService.activeOrDeactivePlantConfig(4,true)).thenReturn(result);
		mvc.perform(get("/admin/deactivePlantConfig?plantId=1&isActive=true")).andExpect(status().isOk());
	}

}
