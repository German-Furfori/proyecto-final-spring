package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.address.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.address.AddressPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.address.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.entities.AddressEntity;

import java.util.List;

public interface IAddressMapper {
    AddressResponseDTO entityToDto(AddressEntity entity);

    AddressEntity dtoToEntity(AddressDTO dto);

    AddressPagesResponseDTO entityListToDtoList(List<AddressEntity> addressEntityList);

    AddressEntity toEntityByRequest(AddressDTO dto);
}
