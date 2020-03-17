package com.mro.drc.workflow.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mro.drc.workflow.dao.GateProcessDao;
import com.mro.drc.workflow.dao.GatesCountDao;
import com.mro.drc.workflow.dao.ProcessDao;
import com.mro.drc.workflow.domain.GatesCount;
import com.mro.drc.workflow.domain.GatesProcess;
import com.mro.drc.workflow.domain.MroProcess;

public class WorkflowManagementServiceImplTest {

	@InjectMocks
	WorkflowManagementServiceImpl workflowManagementServiceImpl;

	@Mock
	GateProcessDao gateProcessDao;

	@Mock
	GatesCountDao gatesCountDao;

	@Mock
	ProcessDao processDao;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}            

	@Test
	public void getProcessData() throws Exception {
		List<MroProcess> result = new ArrayList<MroProcess>();
		MroProcess process1 = new MroProcess();
		process1.setProcessId(1);
		process1.setProcessName("Warranty");
		MroProcess process2 = new MroProcess();
		process2.setProcessId(1);
		process2.setProcessName("CMM");
		result.add(process1);
		result.add(process2);
		Mockito.when(processDao.getProcessDetails()).thenReturn(result);
		List<MroProcess> response = workflowManagementServiceImpl.getProcessData();
		assertEquals(2, response.size());
		assertEquals("Warranty", response.get(0).getProcessName());
		assertEquals("CMM", response.get(1).getProcessName());
	}

	@Test
	public void saveGateCount() throws Exception {
		GatesCount gatesCount = new GatesCount();
		gatesCount.setGatesCount(2);
		Mockito.when(gatesCountDao.save(gatesCount)).thenReturn(gatesCount);
		Map<String, String> response = workflowManagementServiceImpl.saveGateCount(gatesCount);
		assertEquals("Success", response.get("message"));
	}

	@Test   
	public void saveGateProcessData() throws Exception {
		List<GatesProcess> res = new ArrayList<GatesProcess>();
		GatesProcess g1 = new GatesProcess();
		g1.setGatesName("Gate 0");
		g1.setProcessName("Warranty,WorkOrders");
		g1.setId(13);
		GatesProcess g2 = new GatesProcess();
		g2.setGatesName("Gate 1");
		g2.setProcessName("Repair,CMM");
		g2.setId(13);
		res.add(g1);
		res.add(g2);
		Mockito.when(gateProcessDao.save(res.get(0))).thenReturn(res.get(0));
		Mockito.when(gateProcessDao.save(res.get(1))).thenReturn(res.get(1));
		Map<String, String> response = workflowManagementServiceImpl.saveGateProcessData(res);
		assertEquals("Success", response.get("message"));
	}
}
