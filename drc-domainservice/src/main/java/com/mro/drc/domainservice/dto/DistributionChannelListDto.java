package com.mro.drc.domainservice.dto;

public class DistributionChannelListDto {

	private Integer distributionChannelId;
	private String distributionChannel;

	public DistributionChannelListDto(Integer distributionChannelId, String distributionChannel) {
		this.distributionChannelId = distributionChannelId;
		this.distributionChannel = distributionChannel;
	}

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

}
