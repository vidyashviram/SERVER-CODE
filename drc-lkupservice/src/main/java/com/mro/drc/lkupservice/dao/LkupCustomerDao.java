package com.mro.drc.lkupservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mro.drc.lkupservice.lookup.LkupCustomer;

public interface LkupCustomerDao extends JpaRepository<LkupCustomer, Integer> {

	@Query("from LkupCustomer")
	List<LkupCustomer> getAllCustomersList();



}
