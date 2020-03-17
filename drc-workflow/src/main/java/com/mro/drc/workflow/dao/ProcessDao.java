package com.mro.drc.workflow.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mro.drc.workflow.domain.MroProcess;

//import com.mro.drc.entities.*;











/**
 * @author 20126160 Repository class to perform CRUD operations on MroProcess Table in
 *         SQL Database
 *
 */
public interface ProcessDao extends JpaRepository<MroProcess, Integer> {

	/**
	 * @return Fetch all the details from process table
	 */
	@Query("FROM MroProcess")
	List<MroProcess> getProcessDetails();
	


}
