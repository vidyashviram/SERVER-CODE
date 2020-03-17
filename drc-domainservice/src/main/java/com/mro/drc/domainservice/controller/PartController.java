package com.mro.drc.domainservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.domainservice.dto.PartNamesListDto;
import com.mro.drc.domainservice.dto.PartNumbersListDto;
import com.mro.drc.domainservice.service.PartService;

/**
 * @author 40008878 Rest Controller for Parts Module
 */
/**
 * @author 40008878
 *
 */
@RestController
public class PartController {
	@Autowired
	private PartService partServ;

	/**
	 * @return Unique Part Names List
	 * @throws Exception
	 */
	@RequestMapping("/getPartNameList")
	public ResponseEntity<Map<String, List<PartNamesListDto>>> getPartNameList() throws Exception {

		return new ResponseEntity<>(partServ.getPartNameList(), HttpStatus.OK);
	}

	
	/**
	 * @param partName : To fetch Part numbers based on part names
	 * @return : Part numbers list
	 * @throws Exception
	 */
	@RequestMapping("/getPartNumList")
	public ResponseEntity<Map<String, List<PartNumbersListDto>>> getPartNumList(@RequestParam String partName) throws Exception {

		return new ResponseEntity<>(partServ.getPartNumList(partName), HttpStatus.OK);
	}
}
