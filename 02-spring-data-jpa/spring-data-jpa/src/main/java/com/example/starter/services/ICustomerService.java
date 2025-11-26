package com.example.starter.services;


import com.example.starter.dto.DtoCustomer;
import org.springframework.stereotype.Service;


public interface ICustomerService {

    public DtoCustomer findCustomerById(Long id);
}
