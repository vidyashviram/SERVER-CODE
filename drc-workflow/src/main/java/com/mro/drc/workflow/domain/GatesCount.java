package com.mro.drc.workflow.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author 20126160
 *Entity class of gatescount table
 */
@Entity
@Component
@Table(name = "gatescount")
public class GatesCount {
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "gatescount")
	private Integer gatesCount;

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

	
	

}