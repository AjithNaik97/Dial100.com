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

import com.dial100.dto.InvestigationDTO;
import com.dial100.services.InvestigationService;

@RestController
@RequestMapping("/api/investigations")
public class InvestigationController {

	@Autowired
	private InvestigationService investigationService;

	@GetMapping
	public ResponseEntity<List<InvestigationDTO>> getAllInvestigations() {
		List<InvestigationDTO> investigations = investigationService.getAllInvestigations();
		return ResponseEntity.ok(investigations);
	}

	@GetMapping("/{id}")
	public ResponseEntity<InvestigationDTO> getInvestigationById(@PathVariable Integer id) {
		InvestigationDTO investigation = investigationService.getInvestigationById(id);
		return ResponseEntity.ok(investigation);
	}

	@PostMapping
	public ResponseEntity<InvestigationDTO> createInvestigation(@RequestBody InvestigationDTO investigationDTO) {
		InvestigationDTO newInvestigation = investigationService.createInvestigation(investigationDTO);
		return ResponseEntity.ok(newInvestigation);
	}

	@PutMapping("/{id}")
	public ResponseEntity<InvestigationDTO> updateInvestigation(@PathVariable Integer id,
			@RequestBody InvestigationDTO investigationDTO) {
		InvestigationDTO updatedInvestigation = investigationService.updateInvestigation(id, investigationDTO);
		return ResponseEntity.ok(updatedInvestigation);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInvestigation(@PathVariable Integer id) {
		investigationService.deleteInvestigation(id);
		return ResponseEntity.noContent().build();
	}
}