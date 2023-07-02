package com.infosys.ultra.auditors.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.infosys.ultra.auditors.exception.ClientNotFoundException;
import com.infosys.ultra.auditors.model.ClientEntity;
import com.infosys.ultra.auditors.repository.ClientRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
//@Slf4j
@AllArgsConstructor
@Component
public class ClientServiceImpl{
	
	@Autowired
	private ClientRepository clientRepository;

	public ClientEntity getClient(int id){
		ClientEntity client = clientRepository.findById(id);
		
		if (client==null) {
			throw new ClientNotFoundException("no.client.found");
		} else {
		return client;
		}
	}
}
