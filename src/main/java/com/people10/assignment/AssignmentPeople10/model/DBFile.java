package com.people10.assignment.AssignmentPeople10.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "DBFILE")
public class DBFile implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fileId;

	private String fileName;
	private String fileType;

	@Lob
	private byte[] data;

	
	public DBFile() {
		super();
	}

	public DBFile(String fileName, String fileType, byte[] bs) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = bs;
	}

	@Override
	public String toString() {
		return "DBFile [fileId=" + fileId + ", fileName=" + fileName + ", fileType=" + fileType + ", data=" + data
				+ "]";
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
