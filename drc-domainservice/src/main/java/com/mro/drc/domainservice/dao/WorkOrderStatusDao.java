package com.mro.drc.domainservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mro.drc.domainservice.domain.WorkOrderStatus;

/**
 * @author 40008878
 *
 */
public interface WorkOrderStatusDao extends JpaRepository<WorkOrderStatus, Integer> {

	
	/**
	 * @return Work status list from WorkOrderStatus table
	 */ 
	@Query("from WorkOrderStatus")
	List<WorkOrderStatus> getAllWorkOrderStatus();

}
