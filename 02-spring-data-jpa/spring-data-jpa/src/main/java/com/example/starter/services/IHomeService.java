package com.example.starter.services;

import com.example.starter.dto.DtoHome;

public interface IHomeService {
    public DtoHome findHomeById(Long id);
}
