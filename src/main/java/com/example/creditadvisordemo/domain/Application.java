package com.example.creditadvisordemo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.example.creditadvisordemo.domain.Application.Status.ASSIGNED;
import static java.time.LocalDateTime.now;

@Setter
@Getter
@Entity
@Table(name = "applications", indexes = {
        @Index(name = "applications_applicant_id_idx", columnList = "applicant_id"),
        @Index(name = "application_advisor_id_idx", columnList = "advisor_id")})
public class Application {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private BigDecimal amountUsd;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private LocalDateTime createdAt = now();

    private LocalDateTime assignedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    public void assignTo(Advisor advisor) {
        verifyIsNotAssigned();
        this.advisor = advisor;
        status = ASSIGNED;
        assignedAt = now();
    }

    private void verifyIsNotAssigned() {
        if (advisor != null) {
            throw new IllegalStateException("Application is already assigned");
        }

    }

    public enum Status {
        NEW, ASSIGNED, APPROVED, CANCELED, DECLINED
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return this.id != null && this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
