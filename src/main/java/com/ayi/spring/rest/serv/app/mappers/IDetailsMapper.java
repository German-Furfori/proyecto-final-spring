package com.ayi.spring.rest.serv.app.mappers;

import com.ayi.spring.rest.serv.app.dto.request.DetailsDTO;
import com.ayi.spring.rest.serv.app.dto.response.DetailsResponseDTO;
import com.ayi.spring.rest.serv.app.entities.DetailsEntity;

public interface IDetailsMapper {
    DetailsResponseDTO entityToDto(DetailsEntity entity);

    DetailsEntity dtoToEntity(DetailsDTO dto);

    DetailsEntity toEntityByRequest(DetailsDTO dto);
}
