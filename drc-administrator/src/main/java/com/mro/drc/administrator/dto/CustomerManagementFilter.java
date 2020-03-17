package com.mro.drc.administrator.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 20126161
 *
 */
public class CustomerManagementFilter {

	private String custName;
	private String custEmail;
	private Integer custid;
	private String custPhone;
	private String custAddress;
	private String custNum;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createdDate;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date modifiedDate;
	private String billTo;
	private String shipTo;
	private Boolean active;

	/**
	 * @param custName
	 * @param custEmail
	 * @param custAddress
	 * @param custid
	 * @param custPhone
	 * @param partNo
	 * @param custNum
	 * @param createdDate
	 * @param modifiedDate
	 * @param active
	 */
	public CustomerManagementFilter(String custName, String custEmail, String custAddress, Integer custid,
			String custPhone, String custNum, Date createdDate, Date modifiedDate, String billTo, String shipTo,
			Boolean active) {
		super();
		this.custName = custName;
		this.custEmail = custEmail;
		this.custAddress = custAddress;
		this.custid = custid;
		this.custPhone = custPhone;
		this.custNum = custNum;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.active = active;
		this.billTo=billTo;
		this.shipTo=shipTo;

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

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustNum() {
		return custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

}
