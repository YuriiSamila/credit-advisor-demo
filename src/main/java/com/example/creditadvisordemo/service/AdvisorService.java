package com.example.creditadvisordemo.service;

import com.example.creditadvisordemo.domain.Advisor;
import com.example.creditadvisordemo.domain.Application;
import com.example.creditadvisordemo.domain.Application.Status;
import com.example.creditadvisordemo.repository.AdvisorRepository;
import com.example.creditadvisordemo.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.creditadvisordemo.domain.Application.Status.NEW;

@Service

public class AdvisorService {

    private final AdvisorRepository advisorRepository;
    private final ApplicationRepository applicationRepository;

    public AdvisorService(AdvisorRepository advisorRepository, ApplicationRepository applicationRepository) {
        this.advisorRepository = advisorRepository;
        this.applicationRepository = applicationRepository;
    }

    @Transactional
    public Application assignMewApplicationByAdvisorId(Long advisorId) {
        Advisor advisor = advisorRepository.findById(advisorId).orElseThrow();
        Application application = applicationRepository.findFirstByStatusOrderByCreatedAt(NEW);
        application.assignTo(advisor);
        return application;
    }

}
