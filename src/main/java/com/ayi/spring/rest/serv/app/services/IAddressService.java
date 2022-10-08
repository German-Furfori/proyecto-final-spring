package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.address.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.address.AddressPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.address.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.GenericAccessException;

import java.util.List;

public interface IAddressService {
    AddressResponseDTO addAddress(Long idClient, AddressDTO addressDTO) throws GenericAccessException;

    AddressPagesResponseDTO findAllAddressPages(Integer page, Integer size) throws GenericAccessException;

    AddressResponseDTO findAddressById(Long id) throws GenericAccessException;

    AddressResponseDTO modifyAddress(Long idClient, Long idAddress, AddressDTO addressDTO) throws GenericAccessException;

    AddressResponseDTO removeAddress(Long idClient, Long idAddress) throws GenericAccessException;
}
