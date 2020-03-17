package com.mro.drc.search.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WordOrderFilterResponse {

	private Integer workOrderId;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createdOn;
	private String gateStatus;
	private String partName;
	private String priority;
	private String customerName;
	private String partNum;
	private String materialType;
	private String classification;

	public WordOrderFilterResponse(Integer workOrderId, Date createdOn, String gateStatus, String partName,
			String priority, String customerName, String partNum, String materialType, String classification) {
		super();
		this.workOrderId = workOrderId;
		this.createdOn = createdOn;
		this.gateStatus = gateStatus;
		this.partName = partName;
		this.priority = priority;
		this.customerName = customerName;
		this.partNum = partNum;
		this.materialType = materialType;
		this.classification = classification;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Integer getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(Integer workOrderId) {
		this.workOrderId = workOrderId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getGateStatus() {
		return gateStatus;
	}

	public void setGateStatus(String gateStatus) {
		this.gateStatus = gateStatus;
	}

	public String getPartNum() {
		return partNum;
	}

	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
}
