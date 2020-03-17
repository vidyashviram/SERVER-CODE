package com.mro.drc.domainservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.domainservice.dto.DistributionChannelListDto;
import com.mro.drc.domainservice.service.DistributionChannelService;
/**
 * @author 40008878
 * Rest Controller for Distribution Channel
 */
@RestController
public class DistributionChannelController implements ErrorController{

	@Autowired
	private DistributionChannelService distServ;

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
	 * @return Distribution Channel Drop down list
	 * @throws Exception
	 */
	@RequestMapping("/getDistChannelList")
	public ResponseEntity<Map<String, List<DistributionChannelListDto>>> getDistChannelList() throws Exception{
		return new ResponseEntity<>(distServ.getDistChannelList(), HttpStatus.OK);
	}
}
