package com.mro.drc.workflow.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mro.drc.workflow.domain.GatesProcess;

//import com.mro.drc.entities.*;




/**
 * @author 20126160 Repository class to perform CRUD operations on GateProcess Table in
 *         SQL Database
 *
 */
public interface GateProcessDao extends JpaRepository<GatesProcess, Integer> {
	

}
