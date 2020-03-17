package com.mro.drc.userroles.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mro.drc.userroles.dao.RoleManagementDao;
import com.mro.drc.userroles.entity.Roles;
import com.mro.drc.userroles.service.RoleManagementService;

/**
 * @author 20126160
 * Service implemenation class to perform CRUD operations on Role Table
 *
 */
@Service
public class RoleManagementServiceImpl implements RoleManagementService {

	@Autowired
	private RoleManagementDao roleManagementDao;

	/**
	 *To get the Role Details from Role table
	 */
	@Override
	public List<Roles> getRoleData() throws Exception {
		List<Roles> roles = roleManagementDao.getRolesDetails();
		return roles;
	}

	/**
	 *Saves role record into role table
	 */
	@Override
	public Map<String, String> saveRoleData(Roles roleData) {
		if (roleData.getRoleId() == null) {
			roleData.setCreatedDate(new Date()); 
			roleData.setActive(true);
		}
		roleData.setModifiedDate(new Date());
		Map<String, String> response = new HashMap<String, String>();
		System.out.println(roleManagementDao.save(roleData));
		if (roleManagementDao.save(roleData) != null) {
			response.put("message", "Success");
		} else {
			response.put("message", "Failure");
		}
		return response;
	}
 
	/**
	 *To deactivate the Role record
	 */
	@Override

	@Transactional
	public Map<String, String> deleteRoles(Integer roleId, boolean status) {
		Map<String, String> response = new HashMap<String, String>();
		if (roleManagementDao.existsById(roleId)) {
			roleManagementDao.deleteRoleData(roleId, status, new Date());
			response.put("message", "Success");
		} else {
			response.put("message", "There is no record with the given Id");
		}
		return response;
	}

	/**
	 *To get the role details from the Roles table of given role Id
	 */
	@Override
	public List<Roles> getRoleDataToEdit(Integer roleId) {
		if (roleManagementDao.existsById(roleId)) {
			List<Roles> res = roleManagementDao.getRoleDataToEdit(roleId);
			return res;
		} else {
			return null;
		}
	}

}
