package com.mro.drc.search.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkOrderFilter {
	private Integer workOrderId;
	private String custName;
	private Integer gateStatus;
	private Integer partNum;
	private Integer partName;
	private String material;
	private Integer distributionChannelId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fromDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date toDate;
	
	public Integer getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(Integer workOrderId) {
		this.workOrderId = workOrderId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Integer getGateStatus() {
		return gateStatus;
	}

	public void setGateStatus(Integer gateStatus) {
		this.gateStatus = gateStatus;
	}

	public Integer getPartNum() {
		return partNum;
	}

	public void setPartNum(Integer partNum) {
		this.partNum = partNum;
	}

	public Integer getPartName() {
		return partName;
	}

	public void setPartName(Integer partName) {
		this.partName = partName;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getDistributionChannelId() {
		return distributionChannelId;
	}

	public void setDistributionChannelId(Integer distributionChannelId) {
		this.distributionChannelId = distributionChannelId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
