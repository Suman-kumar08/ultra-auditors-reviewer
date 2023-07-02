package com.infosys.ultra.auditors.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infosys.ultra.auditors.model.ClientRequest;

@Transactional
public interface ClientRequestRepository extends JpaRepository<ClientRequest,Integer> {

	@Modifying
	ClientRequest findById(int reqid);
	
	@Modifying
	@Query("select c from ClientRequest c where c.emailId=?1")
	List<ClientRequest> findByemailId(String emailid);

	
	@Modifying
	@Transactional
	@Query(value="update ClientRequest c set c.status=?1 where c.reqId=?2")
	void updateclientrequest(String status,String reqid);
	
	@Modifying
	@Transactional
	@Query(value="select c from ClientRequest c where c.reqId=?1 ")
	ClientRequest findByReqId(String requestId);

	@Modifying
	@Transactional
	@Query(value="update ClientRequest c set c.reqId=?1 where c.id=?2")
	void updateByReqId(String requestId, int id);

	

	

	
}
