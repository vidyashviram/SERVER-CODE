package com.mro.drc.domainservice.dto;

public class MaterialListDto {
	private Integer materialId;
	private String materialName;

	public MaterialListDto(Integer materialId, String materialName) {
		this.materialId = materialId;
		this.materialName = materialName;
	}

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

}
