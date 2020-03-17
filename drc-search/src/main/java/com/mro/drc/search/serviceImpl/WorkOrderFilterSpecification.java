package com.mro.drc.search.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.mro.drc.search.common.SearchConstants;
import com.mro.drc.search.domain.WorkOrderEntry;
import com.mro.drc.search.dto.WorkOrderFilter;

/**
 * @author 40008878 
 * Implemented Specifications for Search Filter functionality
 */
public class WorkOrderFilterSpecification implements Specification<WorkOrderEntry> {


	private static final long serialVersionUID = 1L;

	private WorkOrderFilter workOrderFilter;

	public WorkOrderFilterSpecification(WorkOrderFilter workOrderFilter) {
		this.workOrderFilter = workOrderFilter;
	}

	/**
	 * To create WHERE clause in Query based on the filters selected.
	 */
	@Override
	public Predicate toPredicate(Root<WorkOrderEntry> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicateList = new ArrayList<>();
		if (workOrderFilter != null) {
			createPredicate(cb, predicateList, root);
		}
		return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
	}

	/**
	 * @param cb : CriteriaBuilder
	 * @param predicateList : List of predicates
	 * @param root : Main entity
	 */
	private void createPredicate(CriteriaBuilder cb, List<Predicate> predicateList, Root<WorkOrderEntry> root) {

		if (workOrderFilter.getWorkOrderId() != null && workOrderFilter.getWorkOrderId() != 0) {
			predicateList.add(cb.equal(root.get(SearchConstants.WORK_ORDER_ID), workOrderFilter.getWorkOrderId()));
		}
		if (workOrderFilter.getGateStatus() != null && workOrderFilter.getGateStatus() != 0) {
			predicateList.add(cb.equal(root.get(SearchConstants.RECEIVING).get(SearchConstants.WORK_STATUS).get(SearchConstants.STATUS_ID), workOrderFilter.getGateStatus()));
		}
		if (workOrderFilter.getPartNum() != null && workOrderFilter.getPartNum() != 0) {
			predicateList.add(cb.equal(root.get(SearchConstants.PART).get(SearchConstants.PART_ID), workOrderFilter.getPartNum()));
		}
		/*
		 * if (workOrderFilter.getPartName() != null && workOrderFilter.getPartName() !=
		 * 0) {
		 * predicateList.add(cb.equal(root.get(SearchConstants.PART).get(SearchConstants
		 * .PART_ID), workOrderFilter.getPartName())); }
		 */
		if (workOrderFilter.getCustName() != null && workOrderFilter.getCustName().length() > 0) {
			predicateList.add(cb.equal(root.get(SearchConstants.CUSTOMER).get(SearchConstants.CUSTOMER_NAME), workOrderFilter.getCustName()));
		}
		if (workOrderFilter.getMaterial() != null && workOrderFilter.getMaterial().length() > 0) {
			predicateList.add(cb.equal(root.get(SearchConstants.MATERIAL).get(SearchConstants.MATERIAL_TYPE), workOrderFilter.getMaterial()));
		}
		if (workOrderFilter.getDistributionChannelId() != null && workOrderFilter.getDistributionChannelId() != 0) {
			predicateList.add(cb.equal(root.get(SearchConstants.RECEIVING).get(SearchConstants.DIST_CHANNEL).get(SearchConstants.DIST_CHANNEL_ID),
					workOrderFilter.getDistributionChannelId()));
		}
		if (workOrderFilter.getFromDate() != null && workOrderFilter.getToDate() != null) {
			predicateList
					.add(cb.between(root.get(SearchConstants.CREATED_ON), workOrderFilter.getFromDate(), workOrderFilter.getToDate()));
		}
	}
}
