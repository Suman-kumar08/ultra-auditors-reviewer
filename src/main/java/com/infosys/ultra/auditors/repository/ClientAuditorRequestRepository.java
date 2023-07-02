package com.infosys.ultra.auditors.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.ultra.auditors.model.ClientAuditor;



@Repository
public interface ClientAuditorRequestRepository extends JpaRepository<ClientAuditor,String>{
	
	@Modifying
	Optional<ClientAuditor> findById(String req_id);
	
	@Modifying
	@Transactional
	@Query("update ClientAuditor ca set ca.status=?1 where ca.req_id=?2 ")
	void updateclientAuditorreq(String status, String requestId);

	@Modifying
	@Transactional
	@Query("select ca from ClientAuditor ca where ca.clientId=?1 ")
	List<ClientAuditor> findbyClientId(String emailid);


}
