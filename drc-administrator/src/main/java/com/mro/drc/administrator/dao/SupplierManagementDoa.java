package com.mro.drc.administrator.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mro.drc.administrator.entity.LkupSupplier;

/**
 * @author 20126161
 *
 */
public interface SupplierManagementDoa extends JpaRepository<LkupSupplier, Integer> {

	/**
	 * @return
	 * Query to get the list of supplier
	 */
	@Query("FROM LkupSupplier")
	List<LkupSupplier> getSupplierList();

	/**
	 * @param supplierId
	 * @return
	 * Query to get the details of supplier based on supplierId
	 */
	@Query("FROM LkupSupplier c where c.supplierId= :supplierId")
	List<LkupSupplier> getEditSupplierData(@Param("supplierId") Integer supplierId);

	/**
	 * @param supplierId
	 * @param active
	 * @param modifieddate
	 * Query to modify the active /inactive status and modified date based on supplierId
	 */
	@Modifying
	@Query(value = "Update LkupSupplier set active= :active,modifieddate= :modifieddate where supplierId= :supplierId", nativeQuery = true)
	void deleteSupplierData(@Param("supplierId") Integer supplierId, @Param("active") boolean active,
			@Param("modifieddate") Date modifieddate);

}
