package com.mro.drc.administrator.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.mro.drc.administrator.entity.SmtpServerConfig;

/**
 * @author 40008878
 * Repository to get the details from SmtpServerConfig table
 *
 */
public interface SmtpServerConfigDao extends JpaRepository<SmtpServerConfig, Integer> {

	/**
	 * @return complete list from SmtpServerConfig table
	 */
	@Query("from SmtpServerConfig")
	List<SmtpServerConfig> getSMTPServerList();

	/**
	 * @param id : query to fetch record based on id
	 * @return specific record based on Id
	 */
	@Query("from SmtpServerConfig where id = :id")
	SmtpServerConfig getSMTPserverById(@RequestParam("id") Integer id);

}
