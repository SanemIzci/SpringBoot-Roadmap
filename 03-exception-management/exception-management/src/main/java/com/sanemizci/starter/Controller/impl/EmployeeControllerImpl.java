package com.sanemizci.starter.Controller.impl;

import com.sanemizci.starter.Controller.IEmployeeController;
import com.sanemizci.starter.Model.RootEntity;
import com.sanemizci.starter.Service.IEmployeeService;
import com.sanemizci.starter.dto.DtoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/rest/api/employee")
public class EmployeeControllerImpl extends RestBaseController  implements IEmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(path="/list/{id}")
    @Override

    public RootEntity<DtoEmployee> findEmployeeById(@PathVariable(name="id")Long id) {
        return ok(employeeService.findEmployeeById(id));
    }


}
