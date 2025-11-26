package com.sanemizci.starter.Controller;

import com.sanemizci.starter.Model.RootEntity;
import com.sanemizci.starter.dto.DtoEmployee;

public interface IEmployeeController {
    public RootEntity<DtoEmployee> findEmployeeById(Long id);
}
