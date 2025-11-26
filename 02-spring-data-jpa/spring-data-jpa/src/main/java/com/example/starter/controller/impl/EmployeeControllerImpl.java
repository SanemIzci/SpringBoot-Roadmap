package com.example.starter.controller.impl;

import com.example.starter.controller.IEmployeeController;
import com.example.starter.dto.DtoEmployee;
import com.example.starter.repository.EmployeeRepository;
import com.example.starter.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path="/restt/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping(path="/list")
    @Override
    public List<DtoEmployee> getAllEmployee() {
        return employeeService.getEmployee();
    }
}
