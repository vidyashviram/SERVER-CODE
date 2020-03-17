package com.mro.drc.administrator.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mro.drc.administrator.entity.LdapServerConfig;

/**
 * @author 40008878
 * 
 * Repository to fetch details from LdapServerConfig table
 *
 */
public interface ActiveDirectoryDao extends JpaRepository<LdapServerConfig, Integer> {

	/**
	 * @return : Complete list of Ldap server
	 */
	@Query("from LdapServerConfig")
	List<LdapServerConfig> getLdapList();

	/**
	 * @param id : Query to fetch details based on ID
	 * @return : LDAP details based on ID
	 */
	@Query("from LdapServerConfig where id = :id")
	LdapServerConfig getLdapDetailsById(Integer id);
}
