package com.example.creditadvisordemo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.NaturalId;

@EqualsAndHashCode(of = "cognitoUsername")
@MappedSuperclass // no hierarchy in DB, only in JAVA
public abstract class User {

    @NaturalId
    @Column(nullable = false, updatable = false, unique = true)
    private String cognitoUsername;

    @Column(nullable = false, unique = true)
    private String email;

}
