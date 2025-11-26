package com.example.starter.services.impl;

import com.example.starter.dto.DtoAddress;
import com.example.starter.dto.DtoCustomer;
import com.example.starter.entities.Address;
import com.example.starter.entities.Customer;
import com.example.starter.repository.CustomerRepository;
import com.example.starter.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        Customer customer = optional.get();
        Address address = optional.get().getAddress();
        BeanUtils.copyProperties(customer, dtoCustomer);
        DtoAddress dtoAddress = new DtoAddress();
        BeanUtils.copyProperties(address, dtoAddress);
        dtoCustomer.setAdress(dtoAddress);
        return dtoCustomer;
    }

    ;

}
