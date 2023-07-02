package com.infosys.ultra.auditors.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientrequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",updatable = false, nullable = false) 
	private int id;
	@Column(name="req_id",unique=true,nullable=true)
	private String reqId;
	@Column(name="email_id")
	private String emailId;
	@Column(name="name")
	private String name;
	@Column(name="audit_freq")
	private String auditFrequency;
	@Column(name="industry_type")
	private String industryType;
	@Column(name="expect_start_date")
	private String expectedStartDate;
	@Column(name="expect_experience")
	private int expectedExcperience;
	@Column(name="budget")
	private double budget;
	@Column(name="experience")
	private int experience;
	@OneToOne(cascade = CascadeType.ALL)   
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	@Column(name="status")
	private String status;
	

}
