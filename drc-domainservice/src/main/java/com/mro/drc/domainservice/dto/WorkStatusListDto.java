package com.mro.drc.domainservice.dto;

public class WorkStatusListDto {

	private Integer statusId;
	private String statusDesc;

	public WorkStatusListDto(Integer statusId, String statusDesc) {
		this.statusId = statusId;
		this.statusDesc = statusDesc;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
}
