package com.example.starter.controller.impl;

import com.example.starter.controller.IHomeController;
import com.example.starter.dto.DtoHome;
import com.example.starter.services.IHomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/home")
public class HomeControllerImpl implements IHomeController {

    private IHomeService homeService;

    @GetMapping(path="/{id}")
    @Override
    public DtoHome findHomeById(@PathVariable(name="id") Long id){
        return homeService.findHomeById(id);
    }
}
