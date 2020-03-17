package com.mro.drc.administrator.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.administrator.dto.SupplierManagementFilter;
import com.mro.drc.administrator.entity.LkupSupplier;

/**
 * @author 20126161
 *
 */
public interface SupplierManagementService {

	List<SupplierManagementFilter> getSupplierList();

	List<SupplierManagementFilter> editSupplierManagementRecord(int supplierID);

	Map<String, String> saveRecords(LkupSupplier supplierUpdateRequest);

	Map<String, String> deleteSupplierManagementRecord(int supplierID);

}
