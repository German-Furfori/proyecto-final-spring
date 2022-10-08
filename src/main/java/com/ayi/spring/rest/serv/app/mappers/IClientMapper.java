package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.client.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.client.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientFullPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientOnlyResponseDTO;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;

import java.util.List;

public interface IClientMapper {
    ClientFullResponseDTO entityToFullDto(ClientEntity entity);

    ClientOnlyResponseDTO entityToOnlyDto(ClientEntity entity);

    ClientEntity dtoOnlyToEntity(ClientOnlyDTO dto);

    ClientEntity fullDtoToEntity(ClientFullDTO dto);

    ClientFullPagesResponseDTO entityListToDtoList(List<ClientEntity> clientEntityList);

    ClientEntity toEntityByRequest(ClientOnlyDTO dto);
}
