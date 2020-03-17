package com.mro.drc.administrator.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mro.drc.administrator.dao.PlantConfigurationDao;
import com.mro.drc.administrator.entity.LkupPlantConfiguration;
import com.mro.drc.administrator.serviceImpl.PlantConfigurationServiceImpl;

public class PlantConfigurationServiceImplTest {

	@Mock
	private PlantConfigurationDao plantConfigDao;

	@InjectMocks
	private PlantConfigurationServiceImpl plantService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	Date date = new Date(2014, 02, 11);

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

		Mockito.when(plantConfigDao.getPlantConfigList()).thenReturn(setPlantConfigDetails());
		List<LkupPlantConfiguration> plantConfigList = plantService.getPlantConfigList();
		assertEquals("US", plantConfigList.get(1).getLocation());
	}

	@Test
	public void savePlantConfigRecordTest() throws Exception {

		LkupPlantConfiguration plantConfig = setPlantConfigDetails().get(0);
		Mockito.when(plantConfigDao.saveAndFlush(plantConfig)).thenReturn(plantConfig);
		Map<String, String> result1 = plantService.savePlantConfigRecord(plantConfig);
		assertEquals("Success", result1.get("message"));
	}
	
	@Test
	public void savePlantConfigNullRecordTest() throws Exception {

		Mockito.when(plantConfigDao.saveAndFlush(setPlantConfigDetails().get(0))).thenReturn(null);
		Map<String, String> response = plantService.savePlantConfigRecord(null);
		assertEquals("Bad Request", response.get("message"));

	}

	@Test
	public void getPlantConfigRecordByIdTest() throws Exception {
		Mockito.when(plantConfigDao.getPlantConfigById(setPlantConfigDetails().get(0).getPlantId())).thenReturn(setPlantConfigDetails().get(0));
		LkupPlantConfiguration plantConfig = plantService.getPlantConfigRecordById(setPlantConfigDetails().get(0).getPlantId());
		assertEquals(1, plantConfig.getPlantId());
	}

	@Test
	public void activeOrDeactivePlantConfigTest() throws Exception {
		doNothing().when(plantConfigDao).activeOrDeactivePlantConfig(4,true,new Date());
		assertEquals("Success", plantService.activeOrDeactivePlantConfig(1, true).get("message"));	
	}

}
