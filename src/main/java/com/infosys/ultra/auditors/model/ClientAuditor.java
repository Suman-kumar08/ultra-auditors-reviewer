package com.infosys.ultra.auditors.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clientAuditor")
public class ClientAuditor {
	@Id
	@Column(name="req_id")
	private String req_id; //string
	private String clientId;
	private String status;
	private String auditorId;

}
