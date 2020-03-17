package com.mro.drc.dashboard.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "distributionchannels")
public class DistributionChannel {
	
	@Id
	@Column(name = "distributionchannelid")
	private Integer distributionChannelId;		

	@Column(name = "distributionchannel")
	private String distributionChannel;
	
	@Column(name = "createddate")
	private Date createdDate;
	
	@Column(name = "modifieddate")
	private Date modifiedDate;
	
	@Column(name = "active")
	private Boolean active;
	
	public Integer getDistributionChannelId() {
		return distributionChannelId;
	}

	public void setDistributionChannelId(Integer distributionChannelId) {
		this.distributionChannelId = distributionChannelId;
	}

	public String getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
