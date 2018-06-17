package com.example.virtual_campus.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "roll_number", unique = true, nullable = false)
    private int rollNumber;

    @Column(name= "activation_code", unique = true)
    private String activationCode;

    private boolean isActive = false;

    @OneToOne
    private User user;

}
