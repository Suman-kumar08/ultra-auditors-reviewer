package com.infosys.ultra.auditors.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.ultra.auditors.dto.RequestStatus;
import com.infosys.ultra.auditors.exception.ClientNotRegisteredException;
import com.infosys.ultra.auditors.exception.ClientRequestNotFoundException;
import com.infosys.ultra.auditors.model.AuditorSample;
import com.infosys.ultra.auditors.model.ClientAuditor;
import com.infosys.ultra.auditors.model.ClientEntity;
import com.infosys.ultra.auditors.model.ClientRequest;
import com.infosys.ultra.auditors.repository.ClientAuditorRequestRepository;
import com.infosys.ultra.auditors.repository.ClientRepository;
import com.infosys.ultra.auditors.repository.ClientRequestRepository;
import com.infosys.ultra.auditors.service.ClientRequestService;

@Service
public class ClientRequestServiceImpl implements ClientRequestService {

	@Autowired
	ClientRequestRepository crr;
	
	@Autowired
	ClientRepository cr;
	
	@Autowired
	ClientAuditorRequestRepository carr;
	
	private static final Logger logger = LoggerFactory.getLogger(ClientRequestServiceImpl.class);

    /* 
     * retrieve all auditor
     * update in clientrequest database
     * return auditor 
     * 
     * */
	public List<AuditorSample> retrieveAllAuditor(ClientRequest clientreq) {
		logger.info("retrieveAllAuditor()----->start");
		ClientRequest clientrequest=crr.saveAndFlush(clientreq);
		String requestId= "REQ"+clientrequest.getId();
		crr.updateByReqId(requestId,clientrequest.getId());	
		ClientRequest clientrequestnew=crr.findById(clientrequest.getId());
		List<AuditorSample> list = new ArrayList<>();
		AuditorSample as= new AuditorSample();
		as.setEmail("sub.kumar001@infosys.com");
		list.add(as);
		logger.info("retrieveAllAuditor() in clientRequestService<-------end");
		return list;
	}

	@Override
	public String registerClient(ClientEntity client) {
		logger.info("registerClient() in clientRequestService----->start");
		ClientEntity req = cr.saveAndFlush(client);
		logger.info("registerClient() in clientRequestService<-------end");
		if(req==null) {
			logger.error("Client not registered Error!");
			throw new ClientNotRegisteredException("Exception while adding Client registration !");
		}
		logger.info("registerClient() in clientRequestService<-------end");
		return "Client created successfully";
	}

	@Override
	public List<ClientAuditor> getClientByReq(String emailid) {
		logger.info("getClientByReq() in clientRequestService----->start");
		//List<ClientRequest> creq = crr.findByemailId(emailid);
		List<ClientAuditor> clientauditor = carr.findbyClientId(emailid);
		if (clientauditor == null) {
			throw new ClientRequestNotFoundException("client request not found");
		} else {
			logger.info("getClientByReq() in clientRequestService<-------end");
			return clientauditor;
		}
	}

	@Override
	public String acceptOffer(String requestId) {
		logger.info("acceptOffer() in clientRequestService----->start");
		ClientRequest clientrequest=crr.findByReqId(requestId);
		Optional<ClientAuditor> clientaudreq = carr.findById(requestId);
		if(clientrequest==null) {
			throw new ClientRequestNotFoundException("client request not found");
		}
		else if(clientrequest.getStatus()==RequestStatus.PROPOSED.toString() && clientaudreq.get().getStatus()=="Proposed" ){
			crr.updateclientrequest(RequestStatus.ACCEPTED.toString(),requestId);
			carr.updateclientAuditorreq(RequestStatus.ACCEPTED.toString(),requestId);
			logger.info("acceptOffer() in clientRequestService<-------end");
			return "Status changed to Accepted";
		}
		logger.info("acceptOffer() in clientRequestService<-------end");
		return "Status changed Failed !";
	}
	
	@Override
	public String rejectOffer(String requestId) {
		logger.info("rejectOffer() in clientRequestService----->start");
		ClientRequest clientrequest=crr.findByReqId(requestId);
		Optional<ClientAuditor> clientaudreq = carr.findById(requestId);
		if(clientrequest==null) {
			throw new ClientRequestNotFoundException("client request not found");
		}
		else if(clientrequest.getStatus()==RequestStatus.PROPOSED.toString() && clientaudreq.get().getStatus()==RequestStatus.PROPOSED.toString())
			{
			crr.updateclientrequest(RequestStatus.REJECTED.toString(),requestId);
			carr.updateclientAuditorreq(RequestStatus.REJECTED.toString(),requestId);
			logger.info("rejectOffer() in clientRequestService<-------end");
			return "Status changed to Rejected";
		}
		logger.info("rejectOffer() in clientRequestService<-------end");
		return "Status changed Failed !";
	}
}
