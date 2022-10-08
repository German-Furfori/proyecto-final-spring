package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;

import java.util.List;

public interface IAddressService {
    AddressResponseDTO addAddress(Long idClient, AddressDTO addressDTO) throws ReadAccessException;

    List<AddressResponseDTO> findAllAddresses() throws ReadAccessException;

    AddressResponseDTO findAddressById(Long id) throws ReadAccessException;

    AddressResponseDTO modifyAddress(Long idClient, Long idAddress, AddressDTO addressDTO) throws ReadAccessException;

    AddressResponseDTO removeAddress(Long idClient, Long idAddress) throws ReadAccessException;
}
