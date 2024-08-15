package com.dial100.dto;

import java.time.LocalDate;
import java.util.List;

public class ComplaintDTO {
    private Integer complaintId;
    private String description;
    private LocalDate dateFiled; // Changed from LocalDateTime to LocalDate
    private String status;
    private Integer userId; // Add userId
    private Integer crimeId; // Add crimeId
    private List<EvidenceDTO> evidenceList;
    private List<UpdatesDTO> updates;

    public ComplaintDTO() {}

    public ComplaintDTO(Integer complaintId, String description, LocalDate dateFiled, String status,
                        Integer userId, Integer crimeId, List<EvidenceDTO> evidenceList, List<UpdatesDTO> updates) {
        super();
        this.complaintId = complaintId;
        this.description = description;
        this.dateFiled = dateFiled; // Initialize dateFiled
        this.status = status;
        this.userId = userId; // Initialize userId
        this.crimeId = crimeId; // Initialize crimeId
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

    public LocalDate getDateFiled() {
        return dateFiled;
    }

    public void setDateFiled(LocalDate dateFiled) {
        this.dateFiled = dateFiled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(Integer crimeId) {
        this.crimeId = crimeId;
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
