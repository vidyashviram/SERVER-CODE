package com.mro.drc.administrator.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.administrator.entity.LdapServerConfig;

/**
 * @author 40008878
 * 
 */
public interface ActiveDirectoryService {

	Map<String, String> addLdapServerRecord(LdapServerConfig ldapDataRequest);

	List<LdapServerConfig> getLdapList() throws Exception;

	LdapServerConfig getLdapDetailsById(Integer id) throws Exception;

}
