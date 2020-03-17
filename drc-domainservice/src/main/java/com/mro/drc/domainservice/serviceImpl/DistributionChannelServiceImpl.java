package com.mro.drc.domainservice.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.domainservice.dao.DistributionChannelDao;
import com.mro.drc.domainservice.domain.DistributionChannel;
import com.mro.drc.domainservice.dto.DistributionChannelListDto;
import com.mro.drc.domainservice.service.DistributionChannelService;

/**
 * @author 40008878
 *
 */
@Service
public class DistributionChannelServiceImpl implements DistributionChannelService {
	@Autowired

	private DistributionChannelDao distDao;


	/**
	 * Return Distribution channel List
	 */
	@Override
	public Map<String, List<DistributionChannelListDto>> getDistChannelList() throws Exception {
		Map<String, List<DistributionChannelListDto>> distChannelMap = new HashMap<>();
		try {
			List<DistributionChannel> distChannelList = distDao.getAllClassificationList();
			List<DistributionChannelListDto> distChannelResponse = new ArrayList<>();
			for (DistributionChannel entry : distChannelList) {
				distChannelResponse.add(
						new DistributionChannelListDto(entry.getDistributionChannelId(), entry.getDistributionChannel()));
			}
			distChannelMap.put("distChannelList", distChannelResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return distChannelMap;
	}

}
