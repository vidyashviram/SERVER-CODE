package com.mro.drc.userroles.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.mro.drc.userroles.dto.RoleDropdown;
import com.mro.drc.userroles.dto.UserFilter;
import com.mro.drc.userroles.entity.Users;
import com.mro.drc.userroles.service.UserManagementService;

/**
 * @author 20126160
 *Controller class to provide Rest APIs to perform actions on User 
 */
@RestController
public class UserManagementController implements ErrorController {

	@Autowired
	private UserManagementService userManagementService;

	private static final String PATH = "/error";

	/**
	 * @return
	 * To handle the error scenarios when there is bad request
	 */
	@RequestMapping(value = PATH)
	public String error() {
		return "There is no mapping for this Rest end point";
	}
   
	/**
	 *To return then path for rest end point
	 */
	@Override
	public String getErrorPath() {
		return PATH;
	}            

	// list
	/**
	 * @return
	 * @throws Exception
	 * Rest API to get user data 
	 */
	@GetMapping(value = "/admin/getUserData")
	public ResponseEntity<List<UserFilter>> userData() throws Exception {
		List<UserFilter> result = userManagementService.getUserData();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * @return
	 * @throws Exception
	 * Rest API to get the roles drop down data
	 */
	@RequestMapping(value = "/admin/roleDropDown")
	public ResponseEntity<List<Map<String, List<RoleDropdown>>>> roleDropDown() throws Exception {
		List<Map<String, List<RoleDropdown>>> result = new ArrayList<Map<String, List<RoleDropdown>>>();
		result.add(userManagementService.getRoles());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * @param userData
	 * @return
	 * @throws Exception
	 * Rest API to save the user data
	 */
	@PostMapping("/admin/saveUserData")
	public ResponseEntity<List<Map<String, String>>> saveUserData(@RequestBody Users userData) throws Exception {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		result.add(userManagementService.saveUserData(userData));
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	/**
	 * @param userId
	 * @param status
	 * @return
	 * @throws Exception
	 * Rest API to deactivate the user
	 */
	@GetMapping("/admin/deleteUserData")
	public ResponseEntity<List<Map<String, String>>> deleteUserData(@RequestParam Integer userId, boolean status)
			throws Exception {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		if (userId != null) {
			result.add(userManagementService.deleteUser(userId, status));
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
 
	/**
	 * @param userId
	 * @return
	 * @throws Exception
	 * Rest API to get the user data to edit
	 */
	@GetMapping("/admin/onClickEditUserData")
	public ResponseEntity<List<UserFilter>> onClickEditUserData(@RequestParam Integer userId) throws Exception {
		List<UserFilter> result = new ArrayList<UserFilter>();
		result.add(userManagementService.getUserDataToEdit(userId));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
