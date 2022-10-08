package com.ayi.spring.rest.serv.app.mappers.impl;

import com.ayi.spring.rest.serv.app.dto.request.DetailsDTO;
import com.ayi.spring.rest.serv.app.dto.response.DetailsWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.DetailsEntity;
import com.ayi.spring.rest.serv.app.mappers.IDetailsMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DetailsMapperImpl implements IDetailsMapper {
    private final ModelMapper modelMapper;

    @Override
    public DetailsWithClientResponseDTO entityToDto(DetailsEntity entity) {
        DetailsWithClientResponseDTO detailsWithClientResponseDTO = new DetailsWithClientResponseDTO();
        modelMapper.map(entity, detailsWithClientResponseDTO);
        return detailsWithClientResponseDTO;
    }

    @Override
    public DetailsEntity dtoToEntity(DetailsDTO dto) {
        DetailsEntity detailsEntity = new DetailsEntity();
        modelMapper.map(dto, detailsEntity);
        return detailsEntity;
    }

    @Override
    public DetailsEntity toEntityByRequest(DetailsDTO dto) {
        DetailsEntity detailsEntity = new DetailsEntity();
        modelMapper.map(dto, detailsEntity);
        return detailsEntity;
    }
}
