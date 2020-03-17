package com.mro.drc.dashboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "aircraftdisposition")
public class AircraftDisposition {	
	
	@Id
	@Column(name = "aircraftdispositionid")
	private Integer aircraftDispositionId;	

	@Column(name = "partid")
	private Integer partId;
	
	@Column(name = "materialid")
	private Integer materialId;
	
	@Column(name = "aircrafttype")
	private String aircraftType;
	
	@Column(name = "enginetype")
	private String engineType;
	
	@Column(name = "aircraftserialnum")
	private Integer aircraftSerialNum;
	
	@Column(name = "engineserialnum")
	private Integer engineSerialNum;
	
	@Column(name = "removaltailnum")
	private Integer removalTailNum;
	
	@Column(name = "originaltailnum")
	private Integer originalTailNum;
	
	@Column(name = "servicecycles")
	private Integer serviceCycles;
	
	public Integer getAircraftDispositionId() {
		return aircraftDispositionId;
	}

	public void setAircraftDispositionId(Integer aircraftDispositionId) {
		this.aircraftDispositionId = aircraftDispositionId;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public Integer getAircraftSerialNum() {
		return aircraftSerialNum;
	}

	public void setAircraftSerialNum(Integer aircraftSerialNum) {
		this.aircraftSerialNum = aircraftSerialNum;
	}

	public Integer getEngineSerialNum() {
		return engineSerialNum;
	}

	public void setEngineSerialNum(Integer engineSerialNum) {
		this.engineSerialNum = engineSerialNum;
	}

	public Integer getRemovalTailNum() {
		return removalTailNum;
	}

	public void setRemovalTailNum(Integer removalTailNum) {
		this.removalTailNum = removalTailNum;
	}

	public Integer getOriginalTailNum() {
		return originalTailNum;
	}

	public void setOriginalTailNum(Integer originalTailNum) {
		this.originalTailNum = originalTailNum;
	}

	public Integer getServiceCycles() {
		return serviceCycles;
	}

	public void setServiceCycles(Integer serviceCycles) {
		this.serviceCycles = serviceCycles;
	}

}
