package com.mro.drc.lkupservice.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ldapconfig")

public class LdapServerConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "protocol")
	private String protocol;

	@Column(name = "host")
	private String host;

	@Column(name = "domain")
	private String domain;

	@Column(name = "domainext")
	private String domaiNext;

	@Column(name = "domaindir")
	private String domaIndir;

	@Column(name = "domaindirgroup")
	private String domaIndirGroup;

	@Column(name = "serviceusername")
	private String serviceUserName;

	@Column(name = "servicepassword")
	private String servicePassword;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDomaiNext() {
		return domaiNext;
	}

	public void setDomaiNext(String domaiNext) {
		this.domaiNext = domaiNext;
	}

	public String getDomaIndir() {
		return domaIndir;
	}

	public void setDomaIndir(String domaIndir) {
		this.domaIndir = domaIndir;
	}

	public String getDomaIndirGroup() {
		return domaIndirGroup;
	}

	public void setDomaIndirGroup(String domaIndirGroup) {
		this.domaIndirGroup = domaIndirGroup;
	}

	public String getServiceUserName() {
		return serviceUserName;
	}

	public void setServiceUserName(String serviceUserName) {
		this.serviceUserName = serviceUserName;
	}

	public String getServicePassword() {
		return servicePassword;
	}

	public void setServicePassword(String servicePassword) {
		this.servicePassword = servicePassword;
	}

}
