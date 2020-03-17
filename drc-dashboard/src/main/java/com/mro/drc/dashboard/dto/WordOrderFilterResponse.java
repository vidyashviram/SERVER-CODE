package com.mro.drc.dashboard.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 20126160
 *
 */
public class WordOrderFilterResponse {

	private Integer workOrderId;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createdOn;
	private String gateStatus;
	private String partNum;
	private String priority;
	private String customerName;
	private String partName;

	/**
	 * @param workOrderId
	 * @param createdOn
	 * @param gateStatus
	 * @param partNum
	 * @param priority
	 * @param customerName
	 * @param partName     
	 * Creates response dto Object with specified columns
	 */
	public WordOrderFilterResponse(Integer workOrderId, Date createdOn, String gateStatus, String partNum,
			String priority, String customerName, String partName) {
		super();
		this.workOrderId = workOrderId;
		this.createdOn = createdOn;
		this.gateStatus = gateStatus;
		this.partNum = partNum;
		this.priority = priority;
		this.customerName = customerName;
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

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}
}
