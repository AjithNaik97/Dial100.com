package com.dial100.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dial100.entities.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
}
