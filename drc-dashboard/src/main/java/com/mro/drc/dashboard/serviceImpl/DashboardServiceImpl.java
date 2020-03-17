package com.mro.drc.dashboard.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.dashboard.dao.DashboardDao;
import com.mro.drc.dashboard.domain.WorkOrderEntry;
import com.mro.drc.dashboard.dto.WordOrderFilterResponse;
import com.mro.drc.dashboard.service.DashboardService;

/**
 * 
 * @author 20126160 This class provides the implementation for services.
 */

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DashboardDao dashboardDao;

	private static final String PRIORITY = "high"; // Value to fetch high priority data.

	private static final String REPAIR = "Normal Repair"; // Repair value

	/**
	 * To get the total count of high prioiry details
	 */
	@Override
	public Integer getCountOfHighPriorityRecords() {

		return dashboardDao.getCountOfHighPriorityRecords(PRIORITY);
	}

	/**
	 * To get the total count of Repair records
	 */
	@Override
	public Integer getCountOfRepairRecords() throws Exception {
		return dashboardDao.getCountOfRepairRecords(REPAIR);
	}

	/**
	 * To get the count of Open workorders
	 */
	@Override
	public Integer getCountOfOpenWorkOrderRecords() throws Exception {
		return dashboardDao.getCountOfOpenWorkOrderRecords();
	}

	/**
	 * To get the total number of customers
	 */
	@Override
	public Integer getCountOfCustomerCountRecords() throws Exception {
		return dashboardDao.getCountOfCustomerCountRecords();
	}

	/**
	 * To get the high priority work order details
	 */
	@Override
	public List<WordOrderFilterResponse> getHighPriorityRecords() throws Exception {
		List<WordOrderFilterResponse> workOrderResponse = sendWOResponse(dashboardDao.getHighPriorityRecords(PRIORITY));
		return workOrderResponse;
	}

	/**
	 * To get the repair details
	 */
	@Override
	public List<WordOrderFilterResponse> getRepairRecords() throws Exception {
		List<WordOrderFilterResponse> workOrderResponse = sendWOResponse(dashboardDao.getRepairRecords(REPAIR));
		return workOrderResponse;
	}

	/**
	 * To get the Open work order records
	 */
	@Override
	public List<WordOrderFilterResponse> getOpenWorkOrderRecords() throws Exception {
		List<WordOrderFilterResponse> workOrderResponse = sendWOResponse(dashboardDao.getOpenWorkOrderRecords());
		return workOrderResponse;
	}

	/**
	 * To get the customer details
	 */
	@Override
	public List<WordOrderFilterResponse> getCustomerRecords() throws Exception {
		List<WordOrderFilterResponse> workOrderResponse = sendWOResponse(dashboardDao.getCustomerRecords());
		return workOrderResponse;
	}

	/**
	 * @param list
	 * @return List<WordOrderFilterResponse> To form the filter object from the
	 *         WorkOrderEntry entity with specific columns to send the response.
	 */
	private List<WordOrderFilterResponse> sendWOResponse(List<WorkOrderEntry> list) {
		List<WordOrderFilterResponse> workOrderResponse = new ArrayList<>();

		for (WorkOrderEntry entry : list) {
			workOrderResponse.add(new WordOrderFilterResponse(entry.getWorkOrderId(), entry.getCreatedOn(),
					entry.getReceiving().getStatusId().getStatusDesc(), entry.getPart().getPartNum(), entry.getPriority(),
					entry.getCustomer().getCustName(), entry.getPart().getPartName()));
		}

		return workOrderResponse;
	}
}
