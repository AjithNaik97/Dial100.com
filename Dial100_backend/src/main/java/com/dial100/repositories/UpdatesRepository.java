package com.dial100.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dial100.entities.Updates;

public interface UpdatesRepository extends JpaRepository<Updates, Integer> {
}