package com.mro.drc.search.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "materialdetail")
public class MaterialDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "materialid")
	private Integer materialId;	

	@Column(name = "partid")
	private Integer partId;
	
	@Column(name = "equipmentnum")
	private Integer equipmentNum;
	
	@Column(name = "natonum")
	private Integer natoNum;
	
	@Column(name = "installdate")
	private Date installDate;
	
	@Column(name = "failuredate")
	private Date failureDate;
	
	@Column(name = "removaldate")
	private Date removalDate;
	
	@Column(name = "measurementdate")
	private Date measurementDate;
	
	@Column(name = "measurementtime")
	private Date measurementTime;
	
	@Column(name = "removalreason")
	private String removalReason;
	
	@Column(name = "csn")
	private Integer csn;
	
	@Column(name = "cso")
	private Integer cso;
	
	@Column(name = "csr")
	private Integer csr;
	
	@Column(name = "tsn")
	private Integer tsn;
	
	@Column(name = "tso")
	private Integer tso;
	
	@Column(name = "tsr")
	private Integer tsr;
	
	@Column(name = "materialtype")
	private String materialType;
	
	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public Integer getEquipmentNum() {
		return equipmentNum;
	}

	public void setEquipmentNum(Integer equipmentNum) {
		this.equipmentNum = equipmentNum;
	}

	public Integer getNatoNum() {
		return natoNum;
	}

	public void setNatoNum(Integer natoNum) {
		this.natoNum = natoNum;
	}

	public Date getInstallDate() {
		return installDate;
	}

	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}

	public Date getFailureDate() {
		return failureDate;
	}

	public void setFailureDate(Date failureDate) {
		this.failureDate = failureDate;
	}

	public Date getRemovalDate() {
		return removalDate;
	}

	public void setRemovalDate(Date removalDate) {
		this.removalDate = removalDate;
	}

	public Date getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(Date measurementDate) {
		this.measurementDate = measurementDate;
	}

	public Date getMeasurementTime() {
		return measurementTime;
	}

	public void setMeasurementTime(Date measurementTime) {
		this.measurementTime = measurementTime;
	}

	public String getRemovalReason() {
		return removalReason;
	}

	public void setRemovalReason(String removalReason) {
		this.removalReason = removalReason;
	}

	public Integer getCsn() {
		return csn;
	}

	public void setCsn(Integer csn) {
		this.csn = csn;
	}

	public Integer getCso() {
		return cso;
	}

	public void setCso(Integer cso) {
		this.cso = cso;
	}

	public Integer getCsr() {
		return csr;
	}

	public void setCsr(Integer csr) {
		this.csr = csr;
	}

	public Integer getTsn() {
		return tsn;
	}

	public void setTsn(Integer tsn) {
		this.tsn = tsn;
	}

	public Integer getTso() {
		return tso;
	}

	public void setTso(Integer tso) {
		this.tso = tso;
	}

	public Integer getTsr() {
		return tsr;
	}

	public void setTsr(Integer tsr) {
		this.tsr = tsr;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	
}
