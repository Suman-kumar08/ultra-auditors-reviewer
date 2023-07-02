package com.infosys.ultra.auditors.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.ultra.auditors.model.ClientEntity;


@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
	
	@Transactional
	ClientEntity findById(int id);
	
}
