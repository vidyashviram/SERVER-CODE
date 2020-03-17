package com.mro.drc.domainservice.dto;

public class PartNumbersListDto {

	private Integer partId;
	private String partNum;

	public PartNumbersListDto(Integer partId, String partNum) {
		this.partId = partId;
		this.partNum = partNum;
	}
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public String getPartNum() {
		return partNum;
	}
	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}
	
	
}
