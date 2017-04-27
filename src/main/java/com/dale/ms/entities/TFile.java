package com.dale.ms.entities;

import java.sql.Timestamp;

/**
 * TFile entity. @author MyEclipse Persistence Tools
 */

public class TFile implements java.io.Serializable {

	// Fields

	private Long fileId;
	private String fileName;
	private String fileType;
	private String fileRemark;
	private Timestamp createTime;
	private String downloadUrl;

	// Constructors

	/** default constructor */
	public TFile() {
	}

	/** full constructor */
	public TFile(String fileName, String fileType, String fileRemark,
			Timestamp createTime, String downloadUrl) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileRemark = fileRemark;
		this.createTime = createTime;
		this.downloadUrl = downloadUrl;
	}

	// Property accessors

	public Long getFileId() {
		return this.fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileRemark() {
		return this.fileRemark;
	}

	public void setFileRemark(String fileRemark) {
		this.fileRemark = fileRemark;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getDownloadUrl() {
		return this.downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

}