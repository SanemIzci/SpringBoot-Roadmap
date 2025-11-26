package com.example.starter.services.impl;

import com.example.starter.dto.DtoStudent;
import com.example.starter.dto.DtoStudentIU;
import com.example.starter.entities.Student;
import com.example.starter.repository.StudentRepository;
import com.example.starter.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        DtoStudent response = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent=studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }
    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoList = new ArrayList<>();
        List <Student> studentList = studentRepository.findAllStudents();
        for (Student student : studentList) {
            DtoStudent dto=new DtoStudent();
            BeanUtils.copyProperties(student,dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public DtoStudent getStudentById(Long id) {
        DtoStudent response = new DtoStudent();
        Optional<Student> studentOptional=studentRepository.findStudentById(id);
        studentOptional.ifPresent(dbStudent -> BeanUtils.copyProperties(dbStudent, response));
        return response;
    }

    @Override
    public Student deleteStudentById(Long id) {
        Optional<Student> studentOptional=studentRepository.findById(id);
        if(studentOptional.isPresent()){
            studentRepository.deleteById(id);
        }
        return null;
    }

    @Override
    public DtoStudent updateStudent(Long id, DtoStudentIU updateStudent) {
        DtoStudent dto = new DtoStudent();
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setFirstName(updateStudent.getFirstName());
            student.setLastName(updateStudent.getLastName());
            student.setDateOfBirth(updateStudent.getDateOfBirth());

            Student updatedStudent = studentRepository.save(student);
            BeanUtils.copyProperties(updatedStudent, dto);
            return dto;
        }
        return null;
    }

}
