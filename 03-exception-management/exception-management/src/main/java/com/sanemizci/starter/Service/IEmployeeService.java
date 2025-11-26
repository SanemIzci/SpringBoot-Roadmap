package com.sanemizci.starter.Service;

import com.sanemizci.starter.dto.DtoEmployee;

public interface IEmployeeService  {
    public DtoEmployee findEmployeeById(Long id);
}
