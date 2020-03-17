package com.mro.drc.domainservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mro.drc.domainservice.domain.DistributionChannel;

/**
 * @author 40008878
 *
 */
public interface DistributionChannelDao extends JpaRepository<DistributionChannel, Integer>{

	/**
	 * @return : Distribution channel records from table
	 */
	@Query("from DistributionChannel")
	List<DistributionChannel> getAllClassificationList();

}
