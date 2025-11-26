package com.example.starter.controller;

import com.example.starter.dto.DtoCustomer;

public interface ICustomerController {
    public DtoCustomer findCustomerById(Long id);
}
