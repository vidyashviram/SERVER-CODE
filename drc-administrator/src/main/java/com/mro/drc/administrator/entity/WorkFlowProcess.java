package com.mro.drc.administrator.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "workflowprocess")
public class WorkFlowProcess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "gatescount")
	private Integer gatesCount;
	
	@OneToMany(mappedBy="workFlow")
	private List<GatesProcess> gatesprocess;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGatesCount() {
		return gatesCount;
	}

	public void setGatesCount(Integer gatesCount) {
		this.gatesCount = gatesCount;
	}

	public List<GatesProcess> getGatesprocess() {
		return gatesprocess;
	}

	public void setGatesprocess(List<GatesProcess> gatesprocess) {
		this.gatesprocess = gatesprocess;
	}
	
	
	
}
