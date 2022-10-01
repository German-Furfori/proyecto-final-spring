package com.ayi.spring.rest.serv.app.mappers.impl;

import com.ayi.spring.rest.serv.app.dto.request.DetailsDTO;
import com.ayi.spring.rest.serv.app.dto.response.DetailsResponseDTO;
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
    public DetailsResponseDTO entityToDto(DetailsEntity entity) {
        DetailsResponseDTO detailsResponseDTO = new DetailsResponseDTO();
        modelMapper.map(entity, detailsResponseDTO);
        return detailsResponseDTO;
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
