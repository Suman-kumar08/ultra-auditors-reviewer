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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long clientId;
	@Column(name="name")
	private String name;
	@Column(name="company")
	private String company;
	@Column(name="phone_no")
	private long phone_no;
	@OneToOne(cascade = CascadeType.ALL)   
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	@Column(name="industry_type")
	private String Industry_type;
}
