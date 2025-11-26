package com.example.starter.controller.impl;

import com.example.starter.controller.IAddressController;
import com.example.starter.dto.DtoAddress;
import com.example.starter.dto.DtoStudent;
import com.example.starter.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/adress")
public class AddressControllerImpl implements IAddressController {
    @Autowired
    public IAddressService AddressService;

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoAddress findStudentById(@PathVariable(name="id") long id) {
        return AddressService.findAdressById(id);
    }
}
