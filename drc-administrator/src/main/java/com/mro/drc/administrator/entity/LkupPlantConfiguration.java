package com.mro.drc.administrator.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "lkupplantconfiguration")
public class LkupPlantConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plantid")
	private Integer plantId;
	
	@Column(name = "plantname")
	private String plantName;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "distributionchannel")
	private String distributionchannel;
	
	@Column(name = "salesorg")
	private String salesorg;
	
	@Column(name = "division")
	private String division;
	
	@Column(name = "template")
	private String template;
	
	@Column(name = "type")
	private String type;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "receiveddate")
	private Date receiveddate;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "modifieddate")
	private Date modifiedDate;
	
	@Column(name = "plantnum")
	private String plantNum;

	@Column(name = "active")
	private boolean active;
	
	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}
	
	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDistributionchannel() {
		return distributionchannel;
	}

	public void setDistributionchannel(String distributionchannel) {
		this.distributionchannel = distributionchannel;
	}

	public String getSalesorg() {
		return salesorg;
	}

	public void setSalesorg(String salesorg) {
		this.salesorg = salesorg;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getReceiveddate() {
		return receiveddate;
	}

	public void setReceiveddate(Date receiveddate) {
		this.receiveddate = receiveddate;
	}

	public String getPlantNum() {
		return plantNum;
	}

	public void setPlantNum(String plantNum) {
		this.plantNum = plantNum;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
