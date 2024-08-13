package com.dial100.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dial100.entities.Evidence;

public interface EvidenceRepository extends JpaRepository<Evidence, Integer> {
}
