package com.example.creditadvisordemo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "advisors")
public class Advisor {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "advisor")
    private List<Application> applications = new ArrayList<>();

    public void  assignApplication(Application application) {
        application.assignTo(this);
        applications.add(application);
    }

    enum Role{
        ASSOCIATE,PARTNER, LEAD
    }

}
