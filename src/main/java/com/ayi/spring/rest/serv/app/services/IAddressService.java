package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.GenericException;

import java.util.List;

public interface IAddressService {
    AddressResponseDTO addAddress(Long idClient, AddressDTO addressDTO) throws GenericException;

    List<AddressResponseDTO> findAllAddresses() throws GenericException;

    AddressResponseDTO findAddressById(Long id) throws GenericException;

    AddressResponseDTO modifyAddress(Long idClient, Long idAddress, AddressDTO addressDTO) throws GenericException;

    AddressResponseDTO removeAddress(Long idClient, Long idAddress) throws GenericException;
}
