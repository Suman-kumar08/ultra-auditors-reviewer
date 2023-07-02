package com.infosys.ultra.auditors.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ClientsDTO {
	
	@NotNull
	@JsonProperty("clientId")
	private int clientId;
	
	@NotNull
	@JsonProperty("clientId")
	private String clientType;

}
