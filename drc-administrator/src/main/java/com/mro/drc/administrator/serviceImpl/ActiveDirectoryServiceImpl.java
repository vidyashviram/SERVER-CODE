package com.mro.drc.administrator.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mro.drc.administrator.dao.ActiveDirectoryDao;
import com.mro.drc.administrator.entity.LdapServerConfig;
import com.mro.drc.administrator.service.ActiveDirectoryService;

/**
 * @author 40008878 SERVICE to implement the methods for Fetch and Save details
 *         from Active directory
 */
@Service
public class ActiveDirectoryServiceImpl implements ActiveDirectoryService {
	private static final Logger LOG = Logger.getLogger(ActiveDirectoryServiceImpl.class.getName());
	@Autowired
	private ActiveDirectoryDao activeDirectoryDoa;

	/**
	 * Service to save the Active directory details to Data base
	 */
	@Override
	public Map<String, String> addLdapServerRecord(LdapServerConfig ldapDataRequest) {
		LOG.info("Inside addLdapServerRecord");
		Map<String, String> result = new HashMap<String, String>();
		if (ldapDataRequest != null) {
			activeDirectoryDoa.saveAndFlush(ldapDataRequest);
			result.put("message", "Success");
		} else {
			result.put("message", "Bad Request");
		}
		LOG.info("The response received by addLdapServerRecord is " + result);
		return result;
	}

	/**
	 * Service to return Ldap list from Data base
	 */
	@Override
	public List<LdapServerConfig> getLdapList() throws Exception {
		LOG.info("Inside addLdapServerRecord");
		List<LdapServerConfig> ldapList = new ArrayList<LdapServerConfig>();
		try {
			ldapList = activeDirectoryDoa.getLdapList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("The response received by addLdapServerRecord is " + ldapList);
		return ldapList;
	}

	/**
	 * Service to return single LDAP details based on ID
	 */
	@Override
	public LdapServerConfig getLdapDetailsById(Integer id) throws Exception {
		LOG.info("Inside getLdapDetailsById");
		LdapServerConfig ldapDetails = new LdapServerConfig();

		try {
			ldapDetails = activeDirectoryDoa.getLdapDetailsById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("The response received by getLdapDetailsById is " + ldapDetails);
		return ldapDetails;
	}

}
