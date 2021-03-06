package com.example.virtual_campus.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "studentId", referencedColumnName = "id")
public class Student extends UniversityRole {

    /*@Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    public Student(){
        setRole("STUDENT");
    }

    @Column(name = "roll_number", unique = true, nullable = false)
    private int rollNumber;

    @OneToOne
    private Course course;


}
