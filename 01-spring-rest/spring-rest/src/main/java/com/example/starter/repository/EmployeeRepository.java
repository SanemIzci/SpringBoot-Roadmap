package com.example.starter.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.starter.model.Employee;
import com.example.starter.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList() {
        return employeeList;
    }

    public Employee getEmployeeById(String id) {
        Employee findEmployee = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeWithParams = new ArrayList<>();
        if (firstName == null && lastName == null) {
            return employeeList;
        }
        for (Employee employee : employeeList) {
            if (firstName != null && lastName != null) {

                if (employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            } else if (firstName != null) {

                if (employee.getFirstName().equalsIgnoreCase(firstName)) {
                    employeeWithParams.add(employee);
                }
            } else {

                if (employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            }
        }
        return employeeWithParams;
    }

    public Employee saveEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(String id) {
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                employeeList.remove(employee);
            }
        }
        return true;
    }

    private Employee findEmployeeById(String id) {
        Employee findEmployee = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;

    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest employeeRequest) {
        Employee employeeToUpdate = findEmployeeById(id);
        if (employeeToUpdate != null) {

            employeeToUpdate.setFirstName(employeeRequest.getFirstName());
            employeeToUpdate.setLastName(employeeRequest.getLastName());
        }
        return employeeToUpdate;
    }


}
