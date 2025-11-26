package com.example.starter.services.impl;

import com.example.starter.dto.DtoDepartment;
import com.example.starter.dto.DtoEmployee;
import com.example.starter.dto.DtoStudent;
import com.example.starter.entities.Employee;
import com.example.starter.repository.EmployeeRepository;
import com.example.starter.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public List<DtoEmployee> getEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<DtoEmployee> dtoEmployeeList = new ArrayList<>();

        if (!employeeList.isEmpty() && employeeList != null)  // ⚠️ Problem here
            for (Employee e : employeeList) {
                DtoEmployee dtoEmployee = new DtoEmployee();
                BeanUtils.copyProperties(e, dtoEmployee);
                dtoEmployee.setDepartment(new DtoDepartment(
                        e.getDepartment().getId(),
                        e.getDepartment().getDepartmentName()
                ));
                dtoEmployeeList.add(dtoEmployee);

            }

        return dtoEmployeeList;
    }


}
