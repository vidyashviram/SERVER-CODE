package com.mro.drc.administrator.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mro.drc.administrator.dao.CustomerManagementDao;
import com.mro.drc.administrator.dto.CustomerManagementFilter;
import com.mro.drc.administrator.entity.LkupCustomer;
import com.mro.drc.administrator.service.CustomerManagementService;

/**
 * @author 20126161
 *
 */
@Service
public class CustomerManagementServiceImpl implements CustomerManagementService {
	private static final Logger LOG = Logger.getLogger(CustomerManagementServiceImpl.class.getName());
	@Autowired
	private CustomerManagementDao customerManagementDoa;

	/**
	 * @return Get the list of customer records
	 */
	@Override
	public List<CustomerManagementFilter> getCustumerList() {
		LOG.info("Inside getCustumerList");
		List<LkupCustomer> custumerListEntityResult = customerManagementDoa.getCustumerList();
		LOG.info("The response received by getCustumerList is " + custumerListEntityResult);
		return getResponseEntity(custumerListEntityResult);
	}

	/**
	 * @param customerID
	 * @return Get the customer details based on customerId
	 */
	@Override
	public List<CustomerManagementFilter> editCustomerManagementRecord(int customerID) {
		LOG.info("Inside editCustomerManagementRecord");
		List<LkupCustomer> custumerListEntityResult = customerManagementDoa.getEditCustumerData(customerID);
		LOG.info("The response received by editCustomerManagementRecord is " + custumerListEntityResult);
		return getResponseEntity(custumerListEntityResult);
	}

	/**
	 * @param custumerListEntityResult
	 * @return Get the response entity data
	 */
	private List<CustomerManagementFilter> getResponseEntity(List<LkupCustomer> custumerListEntityResult) {
		LOG.info("Inside getResponseEntity");
		Iterator<LkupCustomer> iterator = custumerListEntityResult.iterator();
		List<CustomerManagementFilter> custumerListResponse = new ArrayList<>();
		while (iterator.hasNext()) {
			LkupCustomer custumerListEntity = iterator.next();
			custumerListResponse.add(new CustomerManagementFilter(custumerListEntity.getCustName(),
					custumerListEntity.getCustEmail(), custumerListEntity.getCustAddress(),
					custumerListEntity.getCustid(), custumerListEntity.getCustPhone(), custumerListEntity.getCustNum(),
					custumerListEntity.getCreatedDate(), custumerListEntity.getModifiedDate(),
					custumerListEntity.getBillTo(), custumerListEntity.getShipTo(), custumerListEntity.isActive()));
		}
		LOG.info("The response received by getResponseEntity is " + custumerListResponse);
		return custumerListResponse;

	}

	/**
	 * @param customerUpdateRequest
	 * @return save the new / update details of customer
	 * 
	 */
	@Override
	public Map<String, String> saveRecords(LkupCustomer customerUpdateRequest) {
		LOG.info("Inside saveRecords");
		Map<String, String> result = new HashMap<String, String>();
		if (customerUpdateRequest != null) {
			customerManagementDoa.save(customerUpdateRequest);
			result.put("message", "Success");

		} else {
			result.put("message", "Bad Request");
		}
		LOG.info("The response received by saveRecords is " + result);
		return result;
	}

	/**
	 * @param customerID
	 * @return Change the customer status to active /inactive and modify date
	 * 
	 */
	@Override
	@Transactional
	public Map<String, String> deleteCustomerManagementRecord(int customerID) {
		LOG.info("Inside deleteCustomerManagementRecord");
		Map<String, String> result = new HashMap<String, String>();

		if (customerManagementDoa.existsById(customerID)
				&& customerManagementDoa.getEditCustumerData(customerID).get(0).isActive()) {

			customerManagementDoa.deleteCustumerData(customerID, false, new Date());
			result.put("message", "Deactive");
		} else if (customerManagementDoa.existsById(customerID)
				&& !customerManagementDoa.getEditCustumerData(customerID).get(0).isActive()) {

			customerManagementDoa.deleteCustumerData(customerID, true, new Date());
			result.put("message", "Active");
		} else {
			result.put("message", "Bad Request");
		}
		LOG.info("The response received by deleteCustomerManagementRecord is " + result);
		return result;
	}

}
