package com.mro.drc.userroles.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.userroles.dto.RoleDropdown;
import com.mro.drc.userroles.dto.UserFilter;
import com.mro.drc.userroles.entity.Roles;
import com.mro.drc.userroles.entity.Users;

public interface UserManagementService {


	List<UserFilter> getUserData() throws Exception;

	Map<String, String> saveUserData(Users userData);

	Map<String, String> deleteUser(Integer userId, boolean status);

	UserFilter getUserDataToEdit(Integer userId);

	Map<String, List<RoleDropdown>> getRoles();
}
