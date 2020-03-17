package com.mro.drc.lkupservice.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.lkupservice.dao.LkupPlantConfigurationDao;
import com.mro.drc.lkupservice.dto.PlantConfigurationNumDto;
import com.mro.drc.lkupservice.lookup.LkupPlantConfiguration;
import com.mro.drc.lkupservice.service.LkupPlantConfigurationService;

/**
 * @author 20126161
 *
 */
@Service
public class LkupPlantConfigurationServiceImpl implements LkupPlantConfigurationService {

	@Autowired
	private LkupPlantConfigurationDao lkupPlantConfigurationDao;

	/**
	 * To fetch plant configuration details
	 */
	@Override
	public Map<String, List<PlantConfigurationNumDto>> getLkupPlantConfig() {
		Map<String, List<PlantConfigurationNumDto>> plantConfigMap = new HashMap<>();
		try {
			List<LkupPlantConfiguration> plantConfigList = lkupPlantConfigurationDao.getAllPlantConfigurationList();
			List<PlantConfigurationNumDto> plantConfigResponse = new ArrayList<>();
			for (LkupPlantConfiguration entry : plantConfigList) {
				plantConfigResponse.add(new PlantConfigurationNumDto(entry.getPlantNum(), entry.getPartName()));
			}
			plantConfigMap.put("plantConfigList", plantConfigResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plantConfigMap;
	}

}
