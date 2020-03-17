
package com.mro.drc.dashboard.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mro.drc.dashboard.dao.DashboardDao;
import com.mro.drc.dashboard.dto.WordOrderFilterResponse;
import com.mro.drc.dashboard.domain.Customer;
import com.mro.drc.dashboard.domain.Parts;
import com.mro.drc.dashboard.domain.Receiving;
import com.mro.drc.dashboard.domain.WorkOrderEntry;
import com.mro.drc.dashboard.domain.WorkOrderStatus;

// @RunWith(MockitoJUnitRunner.class) 

public class DashboardServiceImplTest {

	private static final String PRIORITY = "high";

	private static final String REPAIR = "Normal Repair";

	@InjectMocks
	DashboardServiceImpl dashBoardServiceImp;

	@Mock
	DashboardDao dashboardDao;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	Date myDate = new Date(2014, 02, 11);

	public List<WorkOrderEntry> DashBoardServiceData() {
		List<WorkOrderEntry> dummydata = new ArrayList<>();

		WorkOrderEntry sampleData = new WorkOrderEntry();

		Parts Part = new Parts();
		Part.setPartName("tier");
		Part.setPartName("part_01");

		Customer lkupCustomer = new Customer();
		lkupCustomer.setCustName("British Airlines");

		sampleData.setWorkOrderId(10);
		sampleData.setCreatedOn(myDate);
		WorkOrderStatus wo=new WorkOrderStatus();
		wo.setStatusDesc("Normal Repair");
		Receiving receiving =new Receiving();
		receiving.setStatusId(wo);
		sampleData.setReceiving(receiving);
		sampleData.setPriority("high");
		sampleData.setPart(Part);
		sampleData.setCustomer(lkupCustomer);
		dummydata.add(sampleData);
		return dummydata;
	}

	@Test
	public void CountOfOpenWorkOrderRecordsTest() throws Exception {
		Mockito.when(dashboardDao.getCountOfOpenWorkOrderRecords()).thenReturn(DashBoardServiceData().size());
		int response = dashBoardServiceImp.getCountOfOpenWorkOrderRecords();
		assertEquals(response, 1);
	}

	@Test
	public void OpenWorkOrderRecordsTest() throws Exception {
		Mockito.when(dashboardDao.getOpenWorkOrderRecords()).thenReturn(DashBoardServiceData());
		List<WordOrderFilterResponse> response = dashBoardServiceImp.getOpenWorkOrderRecords();
		assertEquals("Normal Repair", response.get(0).getGateStatus());
	}

	@Test
	public void CountOfCustomerCountRecordsTest() throws Exception {
		Mockito.when(dashboardDao.getCountOfCustomerCountRecords()).thenReturn(DashBoardServiceData().size());
		int response = dashBoardServiceImp.getCountOfCustomerCountRecords();
		assertEquals(response, 1);
	}

	@Test
	public void CustomerRecordsTest() throws Exception {
		Mockito.when(dashboardDao.getCustomerRecords()).thenReturn(DashBoardServiceData());
		List<WordOrderFilterResponse> response = dashBoardServiceImp.getCustomerRecords();
		assertEquals("British Airlines", response.get(0).getCustomerName());

	}

	@Test
	public void getCountOfHighPriorityRecordsTest() throws Exception {
		Mockito.when(dashboardDao.getCountOfHighPriorityRecords(PRIORITY)).thenReturn(DashBoardServiceData().size());
		int response = dashBoardServiceImp.getCountOfHighPriorityRecords();
		assertEquals(response, 1);
		assertEquals(PRIORITY, DashBoardServiceData().get(0).getPriority());
	}

	@Test
	public void getCountOfRepairRecordsTest() throws Exception {
		Mockito.when(dashboardDao.getCountOfRepairRecords(REPAIR)).thenReturn(DashBoardServiceData().size());
		int response = dashBoardServiceImp.getCountOfRepairRecords();
		assertEquals(response, 1);
		assertEquals(REPAIR, DashBoardServiceData().get(0).getReceiving().getStatusId().getStatusDesc());
	}

	@Test
	public void getHighPriorityRecordsTest() throws Exception {
		Mockito.when(dashboardDao.getHighPriorityRecords(PRIORITY)).thenReturn(DashBoardServiceData());
		List<WordOrderFilterResponse> response = dashBoardServiceImp.getHighPriorityRecords();
		assertEquals(PRIORITY, response.get(0).getPriority());
	}

	@Test
	public void getRepairRecordsTest() throws Exception {
		Mockito.when(dashboardDao.getRepairRecords("Normal Repair")).thenReturn(DashBoardServiceData());
		System.out.println(DashBoardServiceData().get(0).getReceiving().getStatusId().getStatusDesc());
		List<WordOrderFilterResponse> response = dashBoardServiceImp.getRepairRecords();
		System.out.println(response);
		assertEquals("Normal Repair", response.get(0).getGateStatus());
		assertEquals("British Airlines", response.get(0).getCustomerName());
	}
}
