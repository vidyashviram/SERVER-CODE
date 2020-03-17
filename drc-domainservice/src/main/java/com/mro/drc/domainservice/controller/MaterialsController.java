package com.mro.drc.domainservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.domainservice.dto.MaterialListDto;
import com.mro.drc.domainservice.service.MaterialsService;

/**
 * @author 40008878
 * Rest Controller for Material
 */
@RestController
public class MaterialsController {
	@Autowired
	private MaterialsService materialServ;

	/**
	 * @return Material drop down list
	 * @throws Exception
	 */
	@RequestMapping("/getMaterialList")
	public ResponseEntity<Map<String, List<MaterialListDto>>> getMaterialList() throws Exception {
		return new ResponseEntity<>(materialServ.getMaterialList(), HttpStatus.OK);
	}
}
