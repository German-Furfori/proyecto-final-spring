package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientOnlyResponseDTO;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;

public interface IClientMapper {
    ClientFullResponseDTO entityToFullDto(ClientEntity entity);

    ClientOnlyResponseDTO entityToOnlyDto(ClientEntity entity);

    ClientEntity dtoOnlyToEntity(ClientOnlyDTO dto);

    ClientEntity fullDtoToEntity(ClientFullDTO dto);

    ClientEntity toEntityByRequest(ClientOnlyDTO dto);
}
