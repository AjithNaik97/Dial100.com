package com.dial100.dto;

import java.time.LocalDateTime;

import com.dial100.entities.Status;

public class UpdatesDTO {

	private Integer updateId;
	private LocalDateTime updateDate;
	private Status status;
	private String remarks;
	
	public UpdatesDTO() {}

	public UpdatesDTO(Integer updateId, LocalDateTime updateDate, Status status, String remarks) {
		super();
		this.updateId = updateId;
		this.updateDate = updateDate;
		this.status = status;
		this.remarks = remarks;
	}

	public Integer getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
