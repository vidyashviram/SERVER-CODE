package com.mro.drc.search.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mro.drc.search.dao.SearchDao;
import com.mro.drc.search.domain.Customer;
import com.mro.drc.search.domain.DistributionChannel;
import com.mro.drc.search.domain.MaterialDetail;
import com.mro.drc.search.domain.Parts;
import com.mro.drc.search.domain.Receiving;
import com.mro.drc.search.domain.WorkOrderEntry;
import com.mro.drc.search.domain.WorkOrderStatus;
import com.mro.drc.search.dto.WordOrderFilterResponse;
import com.mro.drc.search.dto.WorkOrderFilter;
import com.mro.drc.search.dto.WorkOrderFilterCriteria;
import com.mro.drc.search.dto.WorkOrdersListDto;

public class SearchServiceImplTest {

	@Mock
	private SearchDao searchDao;

	@InjectMocks
	private WorkOrderFilterSpecification workOrderFilterSpecification;

	@InjectMocks
	private SearchServiceImpl service;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getWorkOrderListTest() throws Exception {

		List<WorkOrderEntry> workOrdersList = new ArrayList<>();
		WorkOrderEntry wc = new WorkOrderEntry();
		wc.setWorkOrderId(100);
		wc.setCreatedBy(1);
		workOrdersList.add(wc);

		Mockito.when(searchDao.getAllWorkOrdersList()).thenReturn(workOrdersList);

		Map<String, List<WorkOrdersListDto>> loadFilters = service.getWorkOrderList();
		assertEquals(100, loadFilters.get("workOrdersList").get(0).getWorkOrderId());
	}

	@Test
	public void getSearchResponseTest() throws Exception {
		Date date1 = new Date(11, 02, 2020);
		Date date2 = new Date(21, 02, 2020);
		WorkOrderFilterCriteria filterCriteria = new WorkOrderFilterCriteria();
		WorkOrderFilter workOrderFilter = new WorkOrderFilter();
		workOrderFilter.setCustName("British Airlines");
		workOrderFilter.setDistributionChannelId(1);
		workOrderFilter.setFromDate(date1);
		workOrderFilter.setGateStatus(1);
		workOrderFilter.setMaterial("Iron");
		workOrderFilter.setPartName(1);
		workOrderFilter.setPartNum(1);
		workOrderFilter.setToDate(date2);
		workOrderFilter.setWorkOrderId(100);
		filterCriteria.setWorkOrderFilter(workOrderFilter);

		MaterialDetail material = new MaterialDetail();
		material.setMaterialType("iron");

		WorkOrderStatus status = new WorkOrderStatus();
		status.setStatusDesc("Normal repair");

		DistributionChannel channel = new DistributionChannel();
		channel.setDistributionChannel("Aircraft");

		Receiving receive = new Receiving();
		receive.setWorkOrderStatus(status);
		receive.setDistributionChannelId(channel);

		Parts part = new Parts();
		part.setPartName("Part1");
		part.setPartNum("SL123");

		List<WorkOrderEntry> response = new ArrayList<WorkOrderEntry>();
		WorkOrderEntry order = new WorkOrderEntry();
		order.setWorkOrderId(2000);
		order.setCreatedOn(date1);
		order.setReceiving(receive);
		order.setPart(part);
		order.setPriority("High");
		order.setCustomer(new Customer());
		order.setPart(part);
		order.setMaterial(material);
		order.setReceiving(receive);

		response.add(order);

		Mockito.when(searchDao.findAll(new WorkOrderFilterSpecification(any()))).thenReturn(response);

		List<WordOrderFilterResponse> result = service.getSearchResponse(filterCriteria);
		assertEquals("High", result.get(0).getPriority());
	}

}
