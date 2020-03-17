package com.mro.drc.search.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.mro.drc.search.domain.Materials;
import com.mro.drc.search.domain.Parts;
import com.mro.drc.search.domain.WorkOrderEntry;

/**
 * @author 40008878
 *
 */
public interface SearchDao extends JpaRepository<WorkOrderEntry, Integer>, JpaSpecificationExecutor<WorkOrderEntry> {

	/**
	 * @return : All work orders from WorkOrderEntry table
	 */
	@Query("from WorkOrderEntry")
	List<WorkOrderEntry> getAllWorkOrdersList();

}
