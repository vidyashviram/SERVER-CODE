package com.mro.drc.workflow.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mro.drc.workflow.domain.GatesCount;

//import com.mro.drc.entities.*;



/**
 * @author 20126160 Repository class to perform CRUD operations on GatesCount Table in
 *         SQL Database
 *
 */
public interface GatesCountDao extends JpaRepository<GatesCount, Integer> {
	

}
	