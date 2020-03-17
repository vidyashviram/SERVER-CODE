package com.mro.drc.dashboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "receiving")
public class Receiving {
	@Id
	@Column(name = "receivingid")
	private Integer receivingId;

	@Column(name = "partid")
	private Integer partId;

	@OneToOne
	@JoinColumn(name = "distributionchannelid")
	private DistributionChannel distributionChannelId;

	@Column(name = "jobcategory")
	private String jobCategory;
	
	@Column(name = "workscope")
	private String workscope;
	
	@OneToOne
	@JoinColumn(name = "statusid")
	private WorkOrderStatus workOrderStatus;
	
	public WorkOrderStatus getStatusId() {
		return workOrderStatus;
	}

	public void setStatusId(WorkOrderStatus workOrderStatus) {
		this.workOrderStatus = workOrderStatus;
	}

	@Column(name = "warrantyreq")
	private Boolean warrantyReq;
	
	@Column(name = "containerreusable")
	private Boolean containerReusable;
	
	@Column(name = "unitdamaged")
	private Boolean unitDamaged;

	public Integer getReceivingId() {
		return receivingId;
	}

	public void setReceivingId(Integer receivingId) {
		this.receivingId = receivingId;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public DistributionChannel getDistributionChannelId() {
		return distributionChannelId;
	}

	public void setDistributionChannelId(DistributionChannel distributionChannelId) {
		this.distributionChannelId = distributionChannelId;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getWorkscope() {
		return workscope;
	}

	public void setWorkscope(String workscope) {
		this.workscope = workscope;
	}

	public Boolean getWarrantyReq() {
		return warrantyReq;
	}

	public void setWarrantyReq(Boolean warrantyReq) {
		this.warrantyReq = warrantyReq;
	}

	public Boolean getContainerReusable() {
		return containerReusable;
	}

	public void setContainerReusable(Boolean containerReusable) {
		this.containerReusable = containerReusable;
	}

	public Boolean getUnitDamaged() {
		return unitDamaged;
	}

	public void setUnitDamaged(Boolean unitDamaged) {
		this.unitDamaged = unitDamaged;
	}

}
