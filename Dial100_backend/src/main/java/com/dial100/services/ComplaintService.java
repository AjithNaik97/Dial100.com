package com.dial100.services;

import java.util.List;

import com.dial100.dto.ComplaintDTO;

public interface ComplaintService {
	List<ComplaintDTO> getAllComplaints();

	ComplaintDTO getComplaintById(Integer id);

	ComplaintDTO createComplaint(ComplaintDTO complaintDTO);

	ComplaintDTO updateComplaint(Integer id, ComplaintDTO complaintDTO);

	void deleteComplaint(Integer id);
}
