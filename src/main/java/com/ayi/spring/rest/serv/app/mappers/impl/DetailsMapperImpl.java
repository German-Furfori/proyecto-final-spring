package com.ayi.spring.rest.serv.app.mappers.impl;

import com.ayi.spring.rest.serv.app.dto.request.details.DetailsDTO;
import com.ayi.spring.rest.serv.app.dto.response.details.DetailsPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.details.DetailsWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.DetailsEntity;
import com.ayi.spring.rest.serv.app.mappers.IDetailsMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public DetailsPagesResponseDTO entityListToDtoList(List<DetailsEntity> detailsEntityList) {
        DetailsPagesResponseDTO detailsPagesResponseDTO = new DetailsPagesResponseDTO();
        List<DetailsWithClientResponseDTO> detailsWithClientResponseDTOList = new ArrayList<>();

        detailsEntityList.forEach(detailsEntity -> {
            DetailsWithClientResponseDTO detailsWithClientResponseDTO = new DetailsWithClientResponseDTO();
            modelMapper.map(detailsEntity, detailsWithClientResponseDTO);
            detailsWithClientResponseDTOList.add(detailsWithClientResponseDTO);
        });

        detailsPagesResponseDTO.setDetailsWithClientResponseDTOList(detailsWithClientResponseDTOList);
        return detailsPagesResponseDTO;
    }

    @Override
    public DetailsEntity toEntityByRequest(DetailsDTO dto) {
        DetailsEntity detailsEntity = new DetailsEntity();
        modelMapper.map(dto, detailsEntity);
        return detailsEntity;
    }
}
