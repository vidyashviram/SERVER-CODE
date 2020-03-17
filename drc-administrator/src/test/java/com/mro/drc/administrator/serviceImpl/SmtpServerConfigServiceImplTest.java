package com.mro.drc.administrator.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mro.drc.administrator.dao.SmtpServerConfigDao;
import com.mro.drc.administrator.entity.SmtpServerConfig;
import com.mro.drc.administrator.serviceImpl.SmtpServerConfigServiceImpl;

public class SmtpServerConfigServiceImplTest {

	@Mock
	private SmtpServerConfigDao smtpServerConfigDao;

	@InjectMocks
	private SmtpServerConfigServiceImpl smtpServerConfigServiceImpl;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	private List<SmtpServerConfig> smtpServerConfigDate() {
		List<SmtpServerConfig> dummyData = new ArrayList<SmtpServerConfig>();
		SmtpServerConfig smtpServerConfigData = new SmtpServerConfig();
		smtpServerConfigData.setSmtpServer("mySql");
		smtpServerConfigData.setPort("8080");
		smtpServerConfigData.setPassword("xyz");
		smtpServerConfigData.setUserName("User1");
		dummyData.add(smtpServerConfigData);
		return dummyData;
	}

	@Test
	public void addSmtpServerRecordTest() {

		SmtpServerConfig smtpServerAddRequest = smtpServerConfigDate().get(0);
		Mockito.when(smtpServerConfigDao.saveAndFlush(smtpServerAddRequest)).thenReturn(smtpServerAddRequest);
		Map<String, String> response = smtpServerConfigServiceImpl.addSmtpServerRecord(smtpServerAddRequest);
		assertEquals("Success", response.get("message"));

	}

	@Test
	public void getSMTPServerListTest() throws Exception {
		Mockito.when(smtpServerConfigDao.getSMTPServerList()).thenReturn(smtpServerConfigDate());
		List<SmtpServerConfig> smtpList = smtpServerConfigServiceImpl.getSMTPServerList();
		assertEquals("8080", smtpList.get(0).getPort());
	}

	@Test
	public void getSMTPserverByIdTest() throws Exception {
		Mockito.when(smtpServerConfigDao.getSMTPserverById(smtpServerConfigDate().get(0).getId()))
				.thenReturn(smtpServerConfigDate().get(0));
		SmtpServerConfig smtpList = smtpServerConfigServiceImpl
				.getSMTPserverById(smtpServerConfigDate().get(0).getId());
		assertEquals("8080", smtpList.getPort());
	}
}
