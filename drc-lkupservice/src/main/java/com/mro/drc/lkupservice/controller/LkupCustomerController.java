package com.mro.drc.lkupservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.lkupservice.dto.CustomersListDto;
import com.mro.drc.lkupservice.service.LkupCustomerService;

/**
 * @author 40008878
 *
 */
@RestController
public class LkupCustomerController implements ErrorController {

	@Autowired
	private LkupCustomerService custServ;

	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error() {
		return "There is no mapping for this Rest end point";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

	/**
	 * @return : Customer drop down list
	 * @throws Exception 
	 */
	@RequestMapping("/getLkupCustomers")
	public ResponseEntity<Map<String, List<CustomersListDto>>> getLkupCustomers() throws Exception {

		return new ResponseEntity<>(custServ.getLkupCustomers("customersList"), HttpStatus.OK);
	}

//	/**
//	 * @return : CustomerPo drop down list
//	 * @throws Exception
//	 */
//	@RequestMapping("/getLkupCustomersPo")
//	public ResponseEntity<Map<String, List<CustomersListDto>>> getLkupCustomersPo() throws Exception {
//	
//		return new ResponseEntity<>(custServ.getLkupCustomers("customersPo"), HttpStatus.OK);
//	}
}
