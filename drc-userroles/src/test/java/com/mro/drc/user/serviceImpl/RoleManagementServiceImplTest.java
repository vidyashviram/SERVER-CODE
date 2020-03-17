package com.mro.drc.user.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mro.drc.userroles.dao.RoleManagementDao;
import com.mro.drc.userroles.dao.UserManagementDao;
import com.mro.drc.userroles.dto.UserFilter;
import com.mro.drc.userroles.entity.Roles;
import com.mro.drc.userroles.entity.Users;
import com.mro.drc.userroles.serviceImpl.RoleManagementServiceImpl;

public class RoleManagementServiceImplTest {

	private static Integer ROLEID = 1;

	@InjectMocks
	RoleManagementServiceImpl roleManagementServiceImpl;

	@Mock
	RoleManagementDao roleManagementDao;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	Date myDate = new Date(2014, 02, 11);

	public Roles role() {
		Roles role = new Roles();
		role.setRoleId(1);
		role.setRoleName("technician");
		return role;
	}

	@Test
	public void getRoleDataTest() throws Exception {
		List<Roles> roles = new ArrayList<Roles>();
		roles.add(role());
		Mockito.when(roleManagementDao.getRolesDetails()).thenReturn(roles);
		List<Roles> response = roleManagementServiceImpl.getRoleData();
		assertEquals(1, response.size());
		assertEquals("technician", response.get(0).getRoleName());
	}

	@Test
	public void saveRoleDataTest() throws Exception {
		Roles roleData = role();
		roleData.setCreatedDate(new Date());
		roleData.setModifiedDate(new Date());
		roleData.setActive(false);
		Mockito.when(roleManagementDao.save(roleData)).thenReturn(roleData);
		Map<String, String> response = roleManagementServiceImpl.saveRoleData(roleData);
		System.out.println(response);
		assertEquals("Success", response.get("message"));
	}

	@Test
	public void deleteRoleTest() throws Exception {
		Mockito.when(roleManagementDao.deleteRoleData(ROLEID, false, myDate)).thenReturn(0);
		Mockito.when(roleManagementDao.existsById(ROLEID)).thenReturn(true);
		Map<String, String> response = roleManagementServiceImpl.deleteRoles(ROLEID, false);
		assertEquals("Success", response.get("message"));
	}

	@Test
	public void getRoleDataToEdit() throws Exception {
		List<Roles> roles = new ArrayList<Roles>();
		roles.add(role());
		Mockito.when(roleManagementDao.getRoleDataToEdit(ROLEID)).thenReturn(roles);
		Mockito.when(roleManagementDao.existsById(ROLEID)).thenReturn(true);
		List<Roles> response = roleManagementServiceImpl.getRoleDataToEdit(ROLEID);
		assertEquals(1, response.size());
	}
}
