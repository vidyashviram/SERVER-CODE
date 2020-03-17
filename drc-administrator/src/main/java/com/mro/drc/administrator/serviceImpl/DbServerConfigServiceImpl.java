package com.mro.drc.administrator.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.administrator.dao.DbServerConfigDao;
import com.mro.drc.administrator.entity.DbServerConfig;
import com.mro.drc.administrator.service.DbServerConfigService;

/**
 * @author 20126161 SERVICE Implemented to save the details to database and to
 *         fetch the records from database based on ID
 */
@Service
public class DbServerConfigServiceImpl implements DbServerConfigService {
	private static final Logger LOG = Logger.getLogger(DbServerConfigServiceImpl.class.getName());
	@Autowired
	DbServerConfigDao dbServerConfigDao;

	/**
	 * Service implemented to save/update details to DbServerConfig table
	 */
	@Override
	public Map<String, String> addDbServerRecord(DbServerConfig dbDataRequest) {
		LOG.info("Inside addDbServerRecord");
		Map<String, String> result = new HashMap<String, String>();
		if (dbDataRequest != null) {
			dbServerConfigDao.saveAndFlush(dbDataRequest);
			result.put("message", "Success");
		} else {
			result.put("message", "Bad Request");
		}
		LOG.info("The response received by addDbServerRecord is " + result);
		return result;
	}

	/**
	 * Service implemented to fetch all the records from DbServerConfig table
	 */
	@Override
	public List<DbServerConfig> getDBServerList() throws Exception {
		LOG.info("Inside getDBServerList");
		List<DbServerConfig> dbConfigList = new ArrayList<DbServerConfig>();
		try {
			dbConfigList = dbServerConfigDao.getDBServerList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("The response received by getDBServerList is " + dbConfigList);
		return dbConfigList;
	}

	/**
	 * Service implemented to fetch DbServerConfig details by ID
	 */
	@Override
	public DbServerConfig getDbServerConfigById(Integer id) throws Exception {
		LOG.info("Inside getDbServerConfigById");
		DbServerConfig dbConfig = new DbServerConfig();
		try {
			dbConfig = dbServerConfigDao.getDbServerConfigById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("The response received by getDbServerConfigById is " + dbConfig);
		return dbConfig;
	}

}
