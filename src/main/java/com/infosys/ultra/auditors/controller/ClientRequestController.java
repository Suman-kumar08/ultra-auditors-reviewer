package com.infosys.ultra.auditors.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.ultra.auditors.dto.AuditType;
import com.infosys.ultra.auditors.model.AuditorSample;
import com.infosys.ultra.auditors.model.ClientAuditor;
import com.infosys.ultra.auditors.model.ClientEntity;
import com.infosys.ultra.auditors.model.ClientRequest;
import com.infosys.ultra.auditors.service.ClientRequestService;

@RestController
@RequestMapping("/v1/api")
public class ClientRequestController {
	@Autowired
	ClientRequestService crs;
	
	private static final Logger logger = LoggerFactory.getLogger(ClientRequestController.class);


	@PutMapping(value = "/client/register", consumes = "application/json")
	public ResponseEntity<String> registerClient(@RequestBody ClientEntity client) {
		logger.info("registerClient() ------> start");
		String response = crs.registerClient(client);
		logger.info("registerClient() <------ end");
		return ResponseEntity.ok().body(response);
		

	}

	// no db call as of now
	@PutMapping(value = "/client/request", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<AuditorSample>> retrieveAllAuditor(@RequestBody ClientRequest clientreq) {
		logger.info("retrieveAllAuditor() ------> start");
		List<AuditorSample> allAuditors = crs.retrieveAllAuditor(clientreq);
		logger.info("retrieveAllAuditor() <------ end");
		return ResponseEntity.ok().body(allAuditors);

	}

	// based on client id i.e. emailid
	@GetMapping(value = "/client/allRequest/{emailid}", produces = "application/json")
	public ResponseEntity<List<ClientAuditor>> getClientById(@PathVariable String emailid) {
		logger.info("getClientById() ------> start");
		List<ClientAuditor> client = crs.getClientByReq(emailid);
		logger.info("getClientById() <------ end");
		return ResponseEntity.ok().body(client);

	}

	@PutMapping(value = "/client/accept/{requestId}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> acceptOffer(@PathVariable String requestId) {
		logger.info("acceptOffer() ------> start");
		String response = crs.acceptOffer(requestId);
		logger.info("acceptOffer() <------ end");
		return ResponseEntity.ok().body(response);

	}

	@PutMapping(value = "/client/reject/{requestId}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> rejectOffer(@PathVariable String requestId) {
		logger.info("rejectOffer() ------> start");
		String response = crs.acceptOffer(requestId);
		logger.info("rejectOffer() <------ end");
		return ResponseEntity.ok().body(response);

	}

}
