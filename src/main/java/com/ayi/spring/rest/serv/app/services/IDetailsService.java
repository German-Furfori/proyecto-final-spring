package com.ayi.spring.rest.serv.app.services;

import com.ayi.spring.rest.serv.app.dto.request.DetailsDTO;
import com.ayi.spring.rest.serv.app.dto.response.DetailsWithClientResponseDTO;
import com.ayi.spring.rest.serv.app.exceptions.GenericException;

import java.util.List;

public interface IDetailsService {

    List<DetailsWithClientResponseDTO> findAllDetails() throws GenericException;

    DetailsWithClientResponseDTO modifyDetails(Long id, DetailsDTO detailsDTO) throws GenericException;
}
