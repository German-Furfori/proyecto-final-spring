package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.details.DetailsDTO;
import com.ayi.spring.rest.serv.app.dto.response.details.DetailsPagesResponseDTO;
import com.ayi.spring.rest.serv.app.dto.response.details.DetailsWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.entities.DetailsEntity;

import java.util.List;

public interface IDetailsMapper {
    DetailsWithClientResponseDTO entityToDto(DetailsEntity entity);

    DetailsEntity dtoToEntity(DetailsDTO dto);

    DetailsPagesResponseDTO entityListToDtoList(List<DetailsEntity> detailsEntityList);

    DetailsEntity toEntityByRequest(DetailsDTO dto);
}
