package com.mro.drc.administrator.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.administrator.dto.CustomerManagementFilter;
import com.mro.drc.administrator.entity.LkupCustomer;
import com.mro.drc.administrator.service.CustomerManagementService;

/**
 * @author 20126161 This controller class will provide Rest APIs.
 *
 */
@RestController
public class CustomerManagementController implements ErrorController {
	private static final Logger LOG = Logger.getLogger(CustomerManagementController.class.getName());
	@Autowired
	private CustomerManagementService customerManagementService;

	private static final String PATH = "/error";

	/**
	 * @return Handles the error when there is no mapping for the client request
	 */
	@RequestMapping(value = PATH)
	public String error() {
		return "There is no mapping for this Rest end point";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

	/**
	 * @return List<CustomerManagementFilter> response
	 * @throws Exception Rest API to get the list of customer
	 */
	@GetMapping(value = "/admin/customerList")
	public ResponseEntity<List<CustomerManagementFilter>> getCustumerList() throws Exception {
		LOG.info("Inside getCustumerList");
		List<CustomerManagementFilter> response = customerManagementService.getCustumerList();

		if (response != null) {
			LOG.info("The response received by getCustumerList is " + response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			LOG.info("The response received by getCustumerList is " + response);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * @param customerDataRequest This will map the RequestBody Data with entity
	 * @return customerAddRequest
	 */
	public LkupCustomer getRequestData(LkupCustomer customerDataRequest) {
		LOG.info("Inside getRequestData");
		LkupCustomer customerAddRequest = new LkupCustomer();
		if (customerDataRequest.getCustid() != null) {
			customerAddRequest.setCustid(customerDataRequest.getCustid());
			customerAddRequest.setCreatedDate(customerDataRequest.getCreatedDate());
		} else {
			customerAddRequest.setCreatedDate(new Date());
		}
		customerAddRequest.setCustName(customerDataRequest.getCustName());
		customerAddRequest.setCustEmail(customerDataRequest.getCustEmail());
		customerAddRequest.setCustPhone(customerDataRequest.getCustPhone());
		customerAddRequest.setCustAddress(customerDataRequest.getCustAddress());
		customerAddRequest.setCustNum(customerDataRequest.getCustNum());
		customerAddRequest.setBillTo(customerDataRequest.getBillTo());
		customerAddRequest.setShipTo(customerDataRequest.getShipTo());
		customerAddRequest.setModifiedDate(new Date());
		customerAddRequest.setActive(true);
		LOG.info("The response received by getRequestData is " + customerAddRequest);
		return customerAddRequest;

	}

	/**
	 * @param customerDataRequest
	 * @return custumerListResponse
	 * @throws Exception Rest API to add the new customer details
	 */
	@PostMapping("/admin/addCustomerDetails")
	public ResponseEntity<List<Map<String, String>>> addCustomerRecord(@RequestBody LkupCustomer customerDataRequest)
			throws Exception {
		LOG.info("Inside addCustomerRecord");
		List<Map<String, String>> custumerListResponse = new ArrayList<>();
		Map<String, String> response = customerManagementService.saveRecords(getRequestData(customerDataRequest));
		custumerListResponse.add(response);
		LOG.info("The response received by addCustomerRecord is " + custumerListResponse);
		return new ResponseEntity<>(custumerListResponse, HttpStatus.OK);

	}

	/**
	 * @param customerID
	 * @return List<CustomerManagementFilter> response
	 * @throws Exception Rest API to get the customer details based on customerID
	 */
	@GetMapping("/admin/editCustomerDetails")
	public ResponseEntity<List<CustomerManagementFilter>> editCustomerRecord(@RequestParam int customerID)
			throws Exception {
		LOG.info("Inside editCustomerRecord");
		List<CustomerManagementFilter> response = customerManagementService.editCustomerManagementRecord(customerID);
		if (response != null) {
			LOG.info("The response received by editCustomerRecord is " + response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			LOG.info("The response received by editCustomerRecord is " + response);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * @param customerDataRequest
	 * @return custumerListResponse
	 * @throws Exception Rest API to update the customer details based on customerID
	 */
	@PostMapping("/admin/updateCustomerDetails")
	public ResponseEntity<List<Map<String, String>>> updateCustomerRecord(@RequestBody LkupCustomer customerDataRequest)
			throws Exception {
		LOG.info("Inside updateCustomerRecord");
		List<Map<String, String>> custumerListResponse = new ArrayList<>();
		Map<String, String> response = customerManagementService.saveRecords(getRequestData(customerDataRequest));
		custumerListResponse.add(response);
		LOG.info("The response received by updateCustomerRecord is " + custumerListResponse);
		return new ResponseEntity<>(custumerListResponse, HttpStatus.OK);
	}

	/**
	 * @param customerID
	 * @return custumerListResponse
	 * @throws Exception Rest API to Active/InActive the customer status based on
	 *                   customerID
	 */
	@GetMapping("/admin/deleteCustomerDetails")
	public ResponseEntity<List<Map<String, String>>> deleteCustomerRecord(@RequestParam int customerID)
			throws Exception {
		LOG.info("Inside deleteCustomerRecord");
		List<Map<String, String>> custumerListResponse = new ArrayList<>();
		Map<String, String> response = customerManagementService.deleteCustomerManagementRecord(customerID);
		custumerListResponse.add(response);
		LOG.info("The response received by deleteCustomerRecord is " + custumerListResponse);
		return new ResponseEntity<>(custumerListResponse, HttpStatus.OK);

	}
}
