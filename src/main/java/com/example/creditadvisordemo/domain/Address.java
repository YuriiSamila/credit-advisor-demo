package com.example.creditadvisordemo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

// it's a value object (not entity)
@Embeddable
public class Address {

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String number;

    private String apt;

    @Column(nullable = false)
    private String zip;

}
