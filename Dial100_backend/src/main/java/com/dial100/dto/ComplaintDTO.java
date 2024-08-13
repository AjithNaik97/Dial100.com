package com.dial100.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ComplaintDTO {
	private Integer complaintId;
    private String description;
    private LocalDateTime dateFiled;
    private String status;
    private List<EvidenceDTO> evidenceList;
    private List<UpdatesDTO> updates;
    
    public ComplaintDTO() {}

	public ComplaintDTO(Integer complaintId, String description, LocalDateTime dateFiled, String status,
			List<EvidenceDTO> evidenceList, List<UpdatesDTO> updates) {
		super();
		this.complaintId = complaintId;
		this.description = description;
		this.dateFiled = dateFiled;
		this.status = status;
		this.evidenceList = evidenceList;
		this.updates = updates;
	}

	public Integer getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateFiled() {
		return dateFiled;
	}

	public void setDateFiled(LocalDateTime dateFiled) {
		this.dateFiled = dateFiled;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<EvidenceDTO> getEvidenceList() {
		return evidenceList;
	}

	public void setEvidenceList(List<EvidenceDTO> evidenceList) {
		this.evidenceList = evidenceList;
	}

	public List<UpdatesDTO> getUpdates() {
		return updates;
	}

	public void setUpdates(List<UpdatesDTO> updates) {
		this.updates = updates;
	}

}
