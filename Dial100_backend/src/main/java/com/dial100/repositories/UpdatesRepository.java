package com.dial100.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dial100.entities.Updates;

public interface UpdatesRepository extends JpaRepository<Updates, Integer> {
	
	List<Updates> findByComplaint_ComplaintId(Integer complaintId);
}