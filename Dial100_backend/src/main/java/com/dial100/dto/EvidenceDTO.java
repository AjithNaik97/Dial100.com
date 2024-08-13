package com.dial100.dto;

import java.time.LocalDateTime;

import com.dial100.entities.EvidenceType;

public class EvidenceDTO {

	private Integer evidenceId;
	private EvidenceType evidenceType;
	private String filePath;
	private LocalDateTime uploadDate;
	
	public EvidenceDTO() {}

	public EvidenceDTO(Integer evidenceId, EvidenceType evidenceType, String filePath, LocalDateTime uploadDate) {
		super();
		this.evidenceId = evidenceId;
		this.evidenceType = evidenceType;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
	}

	public Integer getEvidenceId() {
		return evidenceId;
	}

	public void setEvidenceId(Integer evidenceId) {
		this.evidenceId = evidenceId;
	}

	public EvidenceType getEvidenceType() {
		return evidenceType;
	}

	public void setEvidenceType(EvidenceType evidenceType) {
		this.evidenceType = evidenceType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public LocalDateTime getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(LocalDateTime uploadDate) {
		this.uploadDate = uploadDate;
	}

}
