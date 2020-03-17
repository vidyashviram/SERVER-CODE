package com.mro.drc.domainservice.dto;

public class PartNamesListDto {
	private Integer partId;
	private String partName;

	public PartNamesListDto(Integer partId, String partName) {
		this.partId = partId;
		this.partName = partName;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

}
