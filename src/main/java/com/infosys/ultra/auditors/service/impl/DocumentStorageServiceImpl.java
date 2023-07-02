package com.infosys.ultra.auditors.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.infosys.ultra.auditors.exception.FileStorageException;
import com.infosys.ultra.auditors.model.DocumentFile;
import com.infosys.ultra.auditors.repository.DocumentRepository;
import com.infosys.ultra.auditors.service.DocumentStorageService;

@Service
public class DocumentStorageServiceImpl implements DocumentStorageService{
	@Autowired
	DocumentRepository docrepo;

	private static final Logger logger = LoggerFactory.getLogger(DocumentStorageServiceImpl.class);

	public DocumentFile storeFile(MultipartFile file,String reqId) throws FileStorageException {
		//status==Upload Documents based on reqId
		logger.info("storeFile()----->start");
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
     
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DocumentFile dbFile = new DocumentFile(fileName,reqId,file.getContentType(), file.getBytes());
    		logger.info("storeFile()<-----end");

            return docrepo.save(dbFile);
        } catch (IOException ex) {
    		logger.error("error in storeFile()");

            throw new FileStorageException("Could not store file " + fileName + ". Please try again!");
        }
	}
	
    public DocumentFile getFile(String fileId) throws FileStorageException {
		logger.info("getFile()----->start");

    	return docrepo.findById(fileId).orElseThrow(() -> new FileStorageException("File not found with id " + fileId));
    }

}
