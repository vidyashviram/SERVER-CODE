package com.mro.drc.domainservice.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.domainservice.dto.PartNamesListDto;
import com.mro.drc.domainservice.dto.PartNumbersListDto;

public interface PartService {

	Map<String, List<PartNamesListDto>> getPartNameList() throws Exception;

	Map<String, List<PartNumbersListDto>> getPartNumList(String partName) throws Exception;

}
