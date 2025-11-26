package com.example.starter.controller;

import com.example.starter.dto.DtoAddress;
import com.example.starter.dto.DtoStudent;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAddressController {
    public DtoAddress findStudentById(@RequestParam long id);
}
