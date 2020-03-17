package com.mro.drc.administrator.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.administrator.dao.SmtpServerConfigDao;
import com.mro.drc.administrator.entity.SmtpServerConfig;
import com.mro.drc.administrator.service.SmtpServerConfigService;

/**
 * @author 40008878 SERVICE implemented to fetch, save, update details to
 *         SmtpServerConfig table
 */
@Service
public class SmtpServerConfigServiceImpl implements SmtpServerConfigService {
	private static final Logger LOG = Logger.getLogger(SmtpServerConfigServiceImpl.class.getName());
	@Autowired
	SmtpServerConfigDao smtpServerConfigDao;

	/**
	 * Service to save/update details to SmtpServerConfig table
	 */
	@Override
	public Map<String, String> addSmtpServerRecord(SmtpServerConfig smtpDataRequest) {
		LOG.info("Inside addSmtpServerRecord");
		Map<String, String> result = new HashMap<String, String>();
		if (smtpDataRequest != null) {
			smtpServerConfigDao.saveAndFlush(smtpDataRequest);
			result.put("message", "Success");
		} else {
			result.put("message", "Bad Request");
		}
		LOG.info("The response received by addSmtpServerRecord is " + result);
		return result;
	}

	/**
	 * service to get the complete list from SmtpServerConfig
	 */
	@Override
	public List<SmtpServerConfig> getSMTPServerList() throws Exception {
		LOG.info("Inside getSMTPServerList");
		List<SmtpServerConfig> smtpConfigList = new ArrayList<SmtpServerConfig>();
		try {
			smtpConfigList = smtpServerConfigDao.getSMTPServerList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("The response received by getSMTPServerList is " + smtpConfigList);
		return smtpConfigList;
	}

	/**
	 * service to get the specific record based on ID
	 */
	@Override
	public SmtpServerConfig getSMTPserverById(Integer id) throws Exception {
		LOG.info("Inside getSMTPserverById");
		SmtpServerConfig smtpConfig = new SmtpServerConfig();
		try {
			smtpConfig = smtpServerConfigDao.getSMTPserverById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("The response received by getSMTPserverById is " + smtpConfig);
		return smtpConfig;
	}

}
