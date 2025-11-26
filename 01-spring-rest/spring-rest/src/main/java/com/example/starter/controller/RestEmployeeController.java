package com.example.starter.controller;

import com.example.starter.model.Employee;
import com.example.starter.model.UpdateEmployeeRequest;
import com.example.starter.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployeeList();
    }

    @GetMapping("/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/with-params")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName", required = false) String firstName,
                                                @RequestParam(name = "lastName", required = false) String lastName) {
        return employeeService.getEmployeeWithParams(firstName, lastName);

    }
    @PostMapping(path="/save-employee")
    public Employee saveEmployee(@RequestBody Employee newEmployee) {
        return employeeService.saveEmployee(newEmployee);
    }

    @DeleteMapping(path = "/deleteEmployee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id") String id) {
        return employeeService.deleteEmployee(id);
    }
    @PutMapping(path="update-Employee/{id}")
    public Employee updateEmployee(@PathVariable(name="id") String id,@RequestBody UpdateEmployeeRequest EmployeeRequest) {
        return employeeService.updateEmployee(id,EmployeeRequest);
    }


}
