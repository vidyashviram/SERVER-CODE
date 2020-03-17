package com.mro.drc.administrator.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gatesprocess")
public class GatesProcess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gateid")
	private Integer gateId;
	
	@Column(name = "gatesname")
	private String gatesName;
	
	@Column(name = "processname")
	private String processName;
	
	@ManyToOne
	@JoinColumn(name="id")
	private WorkFlowProcess workFlow;
	
	@Column(name = "createddate")
	private Date createdDate;
	
	@Column(name = "modifieddate")
	private Date modifiedDate;

	public Integer getGateId() {
		return gateId;
	}

	public void setGateId(Integer gateId) {
		this.gateId = gateId;
	}

	public String getGatesName() {
		return gatesName;
	}

	public void setGatesName(String gatesName) {
		this.gatesName = gatesName;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public WorkFlowProcess getWorkFlow() {
		return workFlow;
	}

	public void setWorkFlow(WorkFlowProcess workFlow) {
		this.workFlow = workFlow;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
