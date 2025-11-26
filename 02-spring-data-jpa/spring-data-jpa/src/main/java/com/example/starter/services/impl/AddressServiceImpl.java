package com.example.starter.services.impl;

import com.example.starter.dto.DtoAddress;
import com.example.starter.dto.DtoCustomer;
import com.example.starter.entities.Address;
import com.example.starter.repository.AddressRepository;
import com.example.starter.services.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DtoAddress findAdressById(Long id) {
        DtoAddress dtoAddress = new DtoAddress();
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isPresent()) {
            return null;
        }
        Address address = optional.get();
        BeanUtils.copyProperties(address, dtoAddress);

        DtoCustomer dtoCustomer = new DtoCustomer();
        dtoCustomer.setId(address.getCustomer().getId());
        dtoCustomer.setName(address.getCustomer().getName());



        dtoAddress.setCustomer(dtoCustomer);
        return dtoAddress;

    }


}
