package com.dial100.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dial100.dto.UserDTO;
import com.dial100.entities.User;
import com.dial100.exception.ResourceNotFoundException;
import com.dial100.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserById(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		return modelMapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		User savedUser = userRepository.save(user);
		return modelMapper.map(savedUser, UserDTO.class);
	}

	@Override
	public UserDTO updateUser(Integer id, UserDTO userDTO) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		modelMapper.map(userDTO, user);
		User updatedUser = userRepository.save(user);
		return modelMapper.map(updatedUser, UserDTO.class);
	}

	@Override
	public void deleteUser(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		userRepository.delete(user);
	}
}