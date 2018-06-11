package com.example.virtual_campus.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity(name="subjects")
public class Subject implements Serializable {

    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int ects;

    @Column(name = "description", columnDefinition="LONGTEXT")
    private String description;

    @Column(name = "lecture_hours")
    private int lectureHours;

    @Column(name = "tutorials_hours")
    private int tutorialsHours;

    @Column(name = "project_hours")
    private int projectHours;

    @Column(name = "seminar_hours")
    private int seminarHours;

    @Column(name = "other_hours")
    private int otherHours;

    @Column(name = "course", nullable = false)
    @ManyToOne(cascade=CascadeType.ALL)
    private Course course;


}
