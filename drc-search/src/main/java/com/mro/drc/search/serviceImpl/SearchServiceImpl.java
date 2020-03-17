package com.mro.drc.search.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.search.dao.SearchDao;
import com.mro.drc.search.domain.WorkOrderEntry;
import com.mro.drc.search.dto.WorkOrdersListDto;
import com.mro.drc.search.dto.WordOrderFilterResponse;
import com.mro.drc.search.dto.WorkOrderFilterCriteria;
import com.mro.drc.search.service.SearchService;

/**
 * @author 40008878 Search Service Implementation Class
 */
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;

	/**
	 * Service to implement Specifications based on the filter criteria Add the
	 * response to Work order response List
	 */
	public List<WordOrderFilterResponse> getSearchResponse(WorkOrderFilterCriteria filterCriteria) throws Exception {

		List<WordOrderFilterResponse> workOrderResponse = new ArrayList<>();
		try {
			List<WorkOrderEntry> workOrderEntryResult = searchDao
					.findAll(new WorkOrderFilterSpecification(filterCriteria.getWorkOrderFilter()));

			for (WorkOrderEntry entry : workOrderEntryResult) {
				workOrderResponse.add(new WordOrderFilterResponse(entry.getWorkOrderId(), entry.getCreatedOn(),
						entry.getReceiving().getWorkOrderStatus().getStatusDesc(), entry.getPart().getPartName(),
						entry.getPriority(), entry.getCustomer().getCustName(), entry.getPart().getPartNum(),
						entry.getMaterial().getMaterialType(),
						entry.getReceiving().getDistributionChannelId().getDistributionChannel()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workOrderResponse;
	}

	/**
	 * Work order status drop down list
	 */
	@Override
	public Map<String, List<WorkOrdersListDto>> getWorkOrderList() throws Exception {
		Map<String, List<WorkOrdersListDto>> workOrderMap = new HashMap<>();
		try {

			List<WorkOrderEntry> workOrdersList = searchDao.getAllWorkOrdersList();
			List<WorkOrdersListDto> workOrderResponse = new ArrayList<>();
			for (WorkOrderEntry entry : workOrdersList) {
				workOrderResponse.add(new WorkOrdersListDto(entry.getWorkOrderId(), entry.getWorkOrderId()));
			}
			workOrderMap.put("workOrdersList", workOrderResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workOrderMap;
	}

}
