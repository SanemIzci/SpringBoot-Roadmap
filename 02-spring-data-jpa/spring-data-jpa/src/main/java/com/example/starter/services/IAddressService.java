package com.example.starter.services;

import com.example.starter.dto.DtoAddress;

public interface IAddressService {
    public DtoAddress findAdressById(Long id);
}
