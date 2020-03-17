package com.mro.drc.userroles.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mro.drc.userroles.dao.UserManagementDao;
import com.mro.drc.userroles.dto.RoleDropdown;
import com.mro.drc.userroles.dto.UserFilter;
import com.mro.drc.userroles.entity.Roles;
import com.mro.drc.userroles.entity.Users;
import com.mro.drc.userroles.service.UserManagementService;

/**
 * @author 20126160
 * To perform CRUD operations on User Table
 */
@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserManagementDao userManagementDao;

	/**
	 *To fetch user records from User table
	 */
	@Override
	public List<UserFilter> getUserData() throws Exception {
		List<Users> userData = userManagementDao.getUserDetails();
		List<UserFilter> userResponse = new ArrayList<UserFilter>();
		for (Users entry : userData) {
			userResponse.add(new UserFilter(entry.getUserId(),entry.getUserName(), entry.isActive(), entry.getUserRole().getRoleId(),
					entry.getEmail(), entry.getUserRole().getRoleName(), entry.getCreateddate(),
					entry.getModifiedDate()));
		}
  
		return userResponse;
	}

	/**
	 * Save the new User Data/to save the updated details of User
	 */
	@Override
	public Map<String, String> saveUserData(Users users) {
		if (users.getUserId() == null) {
			users.setCreateddate(new Date());
			users.setActive(true);
		}
		users.setModifiedDate(new Date());
		Map<String, String> res = new HashMap<String, String>();
		if (userManagementDao.save(users) != null) {
			res.put("message", "Success");  
		}
		return res;
	}

	/**
	 *To deactivate the given user record by changing the status columnn
	 */
	@Override
	@Transactional
	public Map<String, String> deleteUser(Integer userId, boolean status) {
		Map<String, String> response = new HashMap<String, String>();
		if (userManagementDao.existsById(userId)) {
			userManagementDao.deleteUserData(userId, status, new Date());
			response.put("message", "Success");
		} else {
			response.put("message", "There is no record with the given Id");
		}
		return response;
	}

	/**
	 *Fetch the user details to edit by providing the user Id
	 */
	@Override
	public UserFilter getUserDataToEdit(Integer userId) {
		if (userManagementDao.existsById(userId)) {
			Users userData = userManagementDao.getUserDataToEdit(userId);
			UserFilter userResponse = new UserFilter(userData.getUserId(),userData.getUserName(), userData.isActive(),
					userData.getUserRole().getRoleId(), userData.getEmail(), userData.getUserRole().getRoleName(),
					userData.getCreateddate(), userData.getModifiedDate());
			return userResponse;
		} else {
			return new UserFilter(null, null, false, userId, null, null, null, null);
		}
	}

	/**
	 *To get role details 
	 */
	@Override
	public Map<String, List<RoleDropdown>> getRoles() {
		Map<String, List<RoleDropdown>> roleMap = new HashMap<String, List<RoleDropdown>>();
		List<Roles> roleList = userManagementDao.getRoles();
		List<RoleDropdown> response = new ArrayList<>();
		for (Roles entry : roleList) {
			response.add(new RoleDropdown(entry.getRoleId(), entry.getRoleName()));
		}
		roleMap.put("roleList", response);
		return roleMap;
	}
}