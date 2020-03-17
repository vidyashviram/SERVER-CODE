package com.mro.drc.lkupservice.dto;

/**
 * @author 20126161
 *
 */
public class PlantConfigurationNumDto {
	private String plantNum;
	private String plantName;

	/**
	 * @param plantNum
	 * @param plantName
	 */
	public PlantConfigurationNumDto(String plantNum, String plantName) {

		this.plantName = plantName;
		this.plantNum = plantNum;
	}

	public String getPlantNum() {
		return plantNum;
	}

	public void setPlantNum(String plantNum) {
		this.plantNum = plantNum;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

}
