package com.example.virtual_campus.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class UniversityRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name= "activation_code", unique = true)
    private String activationCode;

    private boolean isActive = false;

    protected String role;

    @OneToOne
    private User user;
}
