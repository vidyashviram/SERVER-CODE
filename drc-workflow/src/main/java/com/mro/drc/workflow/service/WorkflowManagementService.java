package com.mro.drc.workflow.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.workflow.domain.GatesCount;
import com.mro.drc.workflow.domain.GatesProcess;
import com.mro.drc.workflow.domain.MroProcess;
/*
import com.mro.drc.workflow.domain.GatesCount;
import com.mro.drc.workflow.domain.GatesProcess;*/
//import com.mro.drc.entities.*;


public interface WorkflowManagementService {

	List<MroProcess> getProcessData();

	Map<String, String> saveGateCount(GatesCount gateCount);

	Map<String, String> saveGateProcessData(List<GatesProcess> gateProcessList);

}
