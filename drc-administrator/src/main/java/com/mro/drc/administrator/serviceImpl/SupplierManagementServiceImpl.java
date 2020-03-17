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

import com.mro.drc.administrator.dao.SupplierManagementDoa;
import com.mro.drc.administrator.dto.SupplierManagementFilter;
import com.mro.drc.administrator.entity.LkupSupplier;
import com.mro.drc.administrator.service.SupplierManagementService;

@Service
public class SupplierManagementServiceImpl implements SupplierManagementService {
	private static final Logger LOG = Logger.getLogger(SupplierManagementServiceImpl.class.getName());
	@Autowired
	private SupplierManagementDoa supplierManagementDoa;

	/**
	 * @return Get the list of supplier records
	 */
	@Override
	public List<SupplierManagementFilter> getSupplierList() {
		LOG.info("Inside getSupplierList");
		List<LkupSupplier> supplierListEntityresponse = supplierManagementDoa.getSupplierList();
		LOG.info("The response received by getSupplierList is " + supplierListEntityresponse);
		return getResponseEntity(supplierListEntityresponse);
	}

	/**
	 * @param supplierID
	 * @return Get the supplier details based on supplierId
	 * 
	 */
	@Override
	public List<SupplierManagementFilter> editSupplierManagementRecord(int supplierID) {
		LOG.info("Inside editSupplierManagementRecord");
		List<LkupSupplier> supplierListEntityresponse = supplierManagementDoa.getEditSupplierData(supplierID);
		LOG.info("The response received by editSupplierManagementRecord is " + supplierListEntityresponse);
		return getResponseEntity(supplierListEntityresponse);

	}

	/**
	 * @param supplierListEntityResult
	 * @return Get the response entity data
	 */
	private List<SupplierManagementFilter> getResponseEntity(List<LkupSupplier> supplierListEntityresponse) {
		LOG.info("Inside getResponseEntity");
		Iterator<LkupSupplier> iterator = supplierListEntityresponse.iterator();
		List<SupplierManagementFilter> supplierListResponse = new ArrayList<>();
		while (iterator.hasNext()) {
			LkupSupplier supplierListEntity = iterator.next();
			supplierListResponse.add(new SupplierManagementFilter(supplierListEntity.getSupplierName(),
					supplierListEntity.getSupplierEmail(), supplierListEntity.getSupplierAddress(),
					supplierListEntity.getSupplierId(), supplierListEntity.getSupplierPhone(),
					supplierListEntity.getCreatedDate(), supplierListEntity.getModifiedDate(),
					supplierListEntity.getActive()));
		}
		LOG.info("The response received by getResponseEntity is " + supplierListResponse);
		return supplierListResponse;
	}

	/**
	 * @param supplierUpdateRequest
	 * @return Save the new / update supplier details
	 */
	@Override
	public Map<String, String> saveRecords(LkupSupplier SupplierUpdateRequest) {
		LOG.info("Inside saveRecords");
		Map<String, String> response = new HashMap<String, String>();
		if (SupplierUpdateRequest != null) {

			supplierManagementDoa.save(SupplierUpdateRequest);
			response.put("message", "Success");
		} else {
			response.put("message", "Bad Request");
		}
		LOG.info("The response received by saveRecords is " + response);
		return response;
	}

	/**
	 * @param supplierID
	 * @return Change the supplier status to active /inactive and modify date
	 */
	@Override
	@Transactional
	public Map<String, String> deleteSupplierManagementRecord(int supplierID) {
		LOG.info("Inside deleteSupplierManagementRecord");
		Map<String, String> response = new HashMap<String, String>();

		if (supplierManagementDoa.existsById(supplierID)
				&& supplierManagementDoa.getEditSupplierData(supplierID).get(0).getActive()) {

			supplierManagementDoa.deleteSupplierData(supplierID, false, new Date());
			response.put("message", "Active");
		} else if (supplierManagementDoa.existsById(supplierID)
				&& !supplierManagementDoa.getEditSupplierData(supplierID).get(0).getActive()) {

			supplierManagementDoa.deleteSupplierData(supplierID, true, new Date());
			response.put("message", "Deactive");
		} else {
			response.put("message", "Bad Request");
		}
		LOG.info("The response received by deleteSupplierManagementRecord is " + response);
		return response;
	}
}
