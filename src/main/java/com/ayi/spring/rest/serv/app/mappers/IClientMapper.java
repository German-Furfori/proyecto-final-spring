package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;

public interface IClientMapper {
    ClientResponseDTO entityToDto(ClientEntity entity);

    ClientEntity dtoToEntity(ClientOnlyDTO dto);

    ClientEntity fullDtoToEntity(ClientFullDTO dto);

    ClientEntity toEntityByRequest(ClientOnlyDTO dto);
}
