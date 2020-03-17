package com.mro.drc.administrator.service;

import java.util.List;
import java.util.Map;

import com.mro.drc.administrator.entity.SmtpServerConfig;

/**
 * @author 40008878
 *
 */
public interface SmtpServerConfigService {

	Map<String, String> addSmtpServerRecord(SmtpServerConfig smtpDataRequest);

	List<SmtpServerConfig> getSMTPServerList() throws Exception;

	SmtpServerConfig getSMTPserverById(Integer id) throws Exception;

}
