package com.mro.drc.workflow.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
import com.mro.drc.entities.GatesCount;
import com.mro.drc.entities.GatesProcess;
import com.mro.drc.entities.MroProcess;*/
import com.mro.drc.workflow.dao.GateProcessDao;
import com.mro.drc.workflow.dao.GatesCountDao;
import com.mro.drc.workflow.dao.ProcessDao;
import com.mro.drc.workflow.domain.GatesCount;
import com.mro.drc.workflow.domain.GatesProcess;
import com.mro.drc.workflow.domain.MroProcess;
import com.mro.drc.workflow.exception.CustomException;
/*import com.mro.drc.workflow.domain.GatesCount;
import com.mro.drc.workflow.domain.GatesProcess;*/
import com.mro.drc.workflow.service.WorkflowManagementService;

/**
 * @author 20126160 Service implemenation class to perform CRUD operations on
 *         Workflow tables Table
 *
 */
@Service
public class WorkflowManagementServiceImpl implements WorkflowManagementService {

	private static final Logger LOG = Logger.getLogger(WorkflowManagementServiceImpl.class.getName());

	@Autowired
	ProcessDao processDao;

	@Autowired
	GatesCountDao gatesCountDao;

	@Autowired
	GateProcessDao gateProcessDao;

	/**
	 * To fetch all the process data
	 */
	@Override
	public List<MroProcess> getProcessData() {
		LOG.info("Entered getProcessData");
		List<MroProcess> result = new ArrayList<MroProcess>();
		try {
			result = processDao.getProcessDetails();
		} catch (Exception e) {
			throw new CustomException("Exception occured", e.getMessage());
		}
		return result;
	}

	/**
	 * To save the Gate counts
	 */
	@Override
	public Map<String, String> saveGateCount(GatesCount gateCount) {
		LOG.info("Entered saveGateCount");
		Map<String, String> response = new HashMap<String, String>();
		try {
			if (gatesCountDao.save(gateCount) != null) {
				response.put("message", "Success");
			} else {
				response.put("message", "Failure");
			}
		} catch (Exception e) {
			throw new CustomException("Exception occured", e.getLocalizedMessage());
		}
		LOG.info("Response from saveGateCount is " + response);
		return response;
	}
    
	/**
	 * To save the gate process Data
	 */
	@Override
	public Map<String, String> saveGateProcessData(List<GatesProcess> gateProcess) {
		/*
		 * List<GatesProcess> res=new ArrayList<GatesProcess>(); GatesProcess g1=new
		 * GatesProcess(); g1.setGatesName("Gate 0");
		 * g1.setProcessName("Warranty,WorkOrders"); g1.setId(13); GatesProcess g2=new
		 * GatesProcess(); g2.setGatesName("Gate 1"); g2.setProcessName("Repair,CMM");
		 * g2.setId(13); res.add(g1); res.add(g2);
		 */
		LOG.info("Entered saveGateProcessData");
		Map<String, String> response = new HashMap<String, String>();
		try {
			for (int i = 0; i < gateProcess.size(); i++) {
				if (gateProcess.get(i).getGateId() == null) {
					gateProcess.get(i).setCreatedDate(new Date());
				}
				gateProcess.get(i).setModifiedDate(new Date());
				if (gateProcess.get(i) != null) {
					gateProcessDao.save(gateProcess.get(i));
					response.put("message", "Success");   
				} else {
					response.put("message", "Failure");
				}
			}
		} catch (Exception e) {
			throw new CustomException("Exception occured", e.getMessage());
		}
		LOG.info("Response from saveGateProcessData is " + response);
		return response;
	}
}
