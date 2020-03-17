package com.mro.drc.domainservice.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.domainservice.dto.MaterialListDto;

/**
 * @author 40008878
 *
 */
public interface MaterialsService {

	Map<String, List<MaterialListDto>> getMaterialList() throws Exception;

}
