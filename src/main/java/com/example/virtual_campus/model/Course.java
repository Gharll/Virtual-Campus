package com.example.virtual_campus.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;


@Data
@Entity(name="courses")
public class Course {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "faculty", nullable = false)
    @ManyToOne(cascade=CascadeType.ALL)
    private Faculty faculty;


    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_subjects", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;

    */
}
