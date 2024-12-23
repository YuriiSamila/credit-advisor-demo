package com.example.creditadvisordemo.repository;

import com.example.creditadvisordemo.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application findFirstByStatusOrderByCreatedAt(Application.Status status);

}
