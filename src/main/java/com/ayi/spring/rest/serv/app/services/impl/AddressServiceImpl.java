package com.ayi.spring.rest.serv.app.services.impl;

import com.ayi.spring.rest.serv.app.dto.request.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.InvoiceWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.AddressEntity;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.entities.InvoiceEntity;
import com.ayi.spring.rest.serv.app.exceptions.ReadAccessException;
import com.ayi.spring.rest.serv.app.exceptions.WriteAccessException;
import com.ayi.spring.rest.serv.app.mappers.IAddressMapper;
import com.ayi.spring.rest.serv.app.repositories.IAddressRepository;
import com.ayi.spring.rest.serv.app.repositories.IClientRepository;
import com.ayi.spring.rest.serv.app.services.IAddressService;
import com.ayi.spring.rest.serv.app.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public AddressResponseDTO addAddress(Long idClient, AddressDTO addressDTO) throws ReadAccessException {

        utils.verifyClientId(idClient);

        AddressEntity addressEntity = addressMapper.dtoToEntity(addressDTO);
        ClientEntity clientEntity = clientRepository.findById(idClient).get();
        addressEntity.setClient(clientEntity);

        addressRepository.save(addressEntity);

        return addressMapper.entityToDto(addressEntity);

    }

    @Override
    public List<AddressResponseDTO> findAllAddresses() throws ReadAccessException {

        List<AddressResponseDTO> addressResponseDTOList = new ArrayList<>();
        List<AddressEntity> addressEntityList = addressRepository.findAll();

        if(addressEntityList == null) {
            throw new ReadAccessException(READ_ACCESS_EXCEPTION_NOT_FOUND);
        }

        addressEntityList.forEach(address -> {
            AddressResponseDTO addressResponseDTO = addressMapper.entityToDto(address);
            addressResponseDTOList.add(addressResponseDTO);
        });

        return addressResponseDTOList;

    }

    @Override
    public AddressResponseDTO findAddressById(Long idAddress) throws ReadAccessException {

        utils.verifyAddressId(idAddress);

        AddressEntity addressEntity = addressRepository.findById(idAddress).get();

        return addressMapper.entityToDto(addressEntity);

    }

    @Override
    public AddressResponseDTO modifyAddress(Long idClient, Long idAddress, AddressDTO addressDTO) throws ReadAccessException {

        utils.verifyClientId(idClient);
        utils.verifyClientAddressId(idClient, idAddress);

        AddressEntity addressEntity = addressMapper.dtoToEntity(addressDTO);
        addressEntity.setIdAddress(idAddress);
        addressEntity.setClient(clientRepository.findById(idClient).get());
        addressRepository.save(addressEntity);

        return addressMapper.entityToDto(addressEntity);
    }

    @Override
    public AddressResponseDTO removeAddress(Long idClient, Long idAddress) throws ReadAccessException {

        utils.verifyClientId(idClient);
        utils.verifyClientAddressId(idClient, idAddress);

        AddressEntity addressEntity = addressRepository.findById(idAddress).get();
        AddressResponseDTO addressResponseDTO = addressMapper.entityToDto(addressEntity);

        addressRepository.deleteById(idAddress);

        return addressResponseDTO;

    }

}
