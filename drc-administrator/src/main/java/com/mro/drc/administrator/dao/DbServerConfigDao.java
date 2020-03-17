package com.mro.drc.administrator.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.mro.drc.administrator.entity.DbServerConfig;

/**
 * @author 40008878
 * 
 * Repository to fetch details from DbServerConfig table
 *
 */
public interface DbServerConfigDao extends JpaRepository<DbServerConfig, Integer> {

	/**
	 * @return : List of DB server config details
	 */
	@Query("from DbServerConfig")
	List<DbServerConfig> getDBServerList();

	/**
	 * @param id : fetch detail from DbServerConfig based on ID
	 * @return : record based on ID
	 */
	@Query("from DbServerConfig where id = :id")
	DbServerConfig getDbServerConfigById(@RequestParam("id") Integer id);
}
