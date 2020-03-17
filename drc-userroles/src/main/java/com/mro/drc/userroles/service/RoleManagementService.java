package com.mro.drc.userroles.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.userroles.entity.Roles;

public interface RoleManagementService {


	List<Roles> getRoleData() throws Exception;

	Map<String, String> saveRoleData(Roles roleData);

	Map<String, String> deleteRoles(Integer roleId, boolean status);

	List<Roles> getRoleDataToEdit(Integer userId);
}
