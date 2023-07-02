package com.infosys.ultra.auditors.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="document_db")
public class DocumentFile {
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
	@Column(unique=true)
	private String reqid;
    private String fileName;

    private String fileType;
    @Lob
    private byte[] data;

    public DocumentFile() {

    }

    public DocumentFile(String fileName,String reqid ,String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.reqid=reqid;
    }

}
