package com.infosys.ultra.auditors.service;

import org.springframework.web.multipart.MultipartFile;

import com.infosys.ultra.auditors.exception.FileStorageException;
import com.infosys.ultra.auditors.model.DocumentFile;

public interface DocumentStorageService {
	DocumentFile storeFile(MultipartFile file,String reqId) throws FileStorageException;
	DocumentFile getFile(String fileId) throws FileStorageException;

}
