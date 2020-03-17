package com.mro.drc.userroles.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 20126160
 *DTO class for user details
 */
public class UserFilter {

	private Integer userId;
	private String username;
	private boolean active;
	private Integer roleid;
	private String email;
	private String roleName;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createdDate;
	

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date modifiedDate;


	public UserFilter(Integer userId, String username, boolean active, Integer roleid, String email, String roleName,
			Date createdDate, Date modifiedDate) {
		super();
		this.userId = userId;
		this.username = username;
		this.active = active;
		this.roleid = roleid;
		this.email = email;
		this.roleName = roleName;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Integer getRoleid() {
		return roleid;
	}


	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}



}
