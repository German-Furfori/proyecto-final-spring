package com.ayi.spring.rest.serv.app.mappers.impl;

import com.ayi.spring.rest.serv.app.dto.request.ClientDTO;
import com.ayi.spring.rest.serv.app.dto.response.ClientResponseDTO;
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
    public ClientResponseDTO entityToDto(ClientEntity entity) {
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
        modelMapper.map(entity, clientResponseDTO);
        return clientResponseDTO;
    }

    @Override
    public ClientEntity dtoToEntity(ClientDTO dto) {
        ClientEntity clientEntity = new ClientEntity();
        modelMapper.map(dto, clientEntity);
        return clientEntity;
    }

    @Override
    public ClientEntity toEntityByRequest(ClientDTO dto) {
        ClientEntity clientEntity = new ClientEntity();
        modelMapper.map(dto, clientEntity);
        return clientEntity;
    }
}
