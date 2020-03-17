package com.mro.drc.administrator.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.administrator.entity.DbServerConfig;

/**
 * @author 40008878
 *
 */
public interface DbServerConfigService {

	Map<String, String> addDbServerRecord(DbServerConfig dbDataRequest);

	List<DbServerConfig> getDBServerList() throws Exception;

	DbServerConfig getDbServerConfigById(Integer id) throws Exception;

}
