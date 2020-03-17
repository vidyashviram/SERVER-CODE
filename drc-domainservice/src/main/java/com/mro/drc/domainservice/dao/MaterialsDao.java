package com.mro.drc.domainservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mro.drc.domainservice.domain.Materials;

/**
 * @author 40008878
 *
 */
public interface MaterialsDao extends JpaRepository<Materials, Integer>{
	
	/**
	 * @return Material list from Materials Table
	 */
	@Query("from Materials")
	List<Materials> getAllMaterialList();
}
