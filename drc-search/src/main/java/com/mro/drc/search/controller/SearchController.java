package com.mro.drc.search.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.search.dto.WordOrderFilterResponse;
import com.mro.drc.search.dto.WorkOrderFilterCriteria;
import com.mro.drc.search.dto.WorkOrdersListDto;
import com.mro.drc.search.service.SearchService;

/**
 * @author 40008878
 * Rest Controller for Search Functionality
 *
 */
@RestController
public class SearchController implements ErrorController {

	@Autowired
	private SearchService searchService;

	private static final String PATH = "/error";

	/**
	 * @return
	 */
	@RequestMapping(value = PATH)
	public String error() {
		return "There is no mapping for this Rest end point";
	}

	/**
	 *
	 */
	@Override
	public String getErrorPath() {
		return PATH;
	}

	/**
	 * @return: work order drop down list for search page
	 */
	@RequestMapping("/getWorkOrderSearchList")
	public ResponseEntity<Map<String, List<WorkOrdersListDto>>> getWorkOrderList() throws Exception{
		return new ResponseEntity<>(searchService.getWorkOrderList(), HttpStatus.OK);
	}

	
	/**
	 * @param filterCriteria : Drop down filter request for search
	 * @return : Response based on the filterCriteria
	 * @throws Exception
	 */
	@PostMapping("/getSearchResponse")
	public ResponseEntity<List<WordOrderFilterResponse>> getSearchResponse(
			@RequestBody WorkOrderFilterCriteria filterCriteria) throws Exception {
		return new ResponseEntity<>(searchService.getSearchResponse(filterCriteria), HttpStatus.OK);
	}

}
