package com.example.starter.services;

import com.example.starter.dto.DtoStudent;
import com.example.starter.dto.DtoStudentIU;
import com.example.starter.entities.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU student);
    public List<DtoStudent> getAllStudents();
    public DtoStudent getStudentById(Long id);
    public Student deleteStudentById(Long id);
    public DtoStudent updateStudent(Long id,DtoStudentIU dtoStudentIU);
}
