package com.mro.drc.dashboard.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "customerid")
	private Integer customerId;	

	@Column(name = "partid")
	private Integer partId;
	
	@Column(name = "materialid")
	private Integer materialId;
	
	@Column(name = "custpo")
	private Integer custPo;			
	
	@Column(name = "custname")
	private String custName;
	
	@Column(name = "billto")
	private String billTo;
	
	@Column(name = "shipto")
	private String shipTo;
	
	@Column(name = "freightforwarder")
	private String freightForwarder;
	
	@Column(name = "routinginst")
	private String routingInst;
	
	@Column(name = "customerreqdate")
	private Date customerReqDate;
	
	@Column(name = "tatrequired")
	private boolean tatRequired;
	
	@Column(name = "tattype")
	private String tatType;
	
	@Column(name = "sapcontractnum")
	private String sapContractNum;
	
	@Column(name = "certificationsrequired")
	private boolean certificationsRequired;
	
	@Column(name = "servicebulletinsrequested")
	private boolean serviceBulletinsRequested;
	
	@Column(name = "outgoingpartnum")
	private Integer outgoingPartnum;
	
	@Column(name = "prioritycode")
	private Integer priorityCode;
	
	@Column(name = "enduseroperatorinfo")
	private String endUserOperatorInfo;
	
	@Column(name = "endusercountryinfo")
	private String endUserCountryInfo;
	
	@Column(name = "mkdenialverification")
	private boolean mkDenialVerification;
	
	@Column(name = "exportcomplianceverification")
	private boolean exportComplianceVerification;
	
	@Column(name = "exchangerequirements")
	private String exchangeRequirements;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public Integer getCustPo() {
		return custPo;
	}

	public void setCustPo(Integer custPo) {
		this.custPo = custPo;
	}	

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getBillTo() {
		return billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

	public String getShipTo() {
		return shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	public String getFreightForwarder() {
		return freightForwarder;
	}

	public void setFreightForwarder(String freightForwarder) {
		this.freightForwarder = freightForwarder;
	}

	public String getRoutingInst() {
		return routingInst;
	}

	public void setRoutingInst(String routingInst) {
		this.routingInst = routingInst;
	}

	public Date getCustomerReqDate() {
		return customerReqDate;
	}

	public void setCustomerReqDate(Date customerReqDate) {
		this.customerReqDate = customerReqDate;
	}

	public boolean isTatRequired() {
		return tatRequired;
	}

	public void setTatRequired(boolean tatRequired) {
		this.tatRequired = tatRequired;
	}

	public String getTatType() {
		return tatType;
	}

	public void setTatType(String tatType) {
		this.tatType = tatType;
	}

	public String getSapContractNum() {
		return sapContractNum;
	}

	public void setSapContractNum(String sapContractNum) {
		this.sapContractNum = sapContractNum;
	}

	public boolean isCertificationsRequired() {
		return certificationsRequired;
	}

	public void setCertificationsRequired(boolean certificationsRequired) {
		this.certificationsRequired = certificationsRequired;
	}

	public boolean isServiceBulletinsRequested() {
		return serviceBulletinsRequested;
	}

	public void setServiceBulletinsRequested(boolean serviceBulletinsRequested) {
		this.serviceBulletinsRequested = serviceBulletinsRequested;
	}

	public Integer getOutgoingPartnum() {
		return outgoingPartnum;
	}

	public void setOutgoingPartnum(Integer outgoingPartnum) {
		this.outgoingPartnum = outgoingPartnum;
	}

	public Integer getPriorityCode() {
		return priorityCode;
	}

	public void setPriorityCode(Integer priorityCode) {
		this.priorityCode = priorityCode;
	}

	public String getEndUserOperatorInfo() {
		return endUserOperatorInfo;
	}

	public void setEndUserOperatorInfo(String endUserOperatorInfo) {
		this.endUserOperatorInfo = endUserOperatorInfo;
	}

	public String getEndUserCountryInfo() {
		return endUserCountryInfo;
	}

	public void setEndUserCountryInfo(String endUserCountryInfo) {
		this.endUserCountryInfo = endUserCountryInfo;
	}

	public boolean isMkDenialVerification() {
		return mkDenialVerification;
	}

	public void setMkDenialVerification(boolean mkDenialVerification) {
		this.mkDenialVerification = mkDenialVerification;
	}

	public boolean isExportComplianceVerification() {
		return exportComplianceVerification;
	}

	public void setExportComplianceVerification(boolean exportComplianceVerification) {
		this.exportComplianceVerification = exportComplianceVerification;
	}

	public String getExchangeRequirements() {
		return exchangeRequirements;
	}

	public void setExchangeRequirements(String exchangeRequirements) {
		this.exchangeRequirements = exchangeRequirements;
	}

}
