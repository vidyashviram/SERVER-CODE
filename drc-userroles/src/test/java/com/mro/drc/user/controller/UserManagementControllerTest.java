package com.mro.drc.user.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mro.drc.userroles.controller.UserManagementController;
import com.mro.drc.userroles.dto.RoleDropdown;
import com.mro.drc.userroles.dto.UserFilter;
import com.mro.drc.userroles.entity.Roles;
import com.mro.drc.userroles.entity.Users;
import com.mro.drc.userroles.service.UserManagementService;

@SpringBootTest
class UserManagementControllerTest {

	private MockMvc mvc;

	@Mock
	private UserManagementService userManagementService;

	@InjectMocks
	private UserManagementController userManagementController;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(userManagementController).dispatchOptions(true).build();
	}

	public UserFilter userData() {
		UserFilter user1 = new UserFilter(1, "Rashmi", true, 1, null, "csr", null, null);
		return user1;
	}

	@Test
	public void getUserData() throws Exception {
		List<UserFilter> res=new ArrayList<UserFilter>();
		res.add(userData());
		Mockito.when(userManagementService.getUserData()).thenReturn(res);
		mvc.perform(get("/admin/getUserData")).andExpect(status().isOk());
	}

	@Test
	public void addUserData() throws Exception {
		Users userData = new Users();
		Roles role = new Roles();
		role.setRoleId(2);
		role.setRoleName("technician");
		Date myDate = new Date(2014, 02, 11);
		userData.setUserRole(role);
		userData.setUserName("Rashmi");
		userData.setCreateddate(myDate);
		userData.setEmail("rash@gmail.com");
		userData.getUserRole().setRoleId(2);
		userData.setModifiedDate(myDate);
		userData.setActive(true);
		Map<String, String> res = new HashMap<String, String>();
		res.put("message", "Success");
		Mockito.when(userManagementService.saveUserData(userData)).thenReturn(res);
		mvc.perform(post("/admin/saveUserData").contentType(MediaType.APPLICATION_JSON).content(asJsonString(userData)))
				.andExpect(status().isCreated());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
 
	@Test
	public void deleteUserData() throws Exception {
		Integer userId = 1;
		Map<String, String> res = new HashMap<String, String>();
		res.put("message", "Success");
		Mockito.when(userManagementService.deleteUser(userId, false)).thenReturn(res);
		mvc.perform(get("/admin/deleteUserData?userId=1")).andExpect(status().isOk());
	}
	

	@Test
	public void roleDropDown() throws Exception {
		List<Map<String, List<RoleDropdown>>> result = new ArrayList<Map<String, List<RoleDropdown>>>();
		Map<String, List<RoleDropdown>> res=new HashMap<String, List<RoleDropdown>>();
		RoleDropdown dropdown=new RoleDropdown(1, "csr");
		RoleDropdown dropdown2=new RoleDropdown(2,"technician");
		List<RoleDropdown> response=new ArrayList<RoleDropdown>();
		response.add(dropdown);
		response.add(dropdown2);
		res.put("dropDownList", response);
		Mockito.when(userManagementService.getRoles()).thenReturn(res);
		mvc.perform(get("/admin/roleDropDown")).andExpect(status().isOk());
	}


	@Test
	public void onClickEditUserData() throws Exception {
		Integer userId = 1;
		Roles role = new Roles();
		role.setRoleId(2);
		role.setRoleName("technician");
		Users userData = new Users();
		userData.setUserRole(role);
		Date myDate = new Date(2014, 02, 11);
		userData.setUserName("Rashmi");
		userData.setUserId(1);
		userData.setCreateddate(myDate);
		userData.setEmail("rash@gmail.com");
		userData.getUserRole().setRoleId(2);
		userData.setModifiedDate(myDate);
		userData.setActive(true);
		Mockito.when(userManagementService.getUserDataToEdit(userId)).thenReturn(userData());
		mvc.perform(get("/admin/onClickEditUserData?userId=1")).andExpect(status().isOk());
	}

}
