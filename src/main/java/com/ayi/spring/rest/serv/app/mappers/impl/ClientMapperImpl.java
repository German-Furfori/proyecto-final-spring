package com.ayi.spring.rest.serv.app.mappers.impl;

import com.ayi.spring.rest.serv.app.dto.request.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientOnlyResponseDTO;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.mappers.IClientMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientMapperImpl implements IClientMapper {
    private final ModelMapper modelMapper;

    @Override
    public ClientFullResponseDTO entityToFullDto(ClientEntity entity) {
        ClientFullResponseDTO clientFullResponseDTO = new ClientFullResponseDTO();
        modelMapper.map(entity, clientFullResponseDTO);
        return clientFullResponseDTO;
    }

    @Override
    public ClientOnlyResponseDTO entityToOnlyDto(ClientEntity entity) {
        ClientOnlyResponseDTO clientOnlyResponseDTO = new ClientOnlyResponseDTO();
        modelMapper.map(entity, clientOnlyResponseDTO);
        return clientOnlyResponseDTO;
    }

    @Override
    public ClientEntity dtoOnlyToEntity(ClientOnlyDTO dto) {
        ClientEntity clientEntity = new ClientEntity();
        modelMapper.map(dto, clientEntity);
        return clientEntity;
    }

    @Override
    public ClientEntity fullDtoToEntity(ClientFullDTO dto) {
        ClientEntity clientEntity = new ClientEntity();
        modelMapper.map(dto, clientEntity);
        return clientEntity;
    }

    @Override
    public ClientEntity toEntityByRequest(ClientOnlyDTO dto) {
        ClientEntity clientEntity = new ClientEntity();
        modelMapper.map(dto, clientEntity);
        return clientEntity;
    }
}
