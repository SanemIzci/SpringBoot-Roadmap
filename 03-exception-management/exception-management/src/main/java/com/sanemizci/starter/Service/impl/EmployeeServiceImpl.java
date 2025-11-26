package com.sanemizci.starter.Service.impl;

import com.sanemizci.starter.Model.Department;
import com.sanemizci.starter.Model.Employee;
import com.sanemizci.starter.Repository.EmployeeRepository;
import com.sanemizci.starter.Service.IEmployeeService;
import com.sanemizci.starter.dto.DtoDepartment;
import com.sanemizci.starter.dto.DtoEmployee;
import com.sanemizci.starter.exception.BaseException;
import com.sanemizci.starter.exception.ErrorMessage;
import com.sanemizci.starter.exception.MessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee findEmployeeById(Long id) {
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();
        Optional<Employee> optional = employeeRepository.findById(id);

        if (optional.isEmpty()) {
            ErrorMessage errorMessage = new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString());
            throw new BaseException(errorMessage);
        }

        Employee employee = optional.get();
        Department department = employee.getDepartment();
        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department, dtoDepartment);

        dtoEmployee.setDepartment(dtoDepartment);
        return dtoEmployee;
    }
}
