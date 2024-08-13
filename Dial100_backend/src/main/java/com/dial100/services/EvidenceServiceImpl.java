package com.dial100.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dial100.dto.EvidenceDTO;
import com.dial100.entities.Evidence;
import com.dial100.exception.ResourceNotFoundException;
import com.dial100.repositories.EvidenceRepository;

@Service
public class EvidenceServiceImpl implements EvidenceService {

	@Autowired
	private EvidenceRepository evidenceRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<EvidenceDTO> getAllEvidences() {
		List<Evidence> evidences = evidenceRepository.findAll();
		return evidences.stream().map(evidence -> modelMapper.map(evidence, EvidenceDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public EvidenceDTO getEvidenceById(Integer id) {
		Evidence evidence = evidenceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Evidence not found"));
		return modelMapper.map(evidence, EvidenceDTO.class);
	}

	@Override
	public EvidenceDTO createEvidence(EvidenceDTO evidenceDTO) {
		Evidence evidence = modelMapper.map(evidenceDTO, Evidence.class);
		Evidence savedEvidence = evidenceRepository.save(evidence);
		return modelMapper.map(savedEvidence, EvidenceDTO.class);
	}

	@Override
	public EvidenceDTO updateEvidence(Integer id, EvidenceDTO evidenceDTO) {
		Evidence evidence = evidenceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Evidence not found"));
		modelMapper.map(evidenceDTO, evidence);
		Evidence updatedEvidence = evidenceRepository.save(evidence);
		return modelMapper.map(updatedEvidence, EvidenceDTO.class);
	}

	@Override
	public void deleteEvidence(Integer id) {
		Evidence evidence = evidenceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Evidence not found"));
		evidenceRepository.delete(evidence);
	}
}
