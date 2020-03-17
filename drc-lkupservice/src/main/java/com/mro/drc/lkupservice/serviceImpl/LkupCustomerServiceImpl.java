package com.mro.drc.lkupservice.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.lkupservice.dao.LkupCustomerDao;
import com.mro.drc.lkupservice.dto.CustomersListDto;
import com.mro.drc.lkupservice.lookup.LkupCustomer;
import com.mro.drc.lkupservice.service.LkupCustomerService;

/**
 * @author 40008878
 *
 */
@Service
public class LkupCustomerServiceImpl implements LkupCustomerService {

	@Autowired
	private LkupCustomerDao custDao;

	/**
	 * To fetch customer details for customer drop down in search page.
	 */
	@Override
	public Map<String, List<CustomersListDto>> getLkupCustomers(String customerData) throws Exception {
		Map<String, List<CustomersListDto>> customerMap = new HashMap<>();
		try {
			List<LkupCustomer> customerList = custDao.getAllCustomersList();
			List<CustomersListDto> customerResponse = new ArrayList<>();
			for (LkupCustomer entry : customerList) {
				customerResponse.add(new CustomersListDto(entry.getCustid(), entry.getCustName()));
			}
			customerMap.put(customerData, customerResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerMap;
	}

	

}
