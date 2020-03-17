package com.mro.drc.domainservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.mro.drc.domainservice.domain.Parts;

public interface PartDao extends JpaRepository<Parts, Integer>{

	/**
	 * @return Distinct Part names from Parts table
	 */
	@Query("SELECT distinct partName, MIN(partId) as partId FROM Parts group by partName")
	List<Object[]> getAllPartList();
	
	/**
	 * @param partName : Fetch part numbers based on names
	 * @return : part numbers from parts table
	 */
	@Query("From Parts where partName =:partName")
	List<Parts> getPartNumByPartName(@RequestParam("partName") String partName);
}
