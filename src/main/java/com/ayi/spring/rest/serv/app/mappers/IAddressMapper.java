package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.AddressDTO;
import com.ayi.spring.rest.serv.app.dto.response.AddressResponseDTO;
import com.ayi.spring.rest.serv.app.entities.AddressEntity;

public interface IAddressMapper {
    AddressResponseDTO entityToDto(AddressEntity entity);

    AddressEntity dtoToEntity(AddressDTO dto);

    AddressEntity toEntityByRequest(AddressDTO dto);
}
