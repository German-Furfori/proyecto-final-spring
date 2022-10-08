package com.ayi.spring.rest.serv.app.mappers.impl;

import com.ayi.spring.rest.serv.app.dto.request.address.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.address.AddressPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.address.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.entities.AddressEntity;
import com.ayi.spring.rest.serv.app.mappers.IAddressMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public AddressPagesResponseDTO entityListToDtoList(List<AddressEntity> addressEntityList) {
        AddressPagesResponseDTO addressPagesResponseDTO = new AddressPagesResponseDTO();
        List<AddressResponseDTO> addressResponseDTOList = new ArrayList<>();

        addressEntityList.forEach(addressEntity -> {
            AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
            modelMapper.map(addressEntity, addressResponseDTO);
            addressResponseDTOList.add(addressResponseDTO);
        });

        addressPagesResponseDTO.setAddressResponseDTOList(addressResponseDTOList);
        return addressPagesResponseDTO;
    }

    @Override
    public AddressEntity toEntityByRequest(AddressDTO dto) {
        AddressEntity addressEntity = new AddressEntity();
        modelMapper.map(dto, addressEntity);
        return addressEntity;
    }
}
