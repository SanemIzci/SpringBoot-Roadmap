package com.example.starter.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "student", schema = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name",nullable=false,length=40)
    private String firstName;

    @Column(name="last_name",nullable=false)
    private String lastName;

    @Column(name="date_of_birth",nullable=true)
    private LocalDate dateOfBirth;
}
