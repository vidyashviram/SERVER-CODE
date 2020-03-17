package com.mro.drc.dashboard.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mro.drc.dashboard.domain.WorkOrderEntry;


/**
 * @author 20126160 This DAO class is used to get the data from DB using
 *         queries.
 */
public interface DashboardDao extends JpaRepository<WorkOrderEntry, Integer>, JpaSpecificationExecutor<WorkOrderEntry> {

	// Dashboard Count Queries

	/**
	 * @param priority
	 * @return 
	 * Query to fetch workorder count of the given priority from
	 *         WorkOrderEntry table
	 */
	@Query("SELECT COUNT(*) FROM WorkOrderEntry w where w.priority= :priority")
	Integer getCountOfHighPriorityRecords(@Param("priority") String priority);

	/**
	 * @param repair
	 * @return 
	 * Query to fetch the Workorder count the given status from
	 *         WorkOrderEntry table
	 */
	@Query("SELECT COUNT(*) FROM WorkOrderEntry w where w.receiving.workOrderStatus.statusDesc= :repair")
	Integer getCountOfRepairRecords(@Param("repair") String repair);

	/**
	 * @return Query to fetch the all workorder details from WorkOrderEntry table
	 */
	@Query("SELECT COUNT(*) FROM WorkOrderEntry")
	Integer getCountOfOpenWorkOrderRecords();

	/**
	 * @return Query to fetch workorder details where the customerId of
	 *         WorkOrderEntry and Customer will match
	 */
	@Query("SELECT COUNT(*) FROM WorkOrderEntry w, Customer c where w.customer.customerId = c.customerId")
	Integer getCountOfCustomerCountRecords();

	// Dashboard Data Queries

	/**
	 * @param priority
	 * @return
	 *  Query to fetch high priority workorder details of the given priority from
	 *         WorkOrderEntry table
	 */
	@Query("FROM WorkOrderEntry w where w.priority= :priority")
	List<WorkOrderEntry> getHighPriorityRecords(@Param("priority") String priority);

	/**
	 * @param repair
	 * @return 
	 * Query to fetch repair records which matches the given status value from
	 *         WorkOrderEntry table
	 */
	@Query("FROM WorkOrderEntry w where w.receiving.workOrderStatus.statusDesc= :repair")
	List<WorkOrderEntry> getRepairRecords(@Param("repair") String repair);

	/**
	 * @return 
	 * Query to fetch open workorder details from WorkOrderEntry table
	 */
	@Query("FROM WorkOrderEntry")
	List<WorkOrderEntry> getOpenWorkOrderRecords();

	/**
	 * @return
	 * Query to fetch customer details  where the customerId of
	 *         WorkOrderEntry and Customer will match
	 */
	@Query("FROM WorkOrderEntry w, Customer c where w.customer.customerId = c.customerId")
	List<WorkOrderEntry> getCustomerRecords();

}
