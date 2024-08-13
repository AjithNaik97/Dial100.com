package com.dial100.dto;

import java.util.List;

import com.dial100.entities.Role;

public class UserDTO {

	private Integer userId;
	private String name;
	private String email;
	private String phone;
	private String address;
	private Role role;
	private List<ComplaintDTO> complaints;
	private List<InvestigationDTO> investigations;
	private List<UpdatesDTO> updates;
	
	public UserDTO() {}

	public UserDTO(Integer userId, String name, String email, String phone, String address, Role role,
			List<ComplaintDTO> complaints, List<InvestigationDTO> investigations, List<UpdatesDTO> updates) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.complaints = complaints;
		this.investigations = investigations;
		this.updates = updates;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<ComplaintDTO> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<ComplaintDTO> complaints) {
		this.complaints = complaints;
	}

	public List<InvestigationDTO> getInvestigations() {
		return investigations;
	}

	public void setInvestigations(List<InvestigationDTO> investigations) {
		this.investigations = investigations;
	}

	public List<UpdatesDTO> getUpdates() {
		return updates;
	}

	public void setUpdates(List<UpdatesDTO> updates) {
		this.updates = updates;
	}

}
