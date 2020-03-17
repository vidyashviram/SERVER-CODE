package com.mro.drc.administrator.dto;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 20126161
 *
 */
public class SupplierManagementFilter {

	private String supplierName;
	private String supplierEmail;
	private Integer supplierId;
	private String supplierPhone;
	private String supplierAddress;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createdDate;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date modifiedDate;

	private Boolean active;

	/**
	 * @param supplierName
	 * @param supplierEmail
	 * @param supplierAddress
	 * @param supplierId
	 * @param supplierPhone
	 * @param createdDate
	 * @param modifiedDate
	 * @param active
	 */
	public SupplierManagementFilter(String supplierName, String supplierEmail, String supplierAddress,
			Integer supplierId, String supplierPhone, Date createdDate, Date modifiedDate, Boolean active) {
		super();
		this.supplierName = supplierName;
		this.supplierEmail = supplierEmail;
		this.supplierAddress = supplierAddress;
		this.supplierId = supplierId;
		this.supplierPhone = supplierPhone;
		this.modifiedDate = modifiedDate;
		this.createdDate = createdDate;
		this.active = active;
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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierEmail() {
		return supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
