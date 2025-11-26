package com.example.starter.controller.impl;
import com.example.starter.controller.IStudentController;
import com.example.starter.dto.DtoStudent;
import com.example.starter.dto.DtoStudentIU;
import com.example.starter.entities.Student;
import com.example.starter.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {
    @Autowired
    private IStudentService studentService;


    @PostMapping(path="/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
        return studentService.saveStudent(dtoStudentIU);
    }

    @GetMapping(path="/list")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path="/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path="/delete/{id}")
    public Student  deleteStudentById(@PathVariable("id") Long id) {
        return studentService.deleteStudentById(id);
    }
    @Override
    @PutMapping(path="/update/{id}")
    public DtoStudent updateStudentById(@PathVariable("id") Long id,@RequestBody DtoStudentIU updateStudent) {
        return studentService.updateStudent(id, updateStudent);
    }



}
