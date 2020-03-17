package com.mro.drc.dashboard.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.mro.drc.dashboard.domain.Roles;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Integer userId;

	@Column(name = "username")
	private String userName;

	@OneToOne
	@JoinColumn(name = "roleid")
	private Roles userRole;

	public Roles getUserRole() {
		return userRole;
	}

	public void setUserRole(Roles userRole) {
		this.userRole = userRole;
	}

	@Column(name = "active")
	private boolean active;

	@Column(name = "sessionid")
	private String sessionId;

	@Column(name = "email")
	private String email;
	
	@Column(name = "encryptpassword")
	private String encryptPassword;

	public String getEncryptPassword() {
		return encryptPassword;
	}

	public void setEncryptPassword(String encryptPassword) {
		this.encryptPassword = encryptPassword;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String string) {
		this.sessionId = string;
	}


	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "createddate")
	private Date createddate;
	

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "modifieddate")
	private Date modifiedDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
