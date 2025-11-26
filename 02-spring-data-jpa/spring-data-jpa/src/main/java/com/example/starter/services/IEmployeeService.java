package com.example.starter.services;

import com.example.starter.dto.DtoEmployee;
import com.example.starter.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<DtoEmployee> getEmployee();
}
