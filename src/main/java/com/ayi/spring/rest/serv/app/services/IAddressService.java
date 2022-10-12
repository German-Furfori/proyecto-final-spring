package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.address.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.address.AddressPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.address.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.RepositoryAccessException;

public interface IAddressService {
    AddressResponseDTO addAddress(Long idClient, AddressDTO addressDTO) throws RepositoryAccessException;

    AddressPagesResponseDTO findAllAddressPages(Integer page, Integer size) throws RepositoryAccessException;

    AddressResponseDTO findAddressById(Long id) throws RepositoryAccessException;

    AddressResponseDTO modifyAddress(Long idClient, Long idAddress, AddressDTO addressDTO) throws RepositoryAccessException;

    AddressResponseDTO removeAddress(Long idClient, Long idAddress) throws RepositoryAccessException;
}
