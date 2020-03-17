package com.mro.drc.userroles.dto;


/**
 * @author 20126160
 * DTO object for roleId and role name details 
 *
 */
public class RoleDropdown {
	private Integer roleId;
	private String roleName;

	public RoleDropdown(Integer roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
