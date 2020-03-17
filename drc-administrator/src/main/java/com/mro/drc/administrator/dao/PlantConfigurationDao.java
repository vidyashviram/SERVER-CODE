package com.mro.drc.administrator.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.mro.drc.administrator.entity.LkupPlantConfiguration;


/**
 * @author 40008878
 * Repository to fetch, update details in to LkupPlantConfiguration table
 */
public interface PlantConfigurationDao extends JpaRepository<LkupPlantConfiguration, Integer> {

	/**
	 * @return : list from LkupPlantConfiguration
	 */
	@Query("from LkupPlantConfiguration order by plantid desc")
	List<LkupPlantConfiguration> getPlantConfigList();

	/**
	 * @param plantId : fetch details based on id from LkupPlantConfiguration
	 * @return : single record
	 */
	@Query("from LkupPlantConfiguration where plantId = :plantId")
	LkupPlantConfiguration getPlantConfigById(@RequestParam("plantId") Integer plantId);

	/**
	 * @param plantId : update record based on plant id
	 * @param isActive : true/false status 
	 * @param modifiedDate : current system date update to LkupPlantConfiguration table
	 */
	@Transactional
	@Modifying
	@Query("UPDATE LkupPlantConfiguration set active = :isActive, modifiedDate = :modifiedDate where plantId = :plantId")
	void activeOrDeactivePlantConfig(@RequestParam("plantId") Integer plantId,
			@RequestParam("isActive") boolean isActive, @RequestParam("modifiedDate") Date modifiedDate);

}