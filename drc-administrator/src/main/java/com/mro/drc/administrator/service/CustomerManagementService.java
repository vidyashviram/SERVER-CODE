package com.mro.drc.administrator.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.administrator.dto.CustomerManagementFilter;
import com.mro.drc.administrator.entity.LkupCustomer;

/**
 * @author 20126161
 *
 */
public interface CustomerManagementService {

	List<CustomerManagementFilter> getCustumerList();

	//Map<String, String> addCustomerManagementRecord(LkupCustomer customerData);

	List<CustomerManagementFilter> editCustomerManagementRecord(int customerID);

	Map<String, String> saveRecords(LkupCustomer customerRequestData);

	Map<String, String> deleteCustomerManagementRecord(int customerID);

}
