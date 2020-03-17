package com.mro.drc.domainservice.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.domainservice.dto.DistributionChannelListDto;

/**
 * @author 40008878
 *
 */
public interface DistributionChannelService {

	Map<String, List<DistributionChannelListDto>> getDistChannelList() throws Exception;

}
