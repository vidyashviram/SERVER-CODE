package com.mro.drc.domainservice.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.domainservice.dao.WorkOrderStatusDao;
import com.mro.drc.domainservice.domain.WorkOrderStatus;
import com.mro.drc.domainservice.dto.WorkStatusListDto;
import com.mro.drc.domainservice.service.WorkOrderStatusService;

/**
 * @author 40008878
 *
 */
@Service
public class WorkOrderStatusServiceImpl implements WorkOrderStatusService {

	@Autowired
	private WorkOrderStatusDao workOrderDao;

	/**
	 * return work order list for drop down
	 */
	@Override
	public Map<String, List<WorkStatusListDto>> getWorkStatusList() throws Exception {
		Map<String, List<WorkStatusListDto>> workStatusMap = new HashMap<>();
		try {
			List<WorkOrderStatus> workStatus = workOrderDao.getAllWorkOrderStatus();
			List<WorkStatusListDto> workStatusResponse = new ArrayList<>();
			for (WorkOrderStatus entry : workStatus) {
				workStatusResponse.add(new WorkStatusListDto(entry.getStatusId(), entry.getStatusDesc()));
			}
			workStatusMap.put("workStatusList", workStatusResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workStatusMap;
	}

}
