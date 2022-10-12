package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.address.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.address.AddressPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.address.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.entities.AddressEntity;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.exceptions.RepositoryAccessException;
import com.ayi.spring.rest.serv.app.mappers.IAddressMapper;
import com.ayi.spring.rest.serv.app.repositories.IAddressRepository;
import com.ayi.spring.rest.serv.app.repositories.IClientRepository;
import com.ayi.spring.rest.serv.app.services.IAddressService;
import com.ayi.spring.rest.serv.app.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ayi.spring.rest.serv.app.constants.ExceptionStrings.READ_ACCESS_EXCEPTION_NOT_FOUND;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {

    @Autowired
    IAddressRepository addressRepository;

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    IAddressMapper addressMapper;

    Utils utils;

    @Override
    public AddressResponseDTO addAddress(Long idClient, AddressDTO addressDTO) throws RepositoryAccessException {

        utils.verifyClientId(idClient);

        AddressEntity addressEntity = addressMapper.dtoToEntity(addressDTO);
        ClientEntity clientEntity = clientRepository.findById(idClient).get();
        addressEntity.setClient(clientEntity);

        addressRepository.save(addressEntity);

        return addressMapper.entityToDto(addressEntity);

    }

    @Override
    public AddressPagesResponseDTO findAllAddressPages(Integer page, Integer size) throws RepositoryAccessException {

        AddressPagesResponseDTO addressPagesResponseDTO;
        Pageable pageable = PageRequest.of(page, size);

        Page<AddressEntity> addressEntityPages = addressRepository.findAll(pageable);

        if(addressEntityPages != null && !addressEntityPages.isEmpty()) {
            addressPagesResponseDTO = addressMapper.entityListToDtoList(addressEntityPages.getContent());
            addressPagesResponseDTO.setSize(addressEntityPages.getSize());
            addressPagesResponseDTO.setCurrentPage(addressEntityPages.getNumber() + 1);
            addressPagesResponseDTO.setTotalPages(addressEntityPages.getTotalPages());
            addressPagesResponseDTO.setTotalElements((int) addressEntityPages.getTotalElements());
            return addressPagesResponseDTO;
        } else {
            throw new RepositoryAccessException(READ_ACCESS_EXCEPTION_NOT_FOUND);
        }

    }

    @Override
    public AddressResponseDTO findAddressById(Long idAddress) throws RepositoryAccessException {

        utils.verifyAddressId(idAddress);

        AddressEntity addressEntity = addressRepository.findById(idAddress).get();

        return addressMapper.entityToDto(addressEntity);

    }

    @Override
    public AddressResponseDTO modifyAddress(Long idClient, Long idAddress, AddressDTO addressDTO) throws RepositoryAccessException {

        utils.verifyClientId(idClient);
        utils.verifyClientAddressId(idClient, idAddress);

        AddressEntity addressEntity = addressMapper.dtoToEntity(addressDTO);
        addressEntity.setIdAddress(idAddress);
        addressEntity.setClient(clientRepository.findById(idClient).get());
        addressRepository.save(addressEntity);

        return addressMapper.entityToDto(addressEntity);
    }

    @Override
    public AddressResponseDTO removeAddress(Long idClient, Long idAddress) throws RepositoryAccessException {

        utils.verifyClientId(idClient);
        utils.verifyClientAddressId(idClient, idAddress);

        AddressEntity addressEntity = addressRepository.findById(idAddress).get();
        AddressResponseDTO addressResponseDTO = addressMapper.entityToDto(addressEntity);

        addressRepository.delete(addressEntity);

        return addressResponseDTO;

    }

}
