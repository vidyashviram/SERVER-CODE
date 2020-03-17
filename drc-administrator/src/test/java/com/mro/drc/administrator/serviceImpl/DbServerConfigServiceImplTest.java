
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

import com.mro.drc.administrator.dao.DbServerConfigDao;
import com.mro.drc.administrator.entity.DbServerConfig;
import com.mro.drc.administrator.serviceImpl.DbServerConfigServiceImpl;

public class DbServerConfigServiceImplTest {

	@Mock
	private DbServerConfigDao dbServerConfigDao;
	@InjectMocks
	private DbServerConfigServiceImpl dbServerConfigServiceImpl;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	private List<DbServerConfig> dbServerConfigData() {
		List<DbServerConfig> dummyData = new ArrayList<DbServerConfig>();
		DbServerConfig dbServerConfigData = new DbServerConfig();
		dbServerConfigData.setId(1);
		dbServerConfigData.setDataBaseName("mySql");
		dbServerConfigData.setDbUrl("WWW.test.com");
		dbServerConfigData.setPassword("xyz");
		dbServerConfigData.setUserName("User1");
		dummyData.add(dbServerConfigData);
		return dummyData;
	}

	@Test
	public void addDbServerRecordTest() {

		DbServerConfig dbServerAddRequest = dbServerConfigData().get(0);
		Mockito.when(dbServerConfigDao.saveAndFlush(dbServerAddRequest)).thenReturn(dbServerAddRequest);
		assertEquals("Success", dbServerConfigServiceImpl.addDbServerRecord(dbServerAddRequest).get("message"));

	}

	@Test
	public void getDBServerListTest() throws Exception {
		Mockito.when(dbServerConfigDao.getDBServerList()).thenReturn(dbServerConfigData());
		assertEquals("mySql", dbServerConfigServiceImpl.getDBServerList().get(0).getDataBaseName());
	}

	@Test
	public void getDbServerConfigByIdTest() throws Exception {
		Mockito.when(dbServerConfigDao.getDbServerConfigById(dbServerConfigData().get(0).getId()))
				.thenReturn(dbServerConfigData().get(0));
		DbServerConfig dbServerAddRequest = dbServerConfigServiceImpl.getDbServerConfigById(dbServerConfigData().get(0).getId());
		assertEquals("User1", dbServerAddRequest.getUserName());
	}
}
