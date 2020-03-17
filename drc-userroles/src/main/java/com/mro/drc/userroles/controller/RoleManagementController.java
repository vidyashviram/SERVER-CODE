package com.mro.drc.userroles.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mro.drc.userroles.entity.Roles;
import com.mro.drc.userroles.service.RoleManagementService;

/**
 * @author 20126160
 * Controller to provide Rest APIs to perform actiond on Role
 *
 */
@RestController
public class RoleManagementController {

	@Autowired
	private RoleManagementService roleManagementService;

	// list
	/**
	 * @return
	 * @throws Exception
	 * Rest API to get Roles Data
	 */
	@GetMapping(value = "/admin/getRoleData")
	public ResponseEntity<List<Roles>> getRoleData() throws Exception {
		List<Roles> result = roleManagementService.getRoleData();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}    
	
	/**
	 * @param roleData
	 * @return
	 * @throws Exception
	 * Rest API to save Role Data
	 */
	@PostMapping("/admin/saveRoleData")
	public ResponseEntity<List<Map<String, String>>> saveRoleData(@RequestBody Roles roleData) throws Exception {
		System.out.println("Entered");
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		result.add(roleManagementService.saveRoleData(roleData));
		System.out.println(result);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	/**
	 * @param roleId
	 * @param status
	 * @return
	 * @throws Exception
	 * Rest API to deactivate the Role 
	 */
	@GetMapping("/admin/deleteRoleData")
	public ResponseEntity<List<Map<String, String>>> deleteRoleData(@RequestParam Integer roleId, boolean status) throws Exception {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		if (roleId != null) {
			result.add(roleManagementService.deleteRoles(roleId, status));
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * @param roleId
	 * @return
	 * @throws Exception
	 * Rest API to get the Role Data to edit
	 */
	@GetMapping("/admin/onClickEditRoleData")
	public ResponseEntity<List<Roles>> onClickEditRoleData(@RequestParam Integer roleId) throws Exception {
		List<Roles> result = roleManagementService.getRoleDataToEdit(roleId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
