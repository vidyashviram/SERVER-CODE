package com.mro.drc.administrator.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.administrator.dao.PlantConfigurationDao;
import com.mro.drc.administrator.entity.LkupPlantConfiguration;
import com.mro.drc.administrator.service.PlantConfigurationService;

/**
 * @author 40008878 SERVICE implemented to fetch, save, active/in-activate the
 *         details from database
 */
@Service
public class PlantConfigurationServiceImpl implements PlantConfigurationService {
	private static final Logger LOG = Logger.getLogger(PlantConfigurationServiceImpl.class.getName());
	@Autowired
	private PlantConfigurationDao plantConfigDao;

	/**
	 * To fetch all the plant configuration records
	 */
	@Override
	public List<LkupPlantConfiguration> getPlantConfigList() throws Exception {
		LOG.info("Inside getPlantConfigList");
		List<LkupPlantConfiguration> plantConfigList = new ArrayList<>();
		try {
			plantConfigList = plantConfigDao.getPlantConfigList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("The response received by getPlantConfigList is " + plantConfigList);
		return plantConfigList;
	}

	/**
	 * to save or update the plant configuration details to table
	 */
	@Override
	public Map<String, String> savePlantConfigRecord(LkupPlantConfiguration plantConfig) throws Exception {
		LOG.info("Inside savePlantConfigRecord");
		Map<String, String> result = new HashMap<String, String>();
		try {
			if (plantConfig != null) {
				plantConfigDao.saveAndFlush(plantConfig);
				result.put("message", "Success");
			} else {
				result.put("message", "Bad Request");
			}
		} catch (Exception e) {
			result.put("message", "Failure");
			e.printStackTrace();
		}
		LOG.info("The response received by savePlantConfigRecord is " + result);
		return result;
	}

	/**
	 * To get the records based on plant id
	 */
	@Override
	public LkupPlantConfiguration getPlantConfigRecordById(Integer plantId) throws Exception {

		LOG.info("Inside getPlantConfigRecordById");
		LkupPlantConfiguration plantConfigData = new LkupPlantConfiguration();
		try {
			plantConfigData = plantConfigDao.getPlantConfigById(plantId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("The response received by getPlantConfigRecordById is " + plantConfigData);
		return plantConfigData;
	}

	/**
	 * to update the records based on active or inactive status
	 */
	@Override
	public Map<String, String> activeOrDeactivePlantConfig(Integer plantId, boolean isActive) throws Exception {
		LOG.info("Inside activeOrDeactivePlantConfig");
		Map<String, String> result = new HashMap<String, String>();
		try {
			plantConfigDao.activeOrDeactivePlantConfig(plantId, isActive, new Date());
			result.put("message", "Success");
		} catch (Exception e) {
			result.put("message", "Failure");
			e.printStackTrace();
		}
		LOG.info("The response received by activeOrDeactivePlantConfig is " + result);
		return result;
	}

}
