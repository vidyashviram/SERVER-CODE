package com.mro.drc.administrator.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.administrator.entity.LkupPlantConfiguration;

/**
 * @author 40008878
 *
 */
public interface PlantConfigurationService {

	List<LkupPlantConfiguration> getPlantConfigList() throws Exception;

	Map<String, String> savePlantConfigRecord(LkupPlantConfiguration plantConfig) throws Exception;

	LkupPlantConfiguration getPlantConfigRecordById(Integer plantId) throws Exception;

	Map<String, String> activeOrDeactivePlantConfig(Integer plantId, boolean isActive) throws Exception;
}
