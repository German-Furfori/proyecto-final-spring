package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;
import com.ayi.spring.rest.serv.app.mappers.IAddressMapper;
import com.ayi.spring.rest.serv.app.repositories.IAddressRepository;
import com.ayi.spring.rest.serv.app.services.IAddressService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {

    @Autowired
    IAddressRepository addressRepository;

    @Autowired
    IAddressMapper addressMapper;

    @Override
    public List<AddressResponseDTO> findAllAddresses() throws ReadAccessException {
        return null;
    }

    @Override
    public AddressResponseDTO findAddressById(Long id) throws ReadAccessException {
        return null;
    }

    @Override
    public AddressResponseDTO addAddress(AddressDTO addressDTO) throws WriteAccessException {
        return null;
    }

    @Override
    public AddressResponseDTO removeAddressById(Long id) throws WriteAccessException {
        return null;
    }

    @Override
    public AddressResponseDTO modifyAddress(Long id, AddressDTO addressDTO) throws WriteAccessException {
        return null;
    }

}
