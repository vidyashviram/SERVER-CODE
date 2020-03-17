package com.mro.drc.lkupservice.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.lkupservice.dto.CustomersListDto;

public interface LkupCustomerService {

	Map<String, List<CustomersListDto>> getLkupCustomers(String customerData) throws Exception;

	//Map<String, List<CustomersListDto>> getLkupCustomerPo() throws Exception;

	

}
