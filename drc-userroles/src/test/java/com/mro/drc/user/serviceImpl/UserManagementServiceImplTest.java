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

import com.mro.drc.userroles.dao.UserManagementDao;
import com.mro.drc.userroles.dto.UserFilter;
import com.mro.drc.userroles.entity.Roles;
import com.mro.drc.userroles.entity.Users;
import com.mro.drc.userroles.serviceImpl.UserManagementServiceImpl;

public class UserManagementServiceImplTest {

	private static Integer USERID = 1;

	@InjectMocks
	UserManagementServiceImpl userManagementServiceImpl;

	@Mock
	UserManagementDao userManagementDao;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	Date myDate = new Date(2014, 02, 11);

	public Users users() {
		Users userData = new Users();

		Roles role = new Roles();
		role.setRoleId(2);
		role.setRoleName("technician");
		Date myDate = new Date(2014, 02, 11);
		userData.setUserRole(role);
		userData.setUserName("Rashmi");
		userData.setUserId(1);
		userData.setCreateddate(myDate);
		userData.setEmail("rash@gmail.com");
		userData.getUserRole().setRoleId(2);
		userData.setModifiedDate(myDate);
		userData.setActive(true);
		return userData;
	}

	@Test
	public void getUserDataTest() throws Exception {
		List<Users> users = new ArrayList<Users>();
		users.add(users());
		Mockito.when(userManagementDao.getUserDetails()).thenReturn(users);
		List<UserFilter> response = userManagementServiceImpl.getUserData();
		assertEquals(1, response.size());
		assertEquals("Rashmi", response.get(0).getUsername());
	}

	@Test
	public void saveUserDataTest() throws Exception {
		Users user = users();
		user.setUserId(2);
		Mockito.when(userManagementDao.save(user)).thenReturn(user);
		Map<String, String> response = userManagementServiceImpl.saveUserData(user);
		assertEquals("Success", response.get("message"));
	}

	@Test
	public void deleteUserTest() throws Exception {
		Mockito.when(userManagementDao.deleteUserData(USERID, false, myDate)).thenReturn(0);
		Mockito.when(userManagementDao.existsById(USERID)).thenReturn(true);
		Map<String, String> response = userManagementServiceImpl.deleteUser(USERID, false);
		assertEquals("Success", response.get("message"));
	}

	@Test
	public void getUserDataToEdit() throws Exception {
		Mockito.when(userManagementDao.getUserDataToEdit(USERID)).thenReturn(users());
		Mockito.when(userManagementDao.existsById(USERID)).thenReturn(true);
		 UserFilter response = userManagementServiceImpl.getUserDataToEdit(USERID);
		assertEquals("Rashmi", response.getUsername());
	}
}
