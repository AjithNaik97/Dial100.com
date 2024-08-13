package com.dial100.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dial100.dto.UpdatesDTO;
import com.dial100.entities.Updates;
import com.dial100.exception.ResourceNotFoundException;
import com.dial100.repositories.UpdatesRepository;

@Service
public class UpdatesServiceImpl implements UpdatesService {

	@Autowired
	private UpdatesRepository updatesRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<UpdatesDTO> getAllUpdates() {
		List<Updates> updates = updatesRepository.findAll();
		return updates.stream().map(update -> modelMapper.map(update, UpdatesDTO.class)).collect(Collectors.toList());
	}

	@Override
	public UpdatesDTO getUpdateById(Integer id) {
		Updates update = updatesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Update not found"));
		return modelMapper.map(update, UpdatesDTO.class);
	}

	@Override
	public UpdatesDTO createUpdate(UpdatesDTO updatesDTO) {
		Updates update = modelMapper.map(updatesDTO, Updates.class);
		Updates savedUpdate = updatesRepository.save(update);
		return modelMapper.map(savedUpdate, UpdatesDTO.class);
	}

	@Override
	public UpdatesDTO updateUpdate(Integer id, UpdatesDTO updatesDTO) {
		Updates update = updatesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Update not found"));
		modelMapper.map(updatesDTO, update);
		Updates updatedUpdate = updatesRepository.save(update);
		return modelMapper.map(updatedUpdate, UpdatesDTO.class);
	}

	@Override
	public void deleteUpdate(Integer id) {
		Updates update = updatesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Update not found"));
		updatesRepository.delete(update);
	}
}
