package com.mro.drc.workflow.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 20126160
 *Entity class of gatesprocess table
 */
@Entity
@Component
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
	
	@Column(name = "id")
	private Integer id;
	
	@JsonFormat(pattern = "dd-MM-yyyy")   
	@Column(name = "createddate")
	private Date createdDate;
	
	@JsonFormat(pattern = "dd-MM-yyyy")   
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
