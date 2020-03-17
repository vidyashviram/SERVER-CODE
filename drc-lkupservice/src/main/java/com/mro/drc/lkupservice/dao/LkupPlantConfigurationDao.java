package com.mro.drc.lkupservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mro.drc.lkupservice.lookup.LkupPlantConfiguration;

/**
 * @author 20126161
 *
 */
public interface LkupPlantConfigurationDao extends JpaRepository<LkupPlantConfiguration, Integer> {

	@Query("from LkupPlantConfiguration")
	List<LkupPlantConfiguration> getAllPlantConfigurationList();



}
