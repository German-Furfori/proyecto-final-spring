package com.ayi.spring.rest.serv.app.mappers.impl;

import com.ayi.spring.rest.serv.app.dto.request.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.entities.AddressEntity;
import com.ayi.spring.rest.serv.app.mappers.IAddressMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressMapperImpl implements IAddressMapper {
    private final ModelMapper modelMapper;

    @Override
    public AddressResponseDTO entityToDto(AddressEntity entity) {
        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
        modelMapper.map(entity, addressResponseDTO);
        return addressResponseDTO;
    }

    @Override
    public AddressEntity dtoToEntity(AddressDTO dto) {
        AddressEntity addressEntity = new AddressEntity();
        modelMapper.map(dto, addressEntity);
        return addressEntity;
    }

    @Override
    public AddressEntity toEntityByRequest(AddressDTO dto) {
        AddressEntity addressEntity = new AddressEntity();
        modelMapper.map(dto, addressEntity);
        return addressEntity;
    }
}
