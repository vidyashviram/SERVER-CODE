package com.mro.drc.user.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
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
import com.mro.drc.userroles.controller.RoleManagementController;
import com.mro.drc.userroles.entity.Roles;
import com.mro.drc.userroles.service.RoleManagementService;

@SpringBootTest
class RoleManagementControllerTest {

	private MockMvc mvc;

	@Mock
	private RoleManagementService RoleManagementService;

	@InjectMocks
	private RoleManagementController RoleManagementController;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(RoleManagementController).dispatchOptions(true).build();
	}

	public List<Roles> roleData() {
		List<Roles> response = new ArrayList<>();
		Roles role = new Roles();
		role.setRoleId(1);
		role.setRoleName("csr");
		response.add(role);
		return response;
	}

	@Test
	public void getRoleData() throws Exception {
		Mockito.when(RoleManagementService.getRoleData()).thenReturn(roleData());
		mvc.perform(get("/admin/getRoleData")).andExpect(status().isOk());
	}

	@Test
	public void saveRoleData() throws Exception {
		Roles role = new Roles();
		role.setRoleId(2);
		role.setRoleName("technician");
		Map<String, String> res = new HashMap<String, String>();
		res.put("message", "Success");
		Mockito.when(RoleManagementService.saveRoleData(role)).thenReturn(res);
		mvc.perform(post("/admin/saveRoleData").contentType(MediaType.APPLICATION_JSON).content(asJsonString(role)))
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
	public void deleteRoleData() throws Exception {
		Integer roleId = 1;
		Map<String, String> res = new HashMap<String, String>();
		res.put("message", "Success");
		Mockito.when(RoleManagementService.deleteRoles(roleId, false)).thenReturn(res);
		mvc.perform(get("/admin/deleteRoleData?roleId=1")).andExpect(status().isOk());
	}

	@Test
	public void onClickEditRoleData() throws Exception {
		Integer roleId = 1;
		Roles role = new Roles();
		role.setRoleId(2);
		role.setRoleName("technician");
		List<Roles> roles = new ArrayList<>();
		roles.add(role);
	
		Mockito.when(RoleManagementService.getRoleDataToEdit(roleId)).thenReturn(roles);
		mvc.perform(get("/admin/onClickEditRoleData?roleId=1")).andExpect(status().isOk());
	}

}
