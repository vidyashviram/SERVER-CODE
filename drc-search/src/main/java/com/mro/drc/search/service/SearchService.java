package com.mro.drc.search.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.search.dto.WordOrderFilterResponse;
import com.mro.drc.search.dto.WorkOrderFilterCriteria;
import com.mro.drc.search.dto.WorkOrdersListDto;

/**
 * @author 40008878
 *
 */
public interface SearchService {

	List<WordOrderFilterResponse> getSearchResponse(WorkOrderFilterCriteria filterCriteria) throws Exception;

	Map<String, List<WorkOrdersListDto>> getWorkOrderList() throws Exception;

}
