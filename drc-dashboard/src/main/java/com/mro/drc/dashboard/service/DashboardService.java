package com.mro.drc.dashboard.service;

import java.util.List;

import com.mro.drc.dashboard.dto.WordOrderFilterResponse;

/**
 * @author 20126160 This interface will provide the services.
 */
public interface DashboardService {

	/**
	 * @return
	 * @throws Exception
	 */
	Integer getCountOfHighPriorityRecords() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	Integer getCountOfRepairRecords() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	Integer getCountOfOpenWorkOrderRecords() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	Integer getCountOfCustomerCountRecords() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	List<WordOrderFilterResponse> getHighPriorityRecords() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	List<WordOrderFilterResponse> getRepairRecords() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	List<WordOrderFilterResponse> getOpenWorkOrderRecords() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	List<WordOrderFilterResponse> getCustomerRecords() throws Exception;

}
