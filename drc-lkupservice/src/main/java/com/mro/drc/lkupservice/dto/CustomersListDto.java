package com.mro.drc.lkupservice.dto;

public class CustomersListDto {

	private Integer custId;
	private String custName;


	public CustomersListDto(Integer custId,  String custName) {
		this.custId = custId;
		
		this.custName = custName;
	}

	

	
	public Integer getCustid() {
		return custId;
	}

	public void setCustid(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

}
