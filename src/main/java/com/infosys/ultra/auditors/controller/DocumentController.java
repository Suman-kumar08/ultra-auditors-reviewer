package com.infosys.ultra.auditors.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.infosys.ultra.auditors.dto.UploadFileResponse;
import com.infosys.ultra.auditors.exception.FileStorageException;
import com.infosys.ultra.auditors.model.DocumentFile;
import com.infosys.ultra.auditors.service.impl.ClientServiceImpl;
import com.infosys.ultra.auditors.service.impl.DocumentStorageServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Validated
@RequestMapping("/v1/api")
public class DocumentController {
	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    private DocumentStorageServiceImpl docstorageservice;

    @PostMapping("/client/upload/documents/{reqid}")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,@PathVariable String reqid ) throws FileStorageException {
         DocumentFile doc = docstorageservice.storeFile(file,reqid);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(doc.getId())
                .toUriString();

        return new UploadFileResponse(doc.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }
    
    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws FileStorageException {
        // Load file from database
        DocumentFile dbFile = docstorageservice.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }


}
