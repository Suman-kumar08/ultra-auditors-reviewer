package com.infosys.ultra.auditors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.ultra.auditors.model.DocumentFile;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentFile,String>{

}
