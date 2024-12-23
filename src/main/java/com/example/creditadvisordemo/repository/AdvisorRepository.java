package com.example.creditadvisordemo.repository;

import com.example.creditadvisordemo.domain.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
}
