package com.mro.drc.lkupservice.lookup;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 20126161
 *
 */
@Entity
@Table(name = "lkupplantconfiguration")
public class LkupPlantConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plantid")
	private Integer plantId;

	@Column(name = "plantname")
	private String partName;

	@Column(name = "plantnum")
	private String plantNum;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "modifieddate")
	private Date modifiedDate;

	@Column(name = "location")
	private String location;

	@Column(name = "distributionchannel")
	private String distributionChannel;

	@Column(name = "salesorg")
	private String salesOrg;

	@Column(name = "division")
	private String division;

	@Column(name = "template")
	private String template;

	@Column(name = "type")
	private String type;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "receiveddate")
	private Date receivedDate;

	@Column(name = "active")
	private Boolean active;

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPlantNum() {
		return plantNum;
	}

	public void setPlantNum(String plantNum) {
		this.plantNum = plantNum;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
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

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
