package com.mro.drc.administrator.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.administrator.dto.SupplierManagementFilter;
import com.mro.drc.administrator.entity.LkupSupplier;
import com.mro.drc.administrator.service.SupplierManagementService;

/**
 * @author 20126161 This controller class will provide Rest APIs.
 *
 */
@RestController
public class SupplierManagementController {
	private static final Logger LOG = Logger.getLogger(SupplierManagementController.class.getName());
	@Autowired
	private SupplierManagementService supplierManagementService;

	/**
	 * @return List<SupplierManagementFilter> response
	 * @throws Exception Rest API to get the list of supplier
	 */
	@GetMapping(value = "/admin/supplierList")
	public ResponseEntity<List<SupplierManagementFilter>> getSupplierList() throws Exception {
		LOG.info("Inside getSupplierList");
		List<SupplierManagementFilter> response = supplierManagementService.getSupplierList();
		if (response != null) {
			LOG.info("The response received by getSupplierList is " + response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			LOG.info("The response received by getSupplierList is " + response);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * @param supplierDataRequest
	 * @return
	 * @throws Exception Rest API to add the new supplier details
	 */
	@PostMapping("/admin/addSupplierDetails")
	public ResponseEntity<List<Map<String, String>>> addSupplierRecord(@RequestBody LkupSupplier supplierDataRequest)
			throws Exception {
		LOG.info("Inside addSupplierRecord");
		List<Map<String, String>> supplierListResponse = new ArrayList<>();
		Map<String, String> response = supplierManagementService.saveRecords(getRequestData(supplierDataRequest));
		supplierListResponse.add(response);
		LOG.info("The response received by addSupplierRecord is " + supplierListResponse);
		return new ResponseEntity<>(supplierListResponse, HttpStatus.OK);

	}

	/**
	 * @param supplierDataRequest
	 * @return
	 */
	private LkupSupplier getRequestData(LkupSupplier supplierDataRequest) {
		LOG.info("Inside getRequestData");
		LkupSupplier supplierAddRequest = new LkupSupplier();
		if (supplierDataRequest.getSupplierId() != null) {
			supplierAddRequest.setSupplierId(supplierDataRequest.getSupplierId());
			supplierAddRequest.setCreatedDate(supplierDataRequest.getCreatedDate());
		} else {
			supplierAddRequest.setCreatedDate(new Date());
		}
		supplierAddRequest.setSupplierName(supplierDataRequest.getSupplierName());
		supplierAddRequest.setSupplierAddress(supplierDataRequest.getSupplierAddress());
		supplierAddRequest.setSupplierEmail(supplierDataRequest.getSupplierEmail());
		supplierAddRequest.setSupplierPhone(supplierDataRequest.getSupplierPhone());
		supplierAddRequest.setModifiedDate(new Date());
		supplierAddRequest.setActive(true);
		LOG.info("The response received by getRequestData is " + supplierAddRequest);
		return supplierAddRequest;

	}

	/**
	 * @param supplierID
	 * @return
	 * @throws Exception Rest API to get the supplier details based on supplierID
	 */
	@GetMapping("/admin/editSupplierDetails")
	public ResponseEntity<List<SupplierManagementFilter>> editSupplierRecord(@RequestParam int supplierID)
			throws Exception {
		LOG.info("Inside editSupplierRecord");
		List<SupplierManagementFilter> response = supplierManagementService.editSupplierManagementRecord(supplierID);
		if (response != null) {
			LOG.info("The response received by editSupplierRecord is " + response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			LOG.info("The response received by editSupplierRecord is " + response);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * @param supplierDataRequest
	 * @return
	 * @throws Exception Rest API to update the supplier details based on supplierID
	 */
	@PostMapping("/admin/updateSupplierDetails")
	public ResponseEntity<List<Map<String, String>>> updateSupplierRecord(@RequestBody LkupSupplier supplierDataRequest)
			throws Exception {
		LOG.info("Inside updateSupplierRecord");
		List<Map<String, String>> supplierListResponse = new ArrayList<>();
		Map<String, String> response = supplierManagementService.saveRecords(getRequestData(supplierDataRequest));
		supplierListResponse.add(response);
		LOG.info("The response received by updateSupplierRecord is " + supplierListResponse);
		return new ResponseEntity<>(supplierListResponse, HttpStatus.OK);

	}

	/**
	 * @param supplierID
	 * @return Rest API to Active/InActive the supplier status based on supplierID
	 */
	@GetMapping("/admin/deleteSupplierDetails")
	public ResponseEntity<List<Map<String, String>>> deleteSupplierRecord(@RequestParam int supplierID) {
		LOG.info("Inside deleteSupplierRecord");
		List<Map<String, String>> supplierListResponse = new ArrayList<>();

		Map<String, String> response = supplierManagementService.deleteSupplierManagementRecord(supplierID);
		supplierListResponse.add(response);
		LOG.info("The response received by deleteSupplierRecord is " + supplierListResponse);
		return new ResponseEntity<>(supplierListResponse, HttpStatus.OK);

	}
}
