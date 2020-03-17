package com.mro.drc.search.dto;

public class WorkOrdersListDto {

	private Integer id;
	private Integer workOrderId;

	public WorkOrdersListDto(Integer id, Integer workOrderId) {
		this.id = id;
		this.workOrderId = workOrderId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(Integer workOrderId) {
		this.workOrderId = workOrderId;
	}

}
