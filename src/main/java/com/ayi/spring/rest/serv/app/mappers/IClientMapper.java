package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.ClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;

public interface IClientMapper {
    ClientResponseDTO entityToDto(ClientEntity entity);

    ClientEntity dtoToEntity(ClientDTO dto);

    ClientEntity toEntityByRequest(ClientDTO dto);
}
