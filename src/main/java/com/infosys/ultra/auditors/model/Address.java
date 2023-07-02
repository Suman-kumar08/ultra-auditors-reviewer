package com.infosys.ultra.auditors.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "address")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address_line")
    private String addressLine;
    @Column(name = "state")
    private String state;
    @Column(name = "district")
    private String district;
    @Column(name = "pin_code")
    private Long pinCode;

    public Address() {
    }
}
