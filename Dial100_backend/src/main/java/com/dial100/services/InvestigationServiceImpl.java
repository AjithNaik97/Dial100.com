package com.dial100.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dial100.dto.InvestigationDTO;
import com.dial100.entities.Investigation;
import com.dial100.exception.ResourceNotFoundException;
import com.dial100.repositories.InvestigationRepository;

@Service
public class InvestigationServiceImpl implements InvestigationService {

	@Autowired
	private InvestigationRepository investigationRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<InvestigationDTO> getAllInvestigations() {
		List<Investigation> investigations = investigationRepository.findAll();
		return investigations.stream().map(investigation -> modelMapper.map(investigation, InvestigationDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public InvestigationDTO getInvestigationById(Integer id) {
		Investigation investigation = investigationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Investigation not found"));
		return modelMapper.map(investigation, InvestigationDTO.class);
	}

	@Override
	public InvestigationDTO createInvestigation(InvestigationDTO investigationDTO) {
		Investigation investigation = modelMapper.map(investigationDTO, Investigation.class);
		Investigation savedInvestigation = investigationRepository.save(investigation);
		return modelMapper.map(savedInvestigation, InvestigationDTO.class);
	}

	@Override
	public InvestigationDTO updateInvestigation(Integer id, InvestigationDTO investigationDTO) {
		Investigation investigation = investigationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Investigation not found"));
		modelMapper.map(investigationDTO, investigation);
		Investigation updatedInvestigation = investigationRepository.save(investigation);
		return modelMapper.map(updatedInvestigation, InvestigationDTO.class);
	}

	@Override
	public void deleteInvestigation(Integer id) {
		Investigation investigation = investigationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Investigation not found"));
		investigationRepository.delete(investigation);
	}
}
