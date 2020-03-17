package com.mro.drc.domainservice.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.domainservice.dao.MaterialsDao;
import com.mro.drc.domainservice.domain.Materials;
import com.mro.drc.domainservice.dto.MaterialListDto;
import com.mro.drc.domainservice.service.MaterialsService;

/**
 * @author 40008878
 *
 */
@Service
public class MaterialsServiceImpl implements MaterialsService {

	@Autowired
	private MaterialsDao materialDao;

	/**
	 * Returns Material list for Drop down
	 */
	@Override
	public Map<String, List<MaterialListDto>> getMaterialList() throws Exception {
		Map<String, List<MaterialListDto>> materialMap = new HashMap<>();
		try {
			List<Materials> materialList = materialDao.getAllMaterialList();
			List<MaterialListDto> materialResponse = new ArrayList<>();
			for (Materials entry : materialList) {
				materialResponse.add(new MaterialListDto(entry.getMaterialId(), entry.getMaterial()));
			}
			materialMap.put("materialList", materialResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materialMap;
	}

}
