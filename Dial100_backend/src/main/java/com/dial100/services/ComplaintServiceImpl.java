package com.dial100.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dial100.dto.ComplaintDTO;
import com.dial100.entities.Complaint;
import com.dial100.exception.ResourceNotFoundException;
import com.dial100.repositories.ComplaintRepository;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ComplaintDTO> getAllComplaints() {
		List<Complaint> complaints = complaintRepository.findAll();
		return complaints.stream().map(complaint -> modelMapper.map(complaint, ComplaintDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ComplaintDTO getComplaintById(Integer id) {
		Complaint complaint = complaintRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));
		return modelMapper.map(complaint, ComplaintDTO.class);
	}

	@Override
	public ComplaintDTO createComplaint(ComplaintDTO complaintDTO) {
		Complaint complaint = modelMapper.map(complaintDTO, Complaint.class);
		Complaint savedComplaint = complaintRepository.save(complaint);
		return modelMapper.map(savedComplaint, ComplaintDTO.class);
	}

	@Override
	public ComplaintDTO updateComplaint(Integer id, ComplaintDTO complaintDTO) {
		Complaint complaint = complaintRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));
		modelMapper.map(complaintDTO, complaint);
		Complaint updatedComplaint = complaintRepository.save(complaint);
		return modelMapper.map(updatedComplaint, ComplaintDTO.class);
	}

	@Override
	public void deleteComplaint(Integer id) {
		Complaint complaint = complaintRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));
		complaintRepository.delete(complaint);
	}
}
