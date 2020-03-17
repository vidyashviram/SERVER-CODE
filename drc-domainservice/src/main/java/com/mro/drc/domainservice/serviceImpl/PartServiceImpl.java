package com.mro.drc.domainservice.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.domainservice.dao.PartDao;
import com.mro.drc.domainservice.domain.Parts;
import com.mro.drc.domainservice.dto.PartNamesListDto;
import com.mro.drc.domainservice.dto.PartNumbersListDto;
import com.mro.drc.domainservice.service.PartService;

/**
 * @author 40008878
 * Service Implementation for unimplemented Plant methods
 *
 */
@Service
public class PartServiceImpl implements PartService {

	@Autowired
	private PartDao partDao;

	/**
	 * Returns Part names and part names for drop down
	 */
	@Override
	public Map<String, List<PartNamesListDto>> getPartNameList() throws Exception {
		Map<String, List<PartNamesListDto>> partNameMap = new HashMap<>();
		try {
			List<Object[]> partNameslist = partDao.getAllPartList();
			List<PartNamesListDto> partNamesResponse = new ArrayList<>();
			for (Object[] entry : partNameslist) {
				String partName  = (String) entry[0];
				Integer partId = (Integer) entry[1];
				partNamesResponse.add(new PartNamesListDto(partId, partName));
			}
			partNameMap.put("partNames", partNamesResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return partNameMap;
	}

	/**
	 * Returns Part names and part numbers for drop down
	 */
	@Override
	public Map<String, List<PartNumbersListDto>> getPartNumList(String partName) throws Exception {
		Map<String, List<PartNumbersListDto>> partNumMap = new HashMap<>();
		try {
			List<Parts> partList = partDao.getPartNumByPartName(partName);
			List<PartNumbersListDto> partListResponse = new ArrayList<>();
			for (Parts entry : partList) {
				partListResponse.add(new PartNumbersListDto(entry.getPartId(), entry.getPartNum()));
			}
			partNumMap.put("partList", partListResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return partNumMap;
	}

}
