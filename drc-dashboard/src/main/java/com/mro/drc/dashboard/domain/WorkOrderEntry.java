package com.mro.drc.dashboard.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workorderentry")
public class WorkOrderEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "workorderid")
	private Integer workOrderId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "receivingid")
	private Receiving receiving;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid")
	private Customer customer;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "materialid")
	private MaterialDetail material;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "aircraftdispositionid")
	private AircraftDisposition aircraftDisposition;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "warrantyid")
	private Warranty warranty;

	@Column(name = "salesorg")
	private String salesOrg;

	@Column(name = "dockdate")
	private Date dockDate;

	@Column(name = "snnum")
	private Integer snNum;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "partid")
	private Parts part;

	@Column(name = "serialid")
	private Integer serialId;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "lastupdated")
	private Date lastUpdated;
	
	@Column(name = "createdon")
	private Date createdOn;
	
	@Column(name = "createdby")
	private Integer createdBy;
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "status")
	private String status;

	public Integer getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(Integer workOrderId) {
		this.workOrderId = workOrderId;
	}

	public Receiving getReceiving() {
		return receiving;
	}

	public void setReceiving(Receiving receiving) {
		this.receiving = receiving;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public MaterialDetail getMaterial() {
		return material;
	}

	public void setMaterial(MaterialDetail material) {
		this.material = material;
	}

	public AircraftDisposition getAircraftDisposition() {
		return aircraftDisposition;
	}

	public void setAircraftDisposition(AircraftDisposition aircraftDisposition) {
		this.aircraftDisposition = aircraftDisposition;
	}

	public Warranty getWarranty() {
		return warranty;
	}

	public void setWarranty(Warranty warranty) {
		this.warranty = warranty;
	}

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public Date getDockDate() {
		return dockDate;
	}

	public void setDockDate(Date dockDate) {
		this.dockDate = dockDate;
	}

	public Integer getSnNum() {
		return snNum;
	}

	public void setSnNum(Integer snNum) {
		this.snNum = snNum;
	}

	public Parts getPart() {
		return part;
	}

	public void setPart(Parts part) {
		this.part = part;
	}

	public Integer getSerialId() {
		return serialId;
	}

	public void setSerialId(Integer serialId) {
		this.serialId = serialId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
