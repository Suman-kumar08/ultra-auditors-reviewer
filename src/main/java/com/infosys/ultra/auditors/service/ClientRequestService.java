package com.infosys.ultra.auditors.service;

import java.util.List;

import com.infosys.ultra.auditors.model.AuditorSample;
import com.infosys.ultra.auditors.model.ClientAuditor;
import com.infosys.ultra.auditors.model.ClientEntity;
import com.infosys.ultra.auditors.model.ClientRequest;

public interface ClientRequestService {
	public String registerClient(ClientEntity client);
	public List<ClientAuditor> getClientByReq(String emaiid);
	public List<AuditorSample> retrieveAllAuditor(ClientRequest clientreq);
	public String acceptOffer(String requestId);
	public String rejectOffer(String requestId);


	
}

