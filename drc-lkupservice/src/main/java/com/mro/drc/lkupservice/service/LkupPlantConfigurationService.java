package com.mro.drc.lkupservice.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.lkupservice.dto.PlantConfigurationNumDto;

/**
 * @author 20126161
 *
 */
public interface LkupPlantConfigurationService {

	Map<String, List<PlantConfigurationNumDto>> getLkupPlantConfig();

}
