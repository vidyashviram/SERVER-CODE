
package com.mro.drc.administrator.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mro.drc.administrator.dao.ActiveDirectoryDao;
import com.mro.drc.administrator.entity.LdapServerConfig;
import com.mro.drc.administrator.serviceImpl.ActiveDirectoryServiceImpl;

public class ActiveDirectoryServiceImplTest {

	@Mock
	private ActiveDirectoryDao activeDirectoryDao;
	@InjectMocks
	private ActiveDirectoryServiceImpl activeDirectoryServiceImpl;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	public LdapServerConfig ldapServer() {
		LdapServerConfig ldapServerConfig = new LdapServerConfig();
		ldapServerConfig.setDomain("domain1");
		ldapServerConfig.setDomaIndir("domainIndir1");
		ldapServerConfig.setDomaIndirGroup("domainIndirGroup1");
		ldapServerConfig.setDomaiNext("domainIndir2");
		ldapServerConfig.setHost("localhost");
		ldapServerConfig.setId(1);
		ldapServerConfig.setProtocol("TCP");
		ldapServerConfig.setServicePassword("test");
		ldapServerConfig.setServiceUserName("admin");
		return ldapServerConfig;
	}

	@Test
	public void addLdapServerRecordTest() {
		LdapServerConfig activeDirectoryRequest = ldapServer();
		Mockito.when(activeDirectoryDao.saveAndFlush(activeDirectoryRequest)).thenReturn(activeDirectoryRequest);
		assertEquals("Success", activeDirectoryServiceImpl.addLdapServerRecord(activeDirectoryRequest).get("message"));
	}
	
	@Test
	public void getLdapListTest() throws Exception {
		List<LdapServerConfig> ldapList = new ArrayList<LdapServerConfig>();
		ldapList.add(ldapServer());
		Mockito.when(activeDirectoryDao.getLdapList()).thenReturn(ldapList);
		assertEquals("domain1", activeDirectoryServiceImpl.getLdapList().get(0).getDomain());
	}

	@Test
	public void getLdapDetailsByIdTest() throws Exception {
		Mockito.when(activeDirectoryDao.getLdapDetailsById(ldapServer().getId())).thenReturn(ldapServer());
		LdapServerConfig ldapDetails = activeDirectoryServiceImpl.getLdapDetailsById(ldapServer().getId());
		assertEquals("localhost", ldapDetails.getHost());
	}
}
