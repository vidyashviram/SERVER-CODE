package com.mro.drc.lkupservice.lookup;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 20126161
 *
 */
@Entity
@Table(name = "lkupcustomer")
public class LkupCustomer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "custid")
	private Integer custId;

	@Column(name = "custname")
	private String custName;

	@Column(name = "custnum")
	private String custNum;

	@Column(name = "custaddress")
	private String custAddress;

	@Column(name = "custemail")
	private String custEmail;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "createddate")
	private Date createdDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "modifieddate")
	private Date modifiedDate;

	@Column(name = "custphone")
	private String custPhone;

	@Column(name = "billto")
	private String billTo;

	@Column(name = "shipto")
	private String shipTo;

	@Column(name = "active")
	private Boolean active;

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

	public String getCustNum() {
		return custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getCustid() {
		return custId;
	}

	public void setCustid(Integer custid) {
		this.custId = custid;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

}
