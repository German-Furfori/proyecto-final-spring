package com.ayi.spring.rest.serv.app.mappers.impl;

import com.ayi.spring.rest.serv.app.dto.request.client.ClientFullDTO;
import com.ayi.spring.rest.serv.app.dto.request.client.ClientOnlyDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientFullPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientFullResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.client.ClientOnlyResponseDTO;
import com.ayi.spring.rest.serv.app.entities.ClientEntity;
import com.ayi.spring.rest.serv.app.mappers.IClientMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

        clientEntity.getAddressList().forEach(addressEntity -> {
            addressEntity.setClient(clientEntity);
        });

        return clientEntity;
    }

    @Override
    public ClientFullPagesResponseDTO entityListToDtoList(List<ClientEntity> clientEntityList) {
        ClientFullPagesResponseDTO clientFullPagesResponseDTO = new ClientFullPagesResponseDTO();
        List<ClientFullResponseDTO> clientFullResponseDTOList = new ArrayList<>();

        clientEntityList.forEach(clientEntity -> {
            ClientFullResponseDTO clientFullResponseDTO = new ClientFullResponseDTO();
            modelMapper.map(clientEntity, clientFullResponseDTO);
            clientFullResponseDTOList.add(clientFullResponseDTO);
        });

        clientFullPagesResponseDTO.setClientFullResponseDTOList(clientFullResponseDTOList);
        return clientFullPagesResponseDTO;
    }

    @Override
    public ClientEntity toEntityByRequest(ClientOnlyDTO dto) {
        ClientEntity clientEntity = new ClientEntity();
        modelMapper.map(dto, clientEntity);
        return clientEntity;
    }
}
