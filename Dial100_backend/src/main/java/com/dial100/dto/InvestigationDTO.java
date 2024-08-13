package com.dial100.dto;

import java.time.LocalDateTime;

public class InvestigationDTO {

	private Integer investigationId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String report;
	private ComplaintDTO complaint;
	
	public InvestigationDTO() {}

	public InvestigationDTO(Integer investigationId, LocalDateTime startDate, LocalDateTime endDate, String report,
			ComplaintDTO complaint) {
		super();
		this.investigationId = investigationId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.report = report;
		this.complaint = complaint;
	}

	public Integer getInvestigationId() {
		return investigationId;
	}

	public void setInvestigationId(Integer investigationId) {
		this.investigationId = investigationId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public ComplaintDTO getComplaint() {
		return complaint;
	}

	public void setComplaint(ComplaintDTO complaint) {
		this.complaint = complaint;
	}

}
