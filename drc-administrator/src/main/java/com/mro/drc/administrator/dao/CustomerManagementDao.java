package com.mro.drc.administrator.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mro.drc.administrator.entity.LkupCustomer;

/**
 * @author 20126161
 *
 */
public interface CustomerManagementDao extends JpaRepository<LkupCustomer, Integer> {

	/**
	 * @return Query to get the list of customers
	 */
	@Query("FROM LkupCustomer")
	List<LkupCustomer> getCustumerList();

	/**
	 * @param custid
	 * @return Query to get the details of customer based on customerId
	 */
	@Query("FROM LkupCustomer c where c.custid= :custid")
	List<LkupCustomer> getEditCustumerData(@Param("custid") Integer custid);

	/**
	 * @param custid
	 * @param active
	 * @param modifieddate
	 * Query to modify the active /inactive status and modified date based on customer id
	 */

	@Modifying
	@Query(value = "Update LkupCustomer set active= :active,modifieddate= :modifieddate  where custid= :custid", nativeQuery = true)
	void deleteCustumerData(@Param("custid") Integer custid, @Param("active") boolean active,
			@Param("modifieddate") Date modifieddate);

}
