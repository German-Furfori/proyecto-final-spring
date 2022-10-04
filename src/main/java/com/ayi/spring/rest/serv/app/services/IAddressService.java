package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;

import java.util.List;

public interface IAddressService {
    List<AddressResponseDTO> findAllAddresses() throws ReadAccessException;

    AddressResponseDTO findAddressById(Long id) throws ReadAccessException;

    AddressResponseDTO addAddress(AddressDTO addressDTO) throws WriteAccessException;

    AddressResponseDTO removeAddressById(Long id) throws WriteAccessException;

    AddressResponseDTO modifyAddress(Long id, AddressDTO addressDTO) throws WriteAccessException;
}
