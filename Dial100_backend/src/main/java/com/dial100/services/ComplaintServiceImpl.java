package com.dial100.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dial100.dto.ComplaintDTO;
import com.dial100.entities.Complaint;
import com.dial100.entities.Crime; // Import the Crime entity
import com.dial100.entities.User;
import com.dial100.exception.ResourceNotFoundException;
import com.dial100.repositories.ComplaintRepository;
import com.dial100.repositories.CrimeRepository; // Import CrimeRepository
import com.dial100.repositories.UserRepository;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CrimeRepository crimeRepository; // Add CrimeRepository

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
        // Fetch User entity from userId
        User user = userRepository.findById(complaintDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Fetch Crime entity from crimeId
        Crime crime = crimeRepository.findById(complaintDTO.getCrimeId())
                .orElseThrow(() -> new ResourceNotFoundException("Crime not found"));

        // Map DTO to entity
        Complaint complaint = modelMapper.map(complaintDTO, Complaint.class);
        // Set the user and crime entities
        complaint.setUser(user);
        complaint.setCrime(crime);

        // Save the complaint
        Complaint savedComplaint = complaintRepository.save(complaint);
        return modelMapper.map(savedComplaint, ComplaintDTO.class);
    }

    @Override
    public ComplaintDTO updateComplaint(Integer id, ComplaintDTO complaintDTO) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint not found"));

        // Update entities as necessary
        modelMapper.map(complaintDTO, complaint);
        
        // Fetch and set Crime entity if it was updated
        if (complaintDTO.getCrimeId() != null) {
            Crime crime = crimeRepository.findById(complaintDTO.getCrimeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Crime not found"));
            complaint.setCrime(crime);
        }
        
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
