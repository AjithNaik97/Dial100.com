package com.dial100.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dial100.dto.ComplaintDTO;
import com.dial100.services.ComplaintService;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@GetMapping
	public ResponseEntity<List<ComplaintDTO>> getAllComplaints() {
		List<ComplaintDTO> complaints = complaintService.getAllComplaints();
		return ResponseEntity.ok(complaints);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ComplaintDTO> getComplaintById(@PathVariable Integer id) {
		ComplaintDTO complaint = complaintService.getComplaintById(id);
		return ResponseEntity.ok(complaint);
	}

	@PostMapping
	public ResponseEntity<ComplaintDTO> createComplaint(@RequestBody ComplaintDTO complaintDTO) {
		ComplaintDTO newComplaint = complaintService.createComplaint(complaintDTO);
		return ResponseEntity.ok(newComplaint);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ComplaintDTO> updateComplaint(@PathVariable Integer id,
			@RequestBody ComplaintDTO complaintDTO) {
		ComplaintDTO updatedComplaint = complaintService.updateComplaint(id, complaintDTO);
		return ResponseEntity.ok(updatedComplaint);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteComplaint(@PathVariable Integer id) {
		complaintService.deleteComplaint(id);
		return ResponseEntity.noContent().build();
	}
}
