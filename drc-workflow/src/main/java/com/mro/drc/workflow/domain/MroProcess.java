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
 *Entity class of mroprocess table
 */
@Entity
@Component
@Table(name = "mroprocess")
public class MroProcess {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "processid")
	private Integer processId;

	@Column(name = "processname")
	private String processName;
	
	@JsonFormat(pattern = "dd-MM-yyyy")   
	@Column(name = "createddate")
	private Date createdDate;
	
	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
