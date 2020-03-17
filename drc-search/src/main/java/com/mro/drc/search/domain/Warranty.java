package com.mro.drc.search.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "warranty")
public class Warranty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "warrantyid")
	private Integer warrantyId;

	@Column(name = "exchangeserialnum")
	private Integer exchangeSerialNum;
	
	@Column(name = "manyufacturedate")
	private Date manyufactureDate;
	
	@Column(name = "originaldeliverydate")
	private Date originalDeliveryDate;
	
	@Column(name = "installdate")
	private Date installDate;
	
	@Column(name = "removaldate")
	private Date removalDate;
	
	@Column(name = "shipdate")
	private Date shipDate;
	
	@Column(name = "spareshipdate")
	private Date spareShipDate;
	
	@Column(name = "retrofitdate")
	private Date retrofitDate;
	
	@Column(name = "workscope")
	private String workscope;
	
	@Column(name = "priorreturns")
	private Boolean priorReturns;
	
	@Column(name = "ecrflag")
	private Boolean ecrFlag;
	
	@Column(name = "mruflag")
	private Boolean mruFlag;
	

	public Integer getWarrantyId() {
		return warrantyId;
	}

	public void setWarrantyId(Integer warrantyId) {
		this.warrantyId = warrantyId;
	}

	public Integer getExchangeSerialNum() {
		return exchangeSerialNum;
	}

	public void setExchangeSerialNum(Integer exchangeSerialNum) {
		this.exchangeSerialNum = exchangeSerialNum;
	}

	public Date getManyufactureDate() {
		return manyufactureDate;
	}

	public void setManyufactureDate(Date manyufactureDate) {
		this.manyufactureDate = manyufactureDate;
	}

	public Date getOriginalDeliveryDate() {
		return originalDeliveryDate;
	}

	public void setOriginalDeliveryDate(Date originalDeliveryDate) {
		this.originalDeliveryDate = originalDeliveryDate;
	}

	public Date getInstallDate() {
		return installDate;
	}

	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}

	public Date getRemovalDate() {
		return removalDate;
	}

	public void setRemovalDate(Date removalDate) {
		this.removalDate = removalDate;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public Date getSpareShipDate() {
		return spareShipDate;
	}

	public void setSpareShipDate(Date spareShipDate) {
		this.spareShipDate = spareShipDate;
	}

	public Date getRetrofitDate() {
		return retrofitDate;
	}

	public void setRetrofitDate(Date retrofitDate) {
		this.retrofitDate = retrofitDate;
	}

	public String getWorkscope() {
		return workscope;
	}

	public void setWorkscope(String workscope) {
		this.workscope = workscope;
	}

	public Boolean getPriorReturns() {
		return priorReturns;
	}

	public void setPriorReturns(Boolean priorReturns) {
		this.priorReturns = priorReturns;
	}

	public Boolean getEcrFlag() {
		return ecrFlag;
	}

	public void setEcrFlag(Boolean ecrFlag) {
		this.ecrFlag = ecrFlag;
	}

	public Boolean getMruFlag() {
		return mruFlag;
	}

	public void setMruFlag(Boolean mruFlag) {
		this.mruFlag = mruFlag;
	}

}
