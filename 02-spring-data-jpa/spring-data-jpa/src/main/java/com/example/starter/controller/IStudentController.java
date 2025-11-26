package com.example.starter.controller;

import com.example.starter.dto.DtoStudent;
import com.example.starter.dto.DtoStudentIU;
import com.example.starter.entities.Student;

import java.util.List;

public interface IStudentController {
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
    public List<DtoStudent> getAllStudents();
    public DtoStudent getStudentById(Long id);
    public Student deleteStudentById(Long id);
    public DtoStudent updateStudentById(Long id,DtoStudentIU updateStudent);
}
