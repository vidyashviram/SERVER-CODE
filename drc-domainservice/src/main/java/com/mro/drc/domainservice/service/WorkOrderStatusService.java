package com.mro.drc.domainservice.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.domainservice.dto.WorkStatusListDto;

/**
 * @author 40008878
 *
 */
public interface WorkOrderStatusService {

	Map<String, List<WorkStatusListDto>> getWorkStatusList() throws Exception;

}
