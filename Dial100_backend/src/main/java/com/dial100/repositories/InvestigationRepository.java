package com.dial100.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dial100.entities.Investigation;

public interface InvestigationRepository extends JpaRepository<Investigation, Integer> {
}